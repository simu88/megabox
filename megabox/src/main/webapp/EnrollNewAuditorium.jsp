<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    %>
     <% 
    response.setCharacterEncoding("UTF-8");
    if ((Integer) session.getAttribute("role") != 0) {
    	out.println(session.getAttribute("role"));
    	response.sendRedirect("403.html");
    }
    
    int theater = Integer.parseInt(request.getParameter("theater"));
    String auditorium = request.getParameter("auditorium");
    int seat_number = Integer.parseInt(request.getParameter("seat_number"));
    
    AuditoriumService.addAuditorium(theater, auditorium, seat_number);
    
    %>
	<script>alert('상영관을 추가했습니다.');
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