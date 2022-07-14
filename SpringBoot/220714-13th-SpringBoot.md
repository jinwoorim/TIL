## 쿼리 메소드

- JPA가 제공하는 기능

- 메소드 이름으로 쿼리 생성

- 내가 만든 메소드로도 가능

## Repository interface class

```shell

public interface MemberRepository extends JpaRepository<Member, Integer>{

	List<Member> findByName(String name);
	List<Member> findByNameContaining(String name); // like같은거. 
	List<Member> findByNameContainingOrCityContaining(String name, String city);
	List<Member> findByNameContainingAndCityContaining(String name, String city);
	Page<Member> findByNameContainingOrderByIdDesc(String name, Pageable pageable);
	
	// 내가 만든 쿼리 메소드
	@Query(value = "select member_id, city, name from member where city like '%'||:keyword||'%' order by member_id desc", nativeQuery = true)
	List<Member> getMemberList(@Param("keyword") String keyword);
}

```

## QueryMethodTest(Junit Test)

```shell

@SpringBootTest
class QueryMethodTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	//@BeforeEach
	public void dataInsert() {
		for (int i = 1; i <= 200 ; i++) {
			Member member = new Member();
			member.setName("테스터 " + i);
			member.setCity("서울 " + i);
			memberRepository.save(member);
		}
	}
	
	//@Test
	void queryMethodTest1() {
		List<Member> memberList = memberRepository.findByName("테스터 10");
		
		System.out.println("[검색된 회원 목록]");
		for (Member member : memberList) {
			System.out.println("--->" + member.getName() + " " + member.getId() + " " + member.getCity());
		}
		
	}
	
	//@Test
	void queryMethodTest2() {
		List<Member> memberList = memberRepository.findByNameContaining("스터 10");
		
		System.out.println("[검색된 회원 목록]");
		for (Member member : memberList) {
			System.out.println("--->" + member.getName() + " " + member.getId() + " " + member.getCity());
		}
		
	}
	
	//@Test
	void queryMethodTest3() {
		List<Member> memberList = memberRepository.findByNameContainingOrCityContaining("스터 10", "울 3");
		
		System.out.println("[검색된 회원 목록]");
		for (Member member : memberList) {
			System.out.println("--->" + member.getName() + " " + member.getId() + " " + member.getCity());
		}
		
	}
	
	//@Test
	void queryMethodTest4() {
		List<Member> memberList = memberRepository.findByNameContainingAndCityContaining("스터 10", "울 1");
		
		System.out.println("[검색된 회원 목록]");
		for (Member member : memberList) {
			System.out.println("--->" + member.getName() + " " + member.getId() + " " + member.getCity());
		}
		
	}
	
	
	//@Test
	void queryMethodTest5() {
		Pageable pageable = PageRequest.of(0, 5); // (page number ,size)
		
		Page<Member> pageInfo = memberRepository.findByNameContainingOrderByIdDesc("스터 10", pageable);
		
		System.out.println("[검색된 회원 목록]");
		for (Member member : pageInfo.getContent()) {
			System.out.println("--->" + member.getName() + " " + member.getId() + " " + member.getCity());
		}
		System.out.println("검색된 데이터의 수 : " + pageInfo.getTotalElements());
		System.out.println("전체 페이지의 수 : " + pageInfo.getTotalPages());
		System.out.println("한 페이지에 출력되는 데이터의 수 : " + pageInfo.getSize());
		System.out.println("현재 페이지가 첫번째 페이지인가? : " + pageInfo.isFirst());
		System.out.println("현재 페이지가 마지막 페이지인가? : " + pageInfo.isLast());
	}
	
	@Test
	void queryMethodTest6() {
		List<Member> memberList = memberRepository.getMemberList("09");
		
		System.out.println("[검색된 회원 목록]");
		for (Member member : memberList) {
			System.out.println("--->" + member.getName() + " " + member.getId() + " " + member.getCity());
		}
		
	}
}

```
