<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <% 
    response.setCharacterEncoding("UTF-8");
    if ((Integer) session.getAttribute("role") != 0) {
    	out.println(session.getAttribute("role"));
    	response.sendRedirect("403.html");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="all.css" rel="stylesheet" type="text/css"> 
<title>관리자 페이지</title>
</head>
<body>
<table border="1">
		<tr>
			<th></th>
		</tr>
		<tr>
			<td><a href="managerTheaterList.jsp">영화관 목록</td>
			<td></td>
			<td><a href="">수정</a></td>
			<td><a href="">수정</a></td>
		</tr>
	</table>
</body>
</html>