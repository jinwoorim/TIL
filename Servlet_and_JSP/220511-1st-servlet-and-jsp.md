# HTTP(HyperText Transfer Protocol) 

- 브라우저와 서버가 통신할때 쓰는 통신 규약

- 프로토콜 : 어떠한 데이터를 전달할때 똑같은 형태로 하자는 약속이기 때문에 변경시 다 바꾸어줘야하기 변경이 어렵다  

## HTTP 특징

- 비연결성 : 브라우저가 서버쪽에 데이터를 요청하는 순간 서로 연결되는데 응답 후에는 연결이 끊어진다.

- 무상태 : 서버가 클라이언트의 상태 정보를 유지하지 않는다

- 따라서, 상태 정보를 유지하기 위해 쿠키나 세션을 사용한다

## HTTP 요청 프로토콜

### HTTP 요청 URL

- 브라우저가 서버에게 요청

- URL을 통해 요청되며 URL에는 다양한 정보를 포함한다

### HTTP 요청 프로토콜 구조

- start-line, message-header, messager-body로 구성

start-line : 요청방식,요청 URI, 프로토콜/버전으로 구성

```shell

[요청방식]

GET(조회), POST(등록), PUT(수정), DELETE(삭제)

```

message-header : Key Value로 설정되는데 보통 브라우저와 관련된 정보이다.

messager-body : 사용자가 입력한 정보. start-line에 설정된 요청방식에 따라 상태가 달리짐

## HTTP 응답 프로토콜

- 서버에서 브라우저에게 요청

###  HTTP 응답 프로토콜 구조

- status-line, message-header, message-body로 구성

status-line : HTTP버전, 상태코드, 상태메시지로 구성

```shell

[상태코드]

200 : 정상처리
403 : 접근x
404 : 서버존재x
405 : 요청방식을 지원하지않음
500 : Exception 발생

```
message-header : 서버가 브라우저한테 응답하는 문서정보

message-body : 요청한 문서의 실질적정보

##get방식 post방식
