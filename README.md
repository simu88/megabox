# 백엔드 개발을 위한 개인적인 지침사항

## 디렉토리 구조

###### 본 프로젝트는 참고자료로 주어진 hsbank를 참고하여 백엔드 코드를 작성하나 유지보수의 용이함을 위해 조금 다른 디렉토리의 구조를 가집니다.

###### 프로젝트의 디렉토리 구조는 다음과 같습니다.

/src   
&nbsp;  /common   
&nbsp;  /model   
&nbsp;  /dao    
&nbsp;  /service    
/build   
/WebContent   
&nbsp;  /resources   
&nbsp;&nbsp;    /css   
&nbsp;&nbsp;    /js   
&nbsp;&nbsp;    /img   
    /view   
    
    
    
하나씩 순서대로 설명합니다.

### /src

자바 소스코드를 저장하기 위한 패키지입니다.

#### src/common

각 코드에서 공통적으로 쓰이는 모듈을 저장하는 패키지입니다.

예를 들어 Mysql 서버에 저장하기 위한 계정 정보를 담은 설정파일 등이 있습니다.

#### /src/model

DTO(DATA TRANSFER OBJECT)를 저장하는 패키지입니다.

DTO란 사용자가 입력하는 데이터를 객체화 하여 데이터베이스에 전달하기 위한 클래스입니다.

hsbank에서 Account.java나 Banker.java와 하는 역할이 같습니다.

각 테이블마다 하나의 DTO를 가지며 칼럼을 클래스 내부의 변수로 가집니다.

또한 객체의 데이터를 읽거나 수정하기 위해 getter와 setter 메소드를 내장해야 합니다.

모든 DTO 클래스의 표기법은 파스칼 표기법 + DTO로 작성합니다.

예) AccountDTO 

#### /src/dao

DAO(DATA ACCESS OBJECT)를 저장하기 위한 패키지입니다.

DAO는 JAVA와 데이터베이스를 연결하는 입니다. 좀 더 노골적으로 말하면 CRUD(Create, Read, Update, Delete)와 관련된 메소드를 구현하기 위한 객체입니다.

예를 들어 hsbank의 DB.java의 insertBanker 메소드는 Banker 타입의 객체를 피라미터로 받아 데이터베이스에 INSERT 쿼리문을 실행합니다.

이처럼 데이터베이스에 직접 접근하여 쿼리를 날리는 기능은 전부 DAO 로 작성합니다.

모든 DAO 클래스의 표기법은 파스칼 표기법 + DAO로 작성합니다.

예) AccountDAO

#### /src/service

비즈니스 로직을 담는 패키지입니다.

예를 들어 DB.java의 getAllBankersRS 메소드는 SELECT 쿼리문을 실행하여 ResultSet 타입의 형태로 반환합니다.

여기서 쿼리문을 실행하는 메소드는 DAO의 형태로 분리하여 별개로 구현하고, 데이터베이스에서 가져온 데이터를 ResultSet으로 반환하는 메소드는 service 모듈로 따로 구현할 수 있습니다.

모든 service의 표기법은 파스칼 표기법 + Service로 작성합니다.

예) LoginService

### Webcontent

#### WebContent/resources

정적 파일을 저장하기 위한 폴더입니다.

이미지 파일, css 파일, 자바스크립트 파일 등을 저장합니다.

#### WebContent/view

뷰를 저장하는 폴더입니다.

JSP와 HTML 파일은 모두 여기에 담습니다.






