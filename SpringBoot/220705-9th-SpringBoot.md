## JPA

- Mybatis의 경우 DB연동을 한줄로 할 수 있어 매우 편했지만, SQL을 직접 다 작성해줘야하는 불편함이있었다.(SQL바뀌게되면 수정다해줘야됨)

- 이러한 불편함을 잡기위해 ORM들이 생겨났다(Hibernate, EclipseLink, DataNucleus)

- 만약 내가 Hibernate를 쓰다 EclipseLink로 ORM을 바꾸게 되면 Application을 다 수정해야했다.

- 때문에, Hibernate에서 JPA라는 표준 ORM을 만들어버렸다

## application.yml

- 기존 application.properties는 중복되는게 너무 많고 가독성이 떨어졌다

- 중복되는건 한칸내려 두칸 뛰고 작성

## JPA설정(application.yml에)

```shell
		<JPA 설정>
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    show-sql: true
    hibernate:
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      ddl-auto: none
      use-new-id-generator-mappings: false
    properties[hibernate.format_sql]: true
```

```shell
	database-platform : 어떤 DBMS를 사용할건지,최적화해준다
	show-sql : generation한 sql을 콘솔에 보여줄거냐
	physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl : 테이블의 컬럼이름과 변수이름을 똑같이 해준다
	ddl-auto : 테이블이 없어도 설정해놓으면 테이블이 자동으로 만들어진다. (create/update/none)
	use-new-id-generator-mappings : false (ture해놓으면 불안정하다)
	properties[hibernate.format_sql] : 생성되는 sql이 한줄로보임(false일때. default : false)
```
## Entity 설정(DBMS에서 테이블을 생성하지않고 Entity설정을 통해 이클립스에서 역으로 생성할수있다)

```shell
package com.fastcampus.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

//DROP TABLE USER;
//
//CREATE TABLE USER (
//	ID 		NUMBER(5) 	PRIMARY KEY,
//	USERNAME 	VARCHAR2(30),
//	PASSWORD 	VARCHAR2(100),
//	EMAIL 	VARCHAR2(30)
//);

@Data
@Table(name = "USERS") // H2에서 테이블이름이랑 같아야됨
@Entity // 필수로 있어야됨
public class User {
	@Id // 식별자 변수(Primary Key) 선언 // 필수로 있어야됨
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1부터 시작하여 자동으로 1씩 값이 증가하도록 설정한다.// 	@Id랑@GeneratedValue는 보통 쌍으로쓴다
	private int id; // 회원 일련번호
	
	@Column(nullable = false, length = 50, unique = true) // nullable = false : null을 허용하지않겠다(NOT NULL)
	private String username; // 아이디
	
	@Column(length = 50)
	private String password; // 비밀번호
	
	@Column(nullable = false, length = 100)
	private String email; // 이메일
	
	private String role;
	
	@CreationTimestamp // 현재 시간 정보가 자동으로 설정된다.
	private Timestamp createDate;
}
```
