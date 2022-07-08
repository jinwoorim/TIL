## Repository 인터페이스

- Mybatis의 경우 sql작성하는 mapper클래스와 DAO 클래스가 둘다 있어야하지만 JPA는 이 인터페이스 클래스 하나로 퉁침

- JpaRepository를 상속해야한다
```shell
extends JpaRepository<Entity클래스이름, 식별자 변수의 타입>
```

## Controller 클래스

```shell
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user")
	public String insertUser(@RequestBody User user) { //@RequestBody : JSON -> 자바객체로변환
		
		userRepository.save(user); // save() 메소드는 등록, 수정을 모두 처리할 때 사용한다. insert쿼리가 자동으로 생성된다
		return user.getUsername() + "님 회원가입 성공";
	}	
	
	@GetMapping("/user/get/{id}")
	public User getUser(@PathVariable int id) {
		// 특정 id(회원번호)에 해당하는 User 객체를 리턴한다
		Optional<User> findUser = userRepository.findById(id);// findById() 메소드는 Primary Key에 해당하는 데이터에 대한 상세조회. 상세조회 쿼리가 자동생성
		if(findUser.isPresent()) {//isPresent : 검색 결과가 있다면 true
			return findUser.get();
		}else {
			return new User(); //값들이 null인 User 객체를 리턴하겠다. null인 User 객체를 리턴해주지않으면, 만약 검색결과가 없을때 Optional에 의해 NullPointException 에러뜸
		}
	}
	
	@GetMapping("/user/list")
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@GetMapping("/user/page") //paging을 동적으로 하려면 URI요청에 user/page?page=1&size2
	public Page<User> getUserListPaging(
		@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, 
				sort = {"id"}) Pageable pageable) {
		// 첫 번째 페이지(0)에 해당하는 2개의 데이터를 조회하되 id를 내림 차순 정렬한다.
		return userRepository.findAll(pageable);
	}
	
	@PutMapping("/user")
	//@Transactional //userRepository.save(findUser);을 대신할수 있다
	public String updateUser(@RequestBody User user) {
		Optional<User> findEntity = userRepository.findById(user.getId());
		if(findEntity.isPresent()) {
			User findUser = findEntity.get();
			findUser.setUsername(user.getUsername());
			findUser.setPassword(user.getPassword());
			findUser.setEmail(user.getEmail());
			userRepository.save(findUser);
			return "회원 수정 성공";
		} else {
			return user.getId() + "번 회원이 없습니다.";
		}
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "회원 삭제 성공";
	}
}
```
