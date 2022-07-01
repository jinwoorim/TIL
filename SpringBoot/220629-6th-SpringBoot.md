## 자동 설정

- 애플리케이션을 운영하기 위해서는 두종류의 객체가 필요하다

- 예를 들어, 스프링이 제공해주는 HandlerMapping이나 ViewResolver 같은 스프링이 제공해주는 객체와 내가 만든 Controller 객체가 필요하다

- @ComponentScan : 내가 만든 클래스 객체

- @EnableAutoConfiguration : 스프링이 제공해주는 클래스 객체(수십가지 클래스 제공 HandlerMapping, ViewResolver 이런거 다있음)

- @ComponentScan를 먼저 메모리에 띄우고 @EnableAutoConfiguration을 메모리에 띄운다

- @ComponentScan @EnableAutoConfiguration는 @SpringBootApplication에 포함되어있다.

- @EnableAutoConfiguration하게되면 spring-boot-autoconfigure.jar 라이브러리 안에 META-INF폴터안에 spring.factories파일안에 수많은 자동 설정 클래스들이 로딩된다

## 자동설정 어노테이션

- @EnableAutoConfiguration에 의해 수많은 라이브러리안에 수많은 클래스들이 다 메모리에 뜨면 낭비

- 따라서 자동설정 어노테이션에 의해 필요한 클래스들만 메모리에 뜨게할 수 있다

- 라이브러리들안에 수많은 클래스들을 보면 자동설정 어노테이션들이 설정되어있다

- 이 어노테이션들의 설정 조건에 따라 해당되는 클래스들만 메모리에 띄운다

- @ConditionalOnWebApplication

    - Main 클래스의 WebApplicationType 설정확인. 일반자바애플리케이션(none)인지 웹애플리케이션인지(디폴트: servlet)

- @ConditionalOnClass

    - 특정 클래스가 클래스 패스 상에 존재할때 적용

- @ConditionalOnMissingBean

    - 특정 객체가 메모리에 없을때 작동시켜라

- @AutoConfigureOrder

- @AutoConfigureAfter

## 사용자 정의 자동 설정 (내가 만든 자동 설정) 

```shell
	1. 사용자 정의 스타터 프로젝트 파일에서 pom.xml에 autoconfigure dependency 적용(MVNrepository 사이트에서 autoconfigure 검색해서 가져와서)
	2. 이 autoconfigure를 dependency 적용하면 jar파일이 Maven Dependencies 폴더안에 생긴다
	3. 이 jar파일안에 EnableAutoConfiguration 클래스가 들어있다
	4. 이 클래스는 하는일이 모든 META-INF 폴더 밑에 spring.factories를 로딩한다
	5. 따라서, spring.factories에 org.springframework.boot.autoconfigure.EnableAutoConfiguration = \을 등록
	6. 내가 만든 자동설정 클래스도 같이 등록 
	7. 프로젝트 run as maven install 하고 close project    
```
