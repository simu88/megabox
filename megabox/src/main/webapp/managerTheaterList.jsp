<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    import="java.util.Vector"
    import="model.*"
    %>
    
    <%
    	Vector<TheaterDTO> vc = TheaterService.viewAllTheater();
    	out.println(vc.size());
   
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
			<th></th>
		</tr>
		<%
		TheaterDTO t = new TheaterDTO("");
			for (int i = 0; i < vc.size(); i++) {
				t = vc.get(i);
				out.println(i);
				out.println(t.getTheater_id());
		%>
		<tr>
			<td><%=t.getTheater_id() %></td>
			<td><%=t.getRegion() %></td>
			<td><a href="">수정</a></td>
			<td><a href="">수정</a></td>
		</tr>
		<%
			}
		%>	
	</table>
</body>
</html>