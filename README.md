# 백엔드 개발을 위한 개인적인 지침사항

## 디렉토리 구조

###### 본 프로젝트는 참고자료로 주어진 hsbank를 참고하여 백엔드 코드를 작성하나 유지보수의 용이함을 위해 조금 다른 디렉토리의 구조를 가집니다.

###### 프로젝트의 디렉토리 구조는 다음과 같습니다.

/src   
&nbsp;  /common   
&nbsp;  /model   
&nbsp;  /repository    
&nbsp;  /service    
/build   
/WebContent   
&nbsp;  /resource   
&nbsp;&nbsp;    /css   
&nbsp;&nbsp;    /js   
&nbsp;&nbsp;    /img   
    /view   
    
    
    
하나씩 순서대로 설명합니다.

### /src

자바 소스코드를 저장하기 위한 폴더입니다.

#### src/common

각 코드에서 공통적으로 쓰이는 모듈을 저장하는 폴더입니다.

예를 들어 Mysql 서버에 저장하기 위한 계정 정보를 담은 설정파일 등이 있습니다.

#### /src/model

DTO(DATA TRANSFER OBJECT)를 저장하는 폴더입니다.


