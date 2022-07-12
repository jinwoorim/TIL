# JOIN

- 여러 테이블간에 관계를 select할때

## Member class

```shell

@Entity
@Data
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private int id;
	
	private String name;
	
	private String city;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE) // "member" = Order Entity의 Member타입 참조변수이름 
	private List<Order> orders = new ArrayList<Order>();		  // @OneToMany는 fetch = FetchType.LAZY가 디폴트. 반대는 EAGER
																  // cascade = CascadeType.REMOVE는 member 한명을 삭제하려면 member가 조인되어있는 order 테이블의 모든 로우를 다 삭제해야 그제서야 삭제가가능한데 그걸 한방에 삭제해주는것 
	
}

```

## Order class

```shell

@Entity
@Table(name = "ORDERS") // ORDER는 예약어
@Data
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private int id;	//주문번호
	
	private String status; //주문상태
	
	@ManyToOne(fetch = FetchType.LAZY) // 주문(Many) : 회원(One) // fetch = FetchType.LAZY : member가 써먹을때 join하고 안써먹으면 join하지마(디폴트는 EAGER)
	@JoinColumn(name = "MEMBER_ID") //Foreign Key
	private Member member; //주문자 정보
}

```

## MemberRepository interface class

```shell

// @Repository 자동 설정해주기때문에 안붙여도되
public interface MemberRepository extends JpaRepository<Member, Integer>{

}

```

## OrderRepository interface class

```shell

public interface OrderRepository extends JpaRepository<Order, Integer>{

}

```

## ManyToOneTest(Junit test) class

```shell

@SpringBootTest
@Transactional // 테스트 시작전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지않는다
class ManyToOneTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	void dataSelect() {
		Optional<Order> findOrder = orderRepository.findById(1);
		if(findOrder.isPresent()) {
			Order order = findOrder.get();
			System.out.println(order.getId() + "번 주문 상세 정보");
			System.out.println("주문 상태 : " + order.getStatus());
			System.out.println("주문자 이름 : " + order.getMember().getName());
			System.out.println("주문자 도시 : " + order.getMember().getCity());
		}
	}

//	@Test
	void dataInsert() {
		// Member 등록
		Member member1 = new Member();
		member1.setName("둘리");
		member1.setCity("서울");
		memberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("또치");
		member2.setCity("대전");
		memberRepository.save(member2);
		
		for (int i = 1; i <= 5 ; i++) {
			Order order = new Order();
			order.setStatus("배송완료");
			order.setMember(member1); // 실제로는 ORDERS 테이블의 MEMBER_ID 컬럼(FK)에 회원의 아이디가 설정된다.
			orderRepository.save(order);
		}
	}

}

```

## OneToManyTest(Junit test) class

```shell

@SpringBootTest
@Transactional
class OneToManyTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void dataSelect() {
		Optional<Member> findMember = memberRepository.findById(1);
		if(findMember.isPresent()) {
			Member member = findMember.get();
			System.out.println(member.getId() + "번 회원 상세 정보");
			System.out.println("회원 이름 : " + member.getName());
			System.out.println("거주 도시 : " + member.getCity());
			
			System.out.println("[주문 목록]");
			for (Order order : member.getOrders()) {
				System.out.println("--->" + order.getId() + ", " + order.getStatus());
			}
		
		}
	}
}

```

## CascadeTest(Junit test) class

```shell

@SpringBootTest
//@Transactional // 입력, 수정, 삭제 같이 DB 데이터가 변경되는 것들은 자동으로 Transactional이 적용되는데 select만 별도로 해줘야함
class CascadeTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void dataDelete() {
		memberRepository.deleteById(1);
		
	}



}

```
