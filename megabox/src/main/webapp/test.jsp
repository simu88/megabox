<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="model.*"
    import="service.*"
    import="dao.*"
    import="common.*"
    %>
    
<%
String id = (String) session.getAttribute("id");
int role = (Integer) session.getAttribute("role");
if (session == null || !request.isRequestedSessionIdValid()) {
	id = "��α���";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
ȯ���մϴ�. <%=id + role%>��
</body>
</html>