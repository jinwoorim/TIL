## Spring MVC

```shell

 Model : VO,DAO 클래스 (자바 개발자)

 View : JSP (웹디자이너)

 Controller : Servlet 클래스 (MVC 프레임워크)

```

## Spring MVC 프레임워크

- 실습 때 프레임워크 이용없이 직접 DispatcherServlet과 HandlerMapping, Controller(인터페이스), 여러Controller들 만들었음(이해를위해)

- Spring이 DispatcherServlet과 HandlerMapping, Controller를 제공해준다

## Servlet Container와 Spring Container의 관계 및 적용

```shell

	1. 톰켓 서버가 구동되면 Servlet Container 생성
	2. Web.xml 읽어들임(Web.xml에는 org.springframework.web.servlet.DispatcherServlet 등록)
	3. 브라우저 요청 들어오면 Servlet Container가 DispatcherServlet 객체 생성
	4. DispatcherServlet의 init메서드(new XmlWebApplicationContext()) 실행되서 Spring Container 생성
	5. Spring Container가 presentation-layer.xml 읽어들임(presentation-layer.xml에는 HandlerMapping, Controller 가 bean 등록)

```
## ViewResolver

- 브라우저에서 직접적인 jsp 파일의 접근을 막기위함

- presentation-layer.xml 에 ViewResolver를 bean 등록한다 (Spring이 제공해주는)

- property 태크를 이용해 jsp파일위치의 접두사와 접미사를 설정

- view정보를 리턴해줄때 jsp 파일이 아닌 곳으로 이동할때는 ViewResolver를 적용하지 않기 위해서 (forward: or redirect:)를 붙인다 

## Annotation 기반의 MVC 설정

- presentation-layer.xml(Spring container가 읽어들이는 xml파일) 에 context:component-scan로 controller들 설정

- controller 클래스들 위에 @Controller 설정

- 해당 controller 클래스의 메소드위에 @RequestMapping("어떤 브라우저 요청이 들어왓을때") 설정

- 해당 controller 클래스의 메소드를 POJO로 만들 수 있다(리턴 타입 내맘대로, 메소드 이름 내맘대로, 매개변수 내맘대로)
