## 프로젝트 생성

- Type : Maven Project(표준). Maven이 라이브러리를 관리해준다

- Packaging : jar(빠르고 구조도 쉽다)

- Name, Arifact : 프로젝트 이름

- Group : 이 프로젝트를 어떤 기관이나 단체가 만들었고 유지보수하느냐(전세계에서 유니크해야됨. 보통 도메인이름을 따온다)

- Package : Group과 이름같게

## 프로젝트 생성(라이브러리 추가)

- Lombok(필수)

- Spring Boot DevTools(소스 수정시 자동 리로딩되게 하는)(필수)

- Spring Web

## pom.xml

- maven 설정파일

- dependencies 안쪽에 뭔가를 설정하면 dependencies하나당 jar파일(라이브러리)하나가 다운로드되는게 원칙이다

- starter에 의해 dependencies하나당 여러 jar파일 다운로드 가능
