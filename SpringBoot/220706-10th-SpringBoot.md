## Repository 인터페이스

- Mybatis의 경우 sql작성하는 mapper클래스와 DAO 클래스가 둘다 있어야하지만 JPA는 이 인터페이스 클래스 하나로 퉁침

- JpaRepository를 상속해야한다
```shell
extends JpaRepository<Entity클래스이름, 식별자 변수의 타입>
```
