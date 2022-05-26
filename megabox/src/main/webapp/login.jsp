<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.LoginService"
    import="model.CustomerDTO"
    %>
    
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	CustomerDTO customerDTO = LoginService.loginProcess(id, password);
	
	int role = customerDTO.getRole();
	
	if (role == 4) {
		//로그인 실패
	}
	else {
		id = customerDTO.getID();
		

		session.setAttribute("role", role);
		session.setAttribute("id", id);
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