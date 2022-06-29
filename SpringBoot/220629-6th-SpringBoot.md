## 자동 설정

- 애플리케이션을 운영하기 위해서는 두종류의 객체가 필요하다

- 예를 들어, 스프링이 제공해주는 HandlerMapping이나 ViewResolver 같은 스프링이 제공해주는 객체와 내가 만든 Controller 객체가 필요하다

- @ComponentScan : 내가 만든 클래스 객체

- @EnableAutoConfiguration : 스프링이 제공해주는 클래스 객체(수십가지 클래스 제공 HandlerMapping, ViewResolver 이런거 다있음)

- @ComponentScan를 먼저 메모리에 띄우고 @EnableAutoConfiguration을 메모리에 띄운다

- @ComponentScan @EnableAutoConfiguration는 @SpringBootApplication에 포함되어있다.
