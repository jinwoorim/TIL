## Main 클래스

- 웹애플리케이션으로 실행시 :

```shell
	SpringApplication application = new SpringApplication(Main클래스이름.class);
```

- 일반 자바 애플리케이션으로 실행시 :

```shell
	SpringApplication application = new SpringApplication(Main클래스이름.class);
	application.setWebApplicationType(WebApplicationType.NONE);
	application.run(args);
```

## pom.xml에 라이브러리 추가 방법

- 종료 dependencies 위에서 ctrl+spacebar로 Add Starters

- 추가할 라이브러리들 추가

- next해서 pom.xml 체크

## application.properties 설정

- Main클래스보다 우선순위가 더 높다. 따라서, Main클래스 설정과 다르더라도 application.properties 설정에 따라 동작한다

- WebApplication Setting

```shell
	<웹애플리케이션으로 실행>
	spring.main.web-application-type=servlet

	<일반 자바 애플리케이션으로 실행>
	spring.main.web-application-type=none
``` 
- Banner Setting

```shell
	<Main 클래스 설정(배너 OFF)>
	application.setBannerMode(Banner.Mode.OFF);

	<application.properties 설정(배너 ON)>
	spring.main.banner-mode=console
```
- Server Setting

```shell
	<application.properties 설정(포트설정)>
	server.port=8080

	<application.properties 설정(랜덤 포트설정)>
	server.port=0
```
## 배너 제작

- [배너 제작 홈페이지](https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20)

```shell
	<application.properties 설정>
	spring.banner.location=배너디렉토리/배너파일.txt
```
- 만약, 배너.txt 파일이 src/main/resources 바로 밑에 있다면 application.properties 설정 필요없음
