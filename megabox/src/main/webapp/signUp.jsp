<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="model.*"
    import="service.*"
    import="dao.*"
    import="common.*"
    %>
    
<% 

String id = request.getParameter("ID");
String pw = request.getParameter("PW");
String checkPW = request.getParameter("CHECKPW");
String email = request.getParameter("EMAIL");
String phone = request.getParameter("PHONE");
//SignUpService.signUp(id, pw, email, phone);
boolean a = SignUpService.signUp(id, pw, email, phone);

if (pw != checkPW) {
	%>
	<script>alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
	window.history.back();
	
	</script>
	<% 
}

if (a == true) {
	%>
		<script>alert('ȸ������ ����');</script>
	<% 
	response.sendRedirect("main.html");
}
else {
	%>
	<script>alert('���̵� �ߺ��˴ϴ�.');
	window.history.back();
	
	</script>
<%
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