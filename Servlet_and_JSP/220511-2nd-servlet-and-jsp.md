# Servlet 작성

- Servlet wizzard를 이용해서 Servlet을 만들게되면 web.xml에도 내용이 자동으로(이클립스가) 추가된다

- Tomcat 서버가 구동되면 서버엔진(Servlet container)가 생성되고 web.xml 파일을 읽어드린다

- web.xml이 수정되면 서버를 다시 구동시켜야된다

- 서버엔진(Servlet container)가 Servlet 객체를 생성한다

- Servlet을 수정하고 저장하면 서버엔진(Servlet container)가 자동으로 리로딩된다(서버를 다시 재구동하지않아도된다)

# 패키징

- WAR파일 : 배포를 위한 패키징 작업

# WEB-INF 폴더

- 웹 어플리케이션의 핵심 자원들이 있기 때문에 브라우저에서 요청이 불가능하다

# Context path 변경 방법

- Servers에 server.xml에서 맨밑에 쪽에 path를 수정해준다
- 포트만 남기고 다 없애고 싶으면 web.xml에서 welcome 수정

# Servlet Container(서버 엔진)

- web.xml을 통해 어떤 객체를 저장하고 관리하는 역할
