# 상태 정보 유지

- 요청한 브라우저가 로그인을 한 상태인지 아닌지 Servlet이 식별할 수 있게하는것

## Cookie

- 상태 정보 를 브라우저쪽 pc에 저장

- 텍스트 형태만 저장가능

- 저장에 대한 제한이 있음

## Session

- 상태 정보를 서버에 저장

- 모든 타입 저장가능

- 메모리범위를 넘지않는 한 저장가능

- 브라우저 하나당 세션객체가 생성되고 세션 ID는 유니크하게 가진다

# 정보 공유

- HttpServletRequest :포워딩 관계에 있는 서브릿간에서 getAttribute로 가져다 쓸수있다. Request 객체는 서버가 브라우저에 응답하는 순간 삭제

- HttpSession : 다른 서브릿에서 getAttribute로 가져다 쓸수있다(브라우저가 살아있는 동안 유지)

- ServletContext : 다른 서브릿에서 getAttribute로 가져다 쓸수있다(브라우저가 죽어도 유지)

# Filter

- 특정 Servlet 실행 전과후에 작업을 할 수있다(대표적으로 encoding,currentTimeMills() 메소드를 통해 Servlet 실행 시간을 알때도 쓴다)

- 필터는 web.xml에 적용되고 pre-loading 방식이기에 서버구동되면 생성된다. 

- annotation 가능

# Listener

- 이벤트 처리용(request, session, context)

- 필터보다 먼저 생성됨

- annotation 가능
