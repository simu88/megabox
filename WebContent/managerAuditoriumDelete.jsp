<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="model.*"
    import="service.*"
    import="dao.*"
    import="common.*"
    %>
    <%
    	int auditorium_id = Integer.parseInt(request.getParameter("auditorium_id"));
    	//out.println(theater_id);
    	
    	AuditoriumDTO a = new AuditoriumDTO(auditorium_id, "", 0);
    
    	AuditoriumService.deleteAuditorium(a);
    	
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