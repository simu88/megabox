<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="service.*"
    %>
    <%
    response.setCharacterEncoding("UTF-8");
    
    if ((Integer) session.getAttribute("role") != 0) {
    	%>
    	<script>alert('잘못된 접근입니다.');
    	window.history.back();
    	</script>
    	<%
    }
    
    String theater = request.getParameter("theater");
    
    out.println(theater);
    
    //System.out.println(theater);
    
    TheaterService.addTheater(theater);
    
    %>
	<script>alert('영화관을 추가했습니다.');
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