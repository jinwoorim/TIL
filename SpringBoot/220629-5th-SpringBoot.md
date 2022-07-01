## 스타터("spring-boot-starter-모듈명")(SpringBoot가 제공)

- 관련된 라이브러리들의 묶음

- 스타터와 기존방식의 차이

```shell
						<기존 방식>

	* MVNrepository 홈페이지에서 라이브러리를 찾아 pom.xml에 dependency로 의존성 설정을 해야한다

	* 라이브러리를 하나만 다운받는다고 되는것도 아니고 관련된걸 일일히 다 찾아서 dependency해야한다

```

- 스타터 사용방법

```shell
	1. pom.xml에서 ctrl+spacebar 하고 Add starters
	2. 라이브러리 추가하고 next
	3. pom.xml 체크하고 finish
```

- 만약 다운 받은 스타터에서 특정 JAR파일 버전을 바꾸고싶을 때

```shell
	1. pom.xml에 parent가 있다(pom.xml은 상속이 가능)
	2. parent의 parent를 따라 들어가면 수많은 property들이 있다
	3. 그 안에서 해당 사항을 복사해서 pom.xml에 <properties> 안에 붙여넣기
	4. 버전을 변경한다(오버라이팅)
```

## 사용자 정의 스타터 (내가 만든 스타터)

- 사용자 정의 스타터 생성 방법

```shell

	1. 일반 프로젝트 생성 
	2. maven -> maven project 
	3. filter에 maven-archetye-qu 검색해서 org.apache.maven.archetypes 템플릿선택
	4. next -> next 
	5. Artifact id에 "내가원하는 모듈명-spring-boot-starter"
	6. 해당 프로젝트 pom.xml에서   <groupId>com.rubypaper</groupId>
  				       <artifactId>내가원하는 모듈명-spring-boot-starter</artifactId>
  				       <version>0.0.1-SNAPSHOT</version> 복사
	7. 해당 프로젝트 오른쪽클릭 run as 하고 maven install 클릭
	8. 내가 만든 스타터가 .m2 디렉토리안에 SNAPSHOT 폴더안에 JAR파일로 추가되어있다.
	9. 6.에서 복사한 것을 넣고 싶은 프로젝트 파일 pom.xml에 붙여넣기해서 dependency추가하기

```
