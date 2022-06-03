# Spring Container(GenericXmlApllicationContext / Web 만들 때는 XmlWebApplicationContext)

- XML에 등록된 객체를 Pre-loading 한다

- Pre-loading : 컨테이너가 생성될 때 자동으로 XML에 등록된 객체를 생성한다

- 객체를 생성할 때 디폴트 생성자만 호출한다

- 스프링 컨테이너는 XML에 등록된 순서대로 객체를 생성한다

# IoC(Inversion of Control) 역제어(제어의 역전) <= 스프링을 쓰는 가장 큰 장점

- 역제어란 : 어플리케이션 운용에 필요한 객체의 생성과 객체들 간의 의존관계를 자바 코드가 아닌 컨테이너가 모두 처리하는것

- 순제어란 : 우리가 객체생성할 때 new해서 직접 객체 생성하는것. 실행되는 객체를 바꾸기위해 우리는 손수 new 머시기 했던 자바코드를 수정해야된다. 전통적인 자바프로그래밍 방식. 

- 역제어의 장점 : 자바코드를 전혀 수정하지않고 실행되는 객체를 바꿔치기할 수 있다. XML만 수정하면됨

- IoC의 기능은 dependency lookup 과 dependency injection 로 나뉜다

## Lookup

- 스프링 컨테이너로부터 id가 "id"인 ??타입의 객체를 획득하는것

- ex) : TV tv1 = (TV) 컨테이너 참조변수.getBean("id")

## XML 파일에서 xmlns(네임스페이스)

- XML 파일에 xmlns는 xmlns 여기에 등록된 태그만 쓸 수 있다

- 새로운 네임스페이스를 추가한다는 것은 다른 태그들 즉, 다른 종류의 작업을 지시 가능하도록 한다 

## XML 파일에서 <bean> 태크

- <bean> 태크를 사용해서 스프링 컨터이너가 xml 파일을 읽어들일 때 자동생성할 객체에 대한 클래스를 작성한다

- <bean> 태그에는 id가 생략 가능하다. 하지만 class 속성은 필수다

- id 속성 값은 반드시 전체 객체에서 유일해야한다

- id 속성 값은 자바의 변수명 규칙을 적용한다.(숫자로 시작할 수 없고, 공백포함 할 수 없고, 특수문자x)버전 업되고는 가능하게되었다

- init-method = "메소드" : 컨테이너가 생성(구동)될 때 자동으로 <bean>태그에 등록된 class에서 "메소드"를 호출한다 

- destroy-method = "메소드" : 컨터이너가 종료될 때 <bean>태그에 등록된 class에서 "메소드"를 호출한다
    - 컨테이너종료 : 컨테이너 참조변수.close();

- lazy-init="true" : 특정 객체를 Pre-loading이 아닌 Lazy-loding으로 생성하도록한다
    - 디폴트는  lazy-init="false"

- scope="prototype" : 특정 객체를 요청(gerBean()) 할 때 마다 새로운 객체를 생성하여 리턴한다.즉, 새로운 객체를 생성할때 마다 메모리 주소가 바뀌겠지
    - 디폴트는 scope="singleton" 

## Constructor Injection(dependency injection)

- <constructor-arg> 태그를 이용하여 생성자를 호출한다

- 컨테이너는 디폴트 생성자만 호출하기때문에 매개변수가 다른 생성자를 호출하기 위함

## Setter Injection(dependency injection)

- <property> 태그를 이용하여 생성자를 호출한다

- set 메소드 만드는 것

- p 네임스페이스로 Setter Injection을 간결하게 표한할 수 있지만 가독성이 떨어지므로 비추

## IoC 설정에 Annotation을 적용

- 방대한 양의 xml 코드량을 줄이기 사용 

- <context:component-scan base-package="패키지명"/> 태그를 사용한다

- 스프링 컨테이너로부터 Lookup 할 때 getBean("??") 한 ?? 을 해당 클래스에 @component("??")을 해준다

- @component만 해주면 해당 클래스의 이름을 맨앞을 소문자로하여 취급된다
