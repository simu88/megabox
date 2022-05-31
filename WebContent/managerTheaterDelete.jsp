<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="model.*"
    import="service.*"
    import="dao.*"
    import="common.*"
    %>
    <%
    	String theater_id = request.getParameter("theater_id");
    	//out.println(theater_id);
    
    	TheaterService.deleteTheater(Integer.parseInt(theater_id));
    	
    	%>
    	<script>alert('삭제되었습니다');
    	</script>
    	<%
    	response.sendRedirect("managerTheaterList.jsp");
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