## iBATIS

- 장점 : sql 명령어를 외부의 xml 파일에 분리시키고 자바코드 한줄로 모든 DB연동을 하려고 사용

- sqlmap 파일(xml)에 sql 명령어작성

- DAO 클래스에서 SqlMapClient라는 iBATIS 컨테이너 획득(ibatis = SqlMapClientFactoryBean.getSqlMapClientInstance();)

- 획득하는 과정에서 iBATIS 컨테이너가 sql-map-confing.xml 로딩

```shell

  	<insert의 경우>

1. ibatis.insert("insertBoard", vo); 하게되면 sqlmap 파일(xml)에 등록된 id가 insertBoard인 sql 실행

2. 파라미터로 sqlmap 파일(xml)에 등록된 parameterClass 속성에 해당하는 VO를 넘겨준다

3. 넘겨 받은 VO에 해당하는 값들을 sql ? 에 해당하는 곳에 세팅해서 DBMS에 전달

	<상세 조회의 경우>

1. ibatis.queryForObject("getBoard", vo); 하게되면 sqlmap 파일(xml)에 등록된 id가 getBoard인 sql 실행

2. 파라미터 객체로 sqlmap 파일(xml)에 등록된 parameterClass 속성에 해당하는 VO를 넘겨준다

3. 넘겨 받은 VO에 해당하는 값들을 sql ? 에 해당하는 곳에 세팅해서 DBMS에 전달

4. resultset에 들어있는 검색 결과를 sqlmap 파일(xml)에 등록된 resultClass 속성에 등록된 VO에 매핑해서 리턴

```
## MyBatis

- MyBatis 홈페이지 들어가보면 xml에 작성할 초기 세팅 정보들이 있음. 가져다 쓰면됨(sqlmap파일xml, sql-map-config.xml(메인설정xml))

- iBatis와의 차이점 (sqlmap파일xml) 

```shell
	1. parameterMap 이 parameterType으로 바뀜, resultMap 이 resultType으로 바뀜
	2. sql 구문에서 변수이름이 #변수이름# 에서 ${변수이름}으로 바뀜
	3. Alias 설정을 sqlmap파일xml에서 하지않는다(태그 : typeAlias alias="board" type="com.ssamz.biz.board.BoardVO"/)
```
- iBatis와의 차이점 (sql-map-config.xml(메인설정xml))

```shell

	1. Alias 등록
```
- iBatis와의 차이점(business-layer.xml)

```shell
	business-layer.xml 참고하기
```
- iBatis와의 차이점(DAO 클래스)

```shell
	1. Template이 SqlMapClient에서 SqlMapClientTemplate로 변경
	2. 상세조회 : queryForObject 에서 selectOne으로 변경
	3. 목록조회 : queryForList 에서 selectList로 변경
```
- 만약, 여러 sqlmap파일xml이 등록되고 각각의 xml에 선언된 id값이 같을때 DAO클래스에서 access 하는법

```shell
	sqlmap파일xml에서 namespace를 설정한다
```
