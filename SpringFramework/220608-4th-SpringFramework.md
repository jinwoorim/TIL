# AOP(Aspect Oriented Programming) 관심지향 프로그래밍

- 관심 분리(Separation of Concerns) : 횡단 관심과 핵심 관심을 분리시키자

- 횡단 관심(Crosscutting Concerns)

- 핵심 관심(Core Concerns)

- XXXServiceImpl
    - XXXServiceImpl 클래스가 비즈니스 클래스다
    - 비즈니스 클래스에는 비즈니스 메소드가 구현되어있다
    - 비즈니스 메소드가 가진 코드가 핵심 관심 코드다

- XXXAdvice
    - XXXAdvice 클래스가 횡단 관심 클래스다
    - 횡단 관심 클래스에는 비즈니스 메소드마다 실행될 공통의 로직이 들어있다
    - 공통 로직이 횡단 관심 코드다

## AOP 용어

- Pointcut : 필터링된 비즈니스 메소드

```shell
     리턴 타입 필터링 : *, void, !void

     패키지 경로 필터링 : com.ssamz.biz.board, com.ssamz.biz.., com.ssamz.board

     클래스 이름 필터링 : BoardServiceImpl, *Impl

     메소드 이름 필터링 : getBoardList, get*

     매개변수 필터링 : (..), (int, int, object)
```

- Advice : 횡단 관심에 해당하는 공통 기능의 코드(이 공통 기능의 코드를 가진 메소드 자체를 Advice라 부르기도한다)

```shell
	<Advice 동작 시점 5가지>

    before : 필터링된 비즈니스 메소드 실행 전 참조하고있는 클래스의 메소드를 실행

    after : 필터링된 비즈니스 메소드 실행 후 참조하고있는 클래스의 메소드를 실행

    afterReturning : 필터링된 비즈니스 메소드 실행 후 리턴된 것을 참조하고있는 클래스의 메소드에 인자로 던져준다

    afterThrowing : 필터링된 비즈니스 메소드 실행 중 예외 발생하면 참조하고있는 클래스의 메소드를 실행

    around :필터링된 비즈니스 메소드 실행 전 후 둘다
```
- Aspect(=Advisor) : Pointcut + Advice를 연결해주는 연결고리 
