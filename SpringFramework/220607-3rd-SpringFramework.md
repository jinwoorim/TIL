## <context:component-scan base-package="패키지명"/> 중요 포인트

- base-package로 지정한 패키지로 시작하는 모든 클래스를 스캔한다

## @Autowired

- 주로 변수 위에 설정하여 해당 타입의 객체를 찾아서 자동 할당

- 해당 타입의 객체가 반드시 메모리에 있어야함(해당 객체 클래스에 @component 설정이 되있어야함)

- 유니크하게 존재해야만 한다(해당 타입의 객체를 implements한 클래스가 여러개일 경우 각각의 클래스에 @component가 설정되있다면 어떤 클래스의 객체를 할당해야하는지 모름)

## 유지보수(운영)과정

- 변경되는 객체는 XML 파일에 bean 등록한다

- 변경되지 않는 객체는 최대한 @components를 적용한다

## @components 세분화

- @Service : 비즈니스 로직을 처리

- @Repository : DB 연동 처리

- @Controller : 사용자 요청 제어

## 컴포넌트(Component)란?

- 부품처럼 사용할 수 있는 소프트웨어 모듈

- 일반적으로 소프트웨어 컴포넌트는 테이블 당 하나씩 작성하며, 테이블에 대한 CRUD 작업을 처리한다.

- CRUD(Create(insert), Read(Select), Update, Delete)

- VO, DAO, Service(인터페이스), ServiceImpl로 구성

- ServiceClient는 메인클래스
