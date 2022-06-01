<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.*"
    import="service.*"
    import="dao.*"
    import="common.*"
    %>
    
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<% out.println(request.getParameter("title"));
	out.println(request.getParameter("rating"));%>

</form>
</body>
</html>