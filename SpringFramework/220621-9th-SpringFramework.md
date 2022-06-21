## Layer 연결

- Presentation Layer(MVC) 와 Business Layer를 연결

```shell

	1. 브라우저 요청 들어온다(.do)
	2. .do 요청이 들어오면 DispatcherServlet 객체가 만들어진다(web.xml에 등록되있음)
	3. DispatcherServlet은 presentation-layer.xml을 로딩한다
	4. presentation-layer.xml에 의해 Controller 객체들이 메모리에 뜬다
	5. Controller클래스는 BoardService(인터페이스 즉, 리모컨)를 Autowired하고 있다. 이걸로 ServiceImpl 실행
	6. 하지만, BoardService가 메모리에 떠있지 않기 때문에 Autowired가 실패하게된다
	7. 따라서, Business Layer를 presentation-layer.xml가 로딩되기 이전에 로딩해야한다
	8. 즉, web.xml에 리스너를 통해 Business Layer가 미리 pre-loading되게 만들어야한다

```
