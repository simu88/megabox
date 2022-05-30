<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.*"
    import="service.*"
    import="dao.*"
    import="common.*"
    %>
    
<%
String id = (String) session.getAttribute("id");
int role = (Integer) session.getAttribute("role");
if (session == null || !request.isRequestedSessionIdValid()) {
	id = "비로그인";
}
String name = "나나나";
String theater = request.getParameter("theater");

out.println(theater);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
환영합니다. <%=name%>님
</body>
</html>