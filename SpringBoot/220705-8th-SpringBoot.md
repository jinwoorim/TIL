## REST API

- 서버와 클라이언트 사이에 API를 통해 대화할 수 있다 

- 브라우저(클라이언트)에서 JSON 형태로 전달된 데이터를 JAVA 객체로 변환

```shell
	GET : SELECT
	POST : INSERT
	PUT : UPDATE
	DELETE : DELETE
```
```shell
			<GET>
	@GetMapping("/bank") 
	@ResponseBody // Java 객체 --> JSON으로 변환
	public User httpGet() { 
		User user = new User();
		user.setId(1);
		user.setUsername("aaa");
		user.setPassword("aaa");
		user.setEmail("aaa@gmail.com");
		return user;
	}
```
```shell
			<POST>
	@PostMapping("/bank")
	@ResponseBody : Java 객체 --> JSON으로 변환
	// @RequestBody : JSON --> Java 객체로 변환
	public String httpPost(@RequestBody User user) { 
		return "POST 요청 시, 입력값 : " + user.toString();
	}
```
```shell
			<PUT>
	
	@PutMapping("/bank")
	@ResponseBody
	public String httpPut() {
		return "PUT 요청 처리";
	}
```
```shell
			<DELETE>
	@DeleteMapping("/bank")
	@ResponseBody
	public String httpDelete(@RequestParam int id) {
		return "DELETE 요청 시, 입력한 값 : " + id;
	}
```
