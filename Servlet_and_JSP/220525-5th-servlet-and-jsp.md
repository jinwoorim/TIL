# JSP(JavaServer Pages)

- Servlet과 같게 동적 컨텐츠를 처리하기 위함

- 서브릿으로 변환되어 실행됨

## Servlet의 장점

- Servlet은 Java로 구현된 클래스이기 때문에 플랫폼에 독립적(컴파일까지 해놓으면 바이너리(즉0.1의조합)이 아니라 바이트 파일이기때문에
OS에 상관없이 실행가능)

- 멀티 스레드를 제공. 아무리많은 브라우저가 요청을 해도 서블릿객체는 메모리에 하나만 생성된다 예를들어 서비스를 처리하려면 스레드풀에서
스레드가 튀어나와 처리한다( 스레드는 서버엔진이 만든다). 즉, 메모리를 적게 사용

## JSP를 사용하는 이유

- Servlet의 단점을 보완하기 위함

```shell

<Servlet 단점>

1. 규칙을 외워야된다. (뭔가를 import를 해야되고, 반드시 HttpServlet을 상속해야되고, public 클래스로 작성해야되고, 반드시 디폴트 생성자가 
있어야되고, 서비스라든지 do나 post메소드를 오버라이딩해야된다. 매겨변수 리턴타입 등등 어느거 하나 내맘대로 할 수가없다.)

2. 서브릿이 실행하려면 어노테이션이라든지 web.xml에 등록해서 실행되게 하여야만한다

3. 소스를 수정하면 리로딩될때 까지 기다려야됨

4. 자바코드안에 디자인코드(HTML)를 가지고있음(디자인코드를 짤때 자바문법을 고려하면서 짜야됨). 유지보수가 어렵다 아니 불가능한 수준이다.
JSP는 필요정도만 자바 코드가 추가된다.

```

## 주석문(<%-- --%>)

- HTML 주석 : <!-- --!>
- JSP 주석 : <%-- --%>
- HTML 주석은 JSP가 Servlet 클래스로 변환될때 포함된다(유관으로 보여진다) JSP주석은 변환될때 포함안됨

## page 지시자(<%@  %>)

- JSP에서 Servlet 클래쓰로 변환할때 반영할 내용을 작성(인코딩, import 같은것)(<%@page  %>)

```shell

1. isErrorPage : 해당 JSP 파일이 에러 페이지다

2. errorPage : 에러뜨면 이동할 페이지

3. import :변환될때 import할 것들

4. session : session 객체를 사용하려면 request.getsession해서 setattribut 하고 getattribute해서 써야되는데 
jsp에서는 막 쓸 수 있다. 왜냐하면 변환될때 자동으로 session 객체가 생성되므로(내장객체).(session = "true" 생략가능)

```
## include 지시자

- 웹 화면에서 Header와 Footer를 독립된 JSP로 만들고 include하면 공통된 웹화면을 만들 수 있다.

## Scriptlet (<% %>)

- 정상적인 자바 코드가 작성되는 영역

## Expression (<%= %>)

- 메소드 호출할 때

## 내장 객체

- 서버가 JSP를 Servlet으로 변환할 때 지정된 이름으로 변수가 선언되고 변수이름을 바꿀수도없다. 변수에 객체를 자동으로 할당해준다(초기화).

- 내장 객체로는 request, response, pageContext, session, application, config, out이 있다.

- 따라서, Scriptlet과 Expression 안에서 객체를 막 쓸 수 있다.따로 선언하지않고.
