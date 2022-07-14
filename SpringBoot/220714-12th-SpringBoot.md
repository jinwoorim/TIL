## Spring Security

- 로그인 인증처리를 도와주는 스타터

- 스타터를 pom.xml에 다운받고 어플리케이션 실행하면 기본적으로 password(랜덤)가 제공된다.

- 로그인화면도 제공된다(그런 jar를 다운받을때 제공받는다)

- 아이디는 user

## Customizing하기

- Spring이 제공해주는 security를 내맘대로 customizing할 수 있다

- security 스타터를 다운받으면 security와 관련된 객체들이 있을 것이고 그 객체들이 자동설정 클래스에 의해 메모리에 올라간다 그 자동설정 클래스를 비활성화시켜야 customizing 가능

- Spring Security는 loginController도 자동제공(컨트롤러 따로 안만들어도됨)

## Configuration class

```shell

@Configuration
@EnableWebSecurity // @EnableWebSecurity : security를 customizing하기 위해서 security와 관련된 몇몇 객체들 제거
                   // extends WebSecurityConfigurerAdapter : security를 customizing하기 위해서 security와 관련된 몇몇 객체들 제거
public class BankWebMvcConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override // security가 기본으로 제공해주는 계정 사용하지않겠다
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 다음 경로에 대한 요청은 인증 없이 접근을 허용한다. 이미지나 js파일, css관련 webjar도 허용해줘야한다.
		http.authorizeRequests().antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**").permitAll();
		
		// 위에서 언급한 경로 외에는 모두 인증을 거치도록 설정한다
		http.authorizeRequests().anyRequest().authenticated();
		
		// 시큐리티가 제공하는 기본 로그인 화면은 CSRF 토큰을 무조건 전달한다
		// 하지만 사용자 정의 로그인 화면에서는 CSRF 토큰을 전달하지 않는다
		http.csrf().disable();
		
		// 사용자가 만든 로그인 화면을 띄운다
		http.formLogin().loginPage("/auth/login");
		
		// 로그아웃 설정
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/"); // 디폴트는 logoutUrl("/logout"), logoutSuccessUrl("/") : 로그아웃 성공시 index 페이지로 이동
	}
}

```

## Security가 제공하는 아이디 비번이 DB의 회원정보를 가지고 로그인하는 방법

- 총 두가지 클래스를 만들어야한다
    - UserDetails를 implements 한 클래스
    - UserDetailsService 를 implements 한 클래스

- UserDetails를 implements 한 클래스

```shell

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

	// User 엔티티 타입의 참조변수 선언
	private User user;
	
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	// User 엔티티가 가지고 있는 권한 목록을 저장하여 리턴한다
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 목록을 저장할 컬렉션
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		
		// 권한 설정
		roleList.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return "ROLE_" + user.getRole();
			}
		});
		return roleList;
	}

	@Override
	public String getPassword() {
		// "{noop}" 은 security가 제공하는 비밀번호를 자동으로 암호화하지않겠다. 실제 DB 회원의 비밀번호로 대체하겠다
		return "{noop}" + user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getUsername();
	}

	// 계정이 만료됬는지 여부를 리턴한다
	@Override
	public boolean isAccountNonExpired() {

		return true; // 계정은 만료되지 않았다
	}

	// 계정이 잠겨있는지 여부를 리턴한다
	@Override
	public boolean isAccountNonLocked() {

		return true; // 안 잠겨있다
	}

	// 비밀번호가 만료됬는지 여부를 리턴한다
	@Override
	public boolean isCredentialsNonExpired() {

		return true; // 비밀번호가 만료되지 않았다
	}

	// 계정의 활성화 여부를 리턴한다
	@Override
	public boolean isEnabled() {

		return true; // 계정이 활성화되있다
	}
}

```

- UserDetailsService 를 implements 한 클래스

```shell

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username).get();
		return new UserDetailsImpl(principal);
	}

}

```

## CSRF 토큰이란, CSRF 공격이란

- CSRF 토큰

    - 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식
    - 서버에서 브라우저에 데이터를 전송할때 CSRF 토큰을 같이 전송
    - 사용자가 POST 방식 등으로 작업 할 때 브라우저에서 전송된 CSRF 토큰값과 서버가 보관하고 있는 토큰의 값을 비교
    - 만일 CSRF 토큰값이 다르면 작업X

- CSRF 공격

    - 공격자가 CSRF 스크립트가 포함된 게시물을 서버에 등록
    - 서버 관리자는 공격자가 등록한 CSRF 스크립트가 포함된 게시물을 확인
    - 관리자가 CSRF 스크립트가 포함된 게시물을 열람하면 관리자의 권한으로 공격자가 원하는 CSRF 스크립트 요청이 발생
    - 공격자가 원하는 CSRF 스크립트가 실행되어 정보 유출됨
