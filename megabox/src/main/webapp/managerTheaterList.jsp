<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    import="java.util.Vector"
    import="model.*"
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
	<table border="1">
		<tr>
			<th>��ȭ�� ��ȣ</th>
			<th>��ȭ�� �̸�</th>
			<th></th>
			<th></th>
		</tr>
		<%
		TheaterDTO t = null;
			for (int i = 0; i < vc.size(); i++) {
				t = vc.get(1);
		%>
		<tr>
			<td><%=t.getTheater_id() %></td>
			<td><%=t.getRegion() %></td>
			<td><a href="">����</a></td>
			<td><a href="">����</a></td>
		</tr>
		<%
			}
		%>	
	</table>
</body>
</html>