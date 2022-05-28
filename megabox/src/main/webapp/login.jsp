<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.LoginService"
    import="model.CustomerDTO"
    %>
    
<%
	//로그인 JSP 예제
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//로그인 메소드의 결과값을 객체에 담음
	CustomerDTO customerDTO = LoginService.loginProcess(id, password);
	
	int role = customerDTO.getRole();
	
	if (role == 4) {
		%>
		<script>alert('아이디 혹은 비밀번호가 맞지 않습니다.');
		window.history.back();
		</script>
	<% 
	}
	else {
		//로그인 성공
		id = customerDTO.getID();
		
		//세션에 아이디 추가
		session.setAttribute("role", role);
		//세션에 권한 추가
		session.setAttribute("id", id);
		
		response.sendRedirect("main.html");
	}
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