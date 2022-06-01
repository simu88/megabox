<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="service.*"
    import="model.*"
    import="java.util.Vector"
    %>
    <%
    Vector<MovieDTO> m = MovieService.viewAllMovies();
    
    Vector<AuditoriumDTO> a = AuditoriumService.viewAllAuditorium();
    %>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<iframe class="menu" src=beforeMenu.html name=home scrolling=no style="width:100%; height:165px; border:none; text-align:center;"></iframe>
	<form action="EnrollNewSchedule.jsp" method="post">
	<div style="display:flex">
		<div id="middle">
		<table border=0>
		<tr>
		<td>
       		<p>상영관 선택</p>
       	</td>
        <td>
       		<select name="auditorium" placeholder="영화관을 선택해주세요">
       		<%
			AuditoriumDTO at = new AuditoriumDTO(0, "", 0);
       		
			for (int i = 0; i < a.size(); i++) {
				at = a.get(i);
		%>
       			<option value="<%=at.getAuditorium_id()%>"><%=at.getAuditorium_id() + "지점 " + at.getAuditorium_name() + "관" %></option>
       			<%
			}
		%>	
       		</select>
       	</td>
       	</tr>
       	<tr>
       	<td>
       		<p>영화 추가</p>
       	</td>
        <td>
       		<select name="movie" placeholder="영화를 선택해주세요">
       		<%
			MovieDTO mt = new MovieDTO("", "", "", null, "", "", "", "", 0, "", "", 0, 1.2, 0);
       		
			for (int i = 0; i < m.size(); i++) {
				mt = m.get(i);
		%>
       			<option value="<%=mt.getMovie_id() %>"><%=mt.getTitle() %></option>
       			<%
			}
		%>	
       		</select>
       	</td>
       	</tr>
       	<tr>
       	<td>	  	
       		<p>날짜</p> </td>
       	<td>
	  	<input type="date" name="date" size="24" placeholder="날짜을 입력해주세요"></td>
       	</tr>
       	<tr>
       	<td>	  	
       		<p>시작 시간</p> </td>
       	<td>
	  	<input type="time" name="time" size="24" placeholder="시작 시간을 입력해주세요"></td>
       	</tr>
       	<tr>
       	<td>	  	
       		<p>종료 시간</p> </td>
       	<td>
	  	<input type="time" name="end_time" size="24" placeholder="종료 시간을 입력해주세요"></td>
       	</tr>
       	<tr>
       	<td>	  	
       		<p>좌석 수</p> </td>
       	<td>
	  	<input type="text" name="rest_seat" size="24" placeholder="좌석 개수을 입력해주세요"></td>
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