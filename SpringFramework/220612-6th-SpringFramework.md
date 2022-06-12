## Spring JDBC 

- 기존 JDBC로는 DAO 클래스의 CRUD 메소드에서 반복되는 코드가 너무 많았다. 실수를 범할 수 있다. Spring JDBC 는 한줄로 표현가능

- JdbcTemplate를 import하고 맴버변수로 선언해준다(@Autowired)

- XML에 JdbcTemplate 등록해줘야한다(내가만든 클래스가 아닌 Spring에서 제공하는 클래스이기때문에 bean등록이 필수)

## JDBCTemplate 메소드

```shell

 1. 등록, 수정, 삭제 : JdbcTemplate 참조변수.update(맴버변수, ?에 해당하는것);

 2. 글 목록 검색 : JdbcTemplate 참조변수.query(sql, new RowMapper클래스(), vo.getSearchKeyword());
		 : 여러개 저장 리턴

 3. 글 상세 조회 : JdbcTemplate 참조변수.queryForObject(sql, new RowMapper클래스(), vo.getSeq());
		 : queryForObject() : 객체 하나만 매핑 리턴
```

## Datasource 등록

- XML에 DataSource 등록해줘야한다(특정 DB와 연결해주기위해)

## datasource.properties

- 만약 DBMS가 변경되면 XML에 설정 정보를 수정해야한다. 

- datasource.properties 와부 파일로 빼면 유지보수 편리하다
