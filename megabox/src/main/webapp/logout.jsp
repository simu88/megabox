<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	//로그아웃 JSP 예제
	
	//세션 초기화
	session.invalidate();
%>
	<script>alert('로그아웃 되었습니다.');
	window.history.back();
</script>
<% 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>