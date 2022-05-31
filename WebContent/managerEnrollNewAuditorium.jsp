<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    import="model.*"
    import="java.util.Vector"
    %>
        <% 
        if ((Integer) session.getAttribute("role") != 0) {
        	out.println(session.getAttribute("role"));
        	response.sendRedirect("403.html");
        }
        
        Vector<TheaterDTO> vc = TheaterService.viewAllTheater();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상영관 등록</title>
<style>
#left {
    width:200px; 
    height:300px;
    float:left;
    margin-left:300px;
}
#middle {
	margin:auto;
}
#td,tr{
	width:20px;
	height:40px;
	text-align:center;
}
#input, button{
	float:center;
	position:absolute;
	text-align:center;
}
</style>
<link href="all.css" rel="stylesheet" type="text/css">
</head>
<body>
	<iframe class="menu" src=beforeMenu.html name=home scrolling=no style="width:100%; height:165px; border:none; text-align:center;"></iframe>
	<form action="EnrollNewAuditorium.jsp" method="post">
	<div style="display:flex">
		<div id="middle">
		<table border=0>
		<tr>
		<td>
       		<p>영화관 선택</p>
       	</td>
        <td>
       		<select name="theater" placeholder="영화관을 선택해주세요">
       		<%
			TheaterDTO t = new TheaterDTO("");
			for (int i = 0; i < vc.size(); i++) {
				t = vc.get(i);
		%>
       			<option value="<%=t.getTheater_id()%>"><%=t.getRegion() %></option>
       			<%
			}
		%>	
       		</select>
       	</td>
       	<td>
       		<p>상영관 추가</p>
       	</td>
        <td>
       		<input type="text" name="auditorium" size="20" placeholder="관명을 입력해주세요">
       	</td>
       	<td>	  	
       		<p>좌석 수</p> </td>
       	<td>
	  	<input type="text" name="seat_number" size="24" placeholder="좌석 개수을 입력해주세요"></td>
       	</tr>
        </table>
	  	<div style="width:400px; height:200px; margin-left:50%; margin-top:35%;">
	 		<button style="width: 100px;height: 40px;">다음</button>
	  	</div>

	</div>	
	</div>
	</form>
</body>
</html>