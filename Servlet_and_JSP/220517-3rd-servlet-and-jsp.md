# 쿼리 문자열

- 브라우저가 서버에 정보를 넘기면 name과value 쌍으로 전달이된다

- 요청방식에따라(doGet, doPost) start-line or message-body 내용이 포함된다

# HttpServletRequest 객체 (HttpServletResponse 객체도 비슷)

```shell

1. 브라우저가 서버에 HTTP 요청을 한다
2. Servlet 이 실행되기전에 서버 엔진은 HttpServletRequest 객체를 생성한다
3. HttpServletRequest 객체에는 HTTP 요청 프로토콜로 전달된 수많은 정보들이 세팅된다
4. Servlet이 실행될 때 HttpServletRequest 객체를 매개변수로 받는다
5. 따라서, Servlet에서 request.get~를 통해 그 수많은 정보를 불러올수 있다

```
# HttpServletRequest 메서드

- getParameter("string"); : 입력받은 내용을 파라미터값을 가져올때


- getParameterValues("string") : 입력받은 내용을 파라미터값을 가져올때(checkbox일때) 


- getQueryString(); = URL에서 ? 뒤에 내용을 가져오고싶을때


- request.setCharacterEncoding("UTF-8); : 한글 깨짐 방지

# HttpServletResponse 메서드

- void setContentType("string") : 응답 메시지의 데이터형식을 설정(인코딩 설정)


- PrintWriter getWriter() : HTTP 응답 프로토콜 message-body와 연결된 출력 스트림을 획득


- void sendRedirect("string") : 해당경로를 다시 요청(sendRedirect를 만나는 순간 서버가 브라우저에게 응답을 하고 브라우저가 다시 sendRedirect에 해당경로를 재요청한다. 그리고 서버가 해당경로를 다시 브라우저에게 응답한다. 따라서, 총 두번의 요청응답을 오고간다.URL 또한 변경된다. 단점 : 속도가 느려 장점 : URL이 바뀌니까 어디서 요청이 들어왔는지 유관으로 볼수 있다)

# Servlet Config 객체 (로컬 파라미터)

- 복잡한 Servlet 소스를 수정하지않고 web.xml에서 수정하기 위함

- 다른 Servlet에서는 접근불가 (로컬 파라미터)

- 오버라이딩된 init() 메서드를 통해 web.xml에서 <init - param>에서 설정된 ServletConfig 객체를 인자로 받아 맴버변수를 초기화한다

- 이 또한 annotation으로 설정가능

# Servlet Context 객체 (글로벌 파라미터)

- 모든 Servlet에서 공유할수 있는 파라미터(Servlet 뿐만 아니라 서버엔진이 만든 모든 객체에 접근가능하다)

# 포워딩

- Redirect의 단점인 2번의 요청과 응답이 가기에 느린 속도를 개선(서버 -> 브라우저 -> 서버 -> 브라우저 가 아닌 서버 ->서버로 점프해버린다)

- URL이 바뀌지않음(어디서 응답이 들어왔는지 유관으로 확인이 힘듬)

```shell

RequestDispatcher dispatcher = request.getRequestDispatcher("경로");
dispatcher.forward(request, response);

```
