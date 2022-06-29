## @SpringBootApplication(Main클래스 위에 어노테이션)

- 이 어노테이션은 componentscan을 포함하고있다

- 기본적으로 Main 클래스에 설정된 패키지를 기본 scan 범위로한다

- 따라서, 이 패키지 밑에 클래스들도 메모리에 같이 뜬다

## Controller 클래스

- @Controller 어노테이션으로 객체를 메모리에 띄운다

- 브라우저의 요청에 따라 메소드 실행

```shell
	해당 메소드 위에 @RequestMapping(value = "요청 uri", method = RequestMethod.GET)
```

- @ResponseBody : @ResponseBody는 리턴 값을 JSON으로 변환하여 응답 프로토콜 Body에 출력한다(콘솔말고 브라우저에 메세지 띄우기)

- @RestController : 메소드 마다 @ResponseBody를 붙여야하는걸 controller클래스 위에 @RestController 붙여 퉁친다
