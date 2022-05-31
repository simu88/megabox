<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    import="java.util.Vector"
    import="model.*"
    %>
        <% 
    response.setCharacterEncoding("UTF-8");
    if ((Integer) session.getAttribute("role") != 0) {
    	out.println(session.getAttribute("role"));
    	response.sendRedirect("403.html");
    }
    %>
    
    <%
    	Vector<TheaterDTO> vc = TheaterService.viewAllTheater();
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<br>
	<table border="1">
		<tr>
			<th>영화관 번호</th>
			<th>영화관 이름</th>
			<th></th>
		</tr>
		<%
		TheaterDTO t = new TheaterDTO("");
			for (int i = 0; i < vc.size(); i++) {
				t = vc.get(i);
		%>
		<tr>
			<td><%=t.getTheater_id() %></td>
			<td><a href="managerAuditoriumList.jsp?theater_id=<%=t.getTheater_id()%>"><%=t.getRegion() %></a></td>
			<td><a href="managerTheaterDelete.jsp?theater_id=<%=t.getTheater_id()%>">삭제</a></td>
		</tr>
		<%
			}
		%>	
	</table>
</body>
</html>