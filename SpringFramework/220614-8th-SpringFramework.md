## Spring MVC

```shell

 Model : VO,DAO 클래스 (자바 개발자)

 View : JSP (웹디자이너)

 Controller : Servlet 클래스 (MVC 프레임워크)

```

## Spring MVC 프레임워크

- 실습 때 프레임워크 이용없이 직접 DispatcherServlet과 HandlerMapping, Controller(인터페이스), 여러Controller들 만들었음(이해를위해)

- Spring이 DispatcherServlet과 HandlerMapping, Controller를 제공해준다

## Servlet Container와 Spring Container의 관계

```shell

	1. 톰켓 서버가 구동되면 Servlet Container 생성
	2. Web.xml 읽어들임(Web.xml에는 org.springframework.web.servlet.DispatcherServlet 등록)
	3. 브라우저 요청 들어오면 Servlet Container가 DispatcherServlet 객체 생성
	4. DispatcherServlet의 init메서드(new XmlWebApplicationContext()) 실행되서 Spring Container 생성
	5. Spring Container가 action-servlet-xml 읽어들임(action-servlet-xml에는 HandlerMapping, Controller 가 bean 등록)
```

