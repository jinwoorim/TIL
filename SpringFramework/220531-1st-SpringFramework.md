# Framework란

- 뼈대, 즉 아키텍처다

- Framework를 사용하면 구조를 개발자가 고민하지않지 않는다 개발자가 개발하지않는다

- 개발자는 제공된 뼈대에 살만 붙이면 되는것

- 따라서, 유지보수 과정에서 살만 테스트하면되기 떄문에 유지보수에 유리함

- 정해진 구조를 사용하기 때문에 개발자마다의 역량이 획일화된다

- 개발자가 바뀌더라도 보다 쉽게 접근 가능하다 

- 사용자 입력정보 추출, DB연동 이런걸 한줄로 표현할 수 있기 때문에 소스의 양이 대폭 줄어든다

# Framework 종류

- Presentation (UI) 영역 : Spring(MVC) 모듈

- Business 영역 : Spring(Ioc, AOP) 모듈

- Persistence (DB 연동) 영역 : 

    - JPA : ORM(Object Relation Mapping) 프레임워크. SQL을 자체 생성하여 DB연동처리함. 어렵다
    - MyBatis : 개발자가 SQL을 직접 작성해야한다.
    - 둘 다 DB연동을 자바코드 한줄로 표현 가능하다


# Sring

- 여러 Framework 모듈을 집합해놓은것

- 가볍다 : 모듈들 다 합쳐봐야 용량 얼마 안되고 POJO 기반이기 때문에 메모리를 적게사용한다. 따라서 속도빠름

- POJO(Plain Old Java Object) 기반이다 : 내맘대로 만드는 클래스다. Servlet&JSP 이런건 POJO 이전 기술이다.

- 컨테이너다. 애플리케이션 운용에 필요한 객체를 생성하고 관리한다. 내부적으로 객체들의 저장공간으로 컬렉션(MAP같은)을 사용한다

* MVN REPOSTITORY 사이트 : 오만가지 Framework 를 검색해서 모듈(jar파일) 다운하는곳 
