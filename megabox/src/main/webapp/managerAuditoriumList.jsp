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
    
    int theater_id = Integer.parseInt(request.getParameter("theater_id"));
    
    Vector<AuditoriumDTO> vc = AuditoriumService.viewAuditoriumByTheater(theater_id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>상영관 번호</th>
			<th>상영관 이름</th>
			<th></th>
		</tr>
		<%
		AuditoriumDTO t = new AuditoriumDTO(0, "", 0);
			for (int i = 0; i < vc.size(); i++) {
				t = vc.get(i);
		%>
		<tr>
			<td><%=t.getAuditorium_id() %></td>
			<td><%=t.getAuditorium_name() %></td>
			<td><a href="managerAuditoriumDelete.jsp?auditorium_id=<%=t.getAuditorium_id()%>">삭제</a></td>
		</tr>
		<%
			}
		%>	
	</table>
</body>
</html>