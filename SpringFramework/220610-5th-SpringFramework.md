## JoinPoint 메소드

- JoinPoint 참조변수.getSignature().getName(); : 클라이언트가 호출한 메소드의 정보를 반환

- JoinPoint 참조변수.getArgs(); : 클라이언트가 메소드를 호출할때 넘겨준 인자를 배열로 반환(Object 타입)

## ProceedingJoinPoint 메소드

- JoinPoint 상속받음

- Around 어드바이스는 매개변수로 ProceedingJoinPoint 로 받아야한다

- 나머지 어드바이스는 매개변수로 JoinPoint 로 받아야한다

## AOP에 Annotation을 적용하기 위한 설정

- XML에 aop:aspectj-autoproxy 태그 설정

- 각각 Advice 클래스위에 @Service 와 @Aspect 추가

- 클래스 안에 참조용 메소드 추가

```shell
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.get*(..))")
	public void getPointcut() {}
```
- 메소드 위에 @Before("allPointcut()") 추가 (AfterReturning 과 AfterThrowing 은 뒤에 returning 과 throwing 추가)
