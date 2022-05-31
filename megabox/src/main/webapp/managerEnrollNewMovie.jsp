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
        
        Vector<AuditoriumDTO> vc = AuditoriumService.viewAllAuditorium();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
#left {
    width:200px; 
    height:300px;
    float:left;
    margin-left:300px;
}
#middle {
    width:500px; 
    height:250px;
    float:left;
}
#td,tr{
	width:20px;
	height:40px;
	text-align:center
}
</style>
<link href="all.css" rel="stylesheet" type="text/css"> 
<title>Insert title here</title>
</head>
<body>
<iframe class="menu" src=beforeMenu.html name=home scrolling=no style="width:100%; height:165px; border:none; text-align:center;"></iframe>
<form action="EnrollNewMovie.jsp" method="post" enctype="multipart/form-data">
	<div style="display:flex">
		<div id="left">	
		<input type=button value="등록한 영화" style="width: 100px;height: 40px;" onclick="location.href='managerEnrolledMovie.html'">
		<input type=button value="신규 등록" style="width: 100px;height: 40px;" onclick="location.href='managerEnrollNewMovie_1.html'">
		<input type=button value="예매 현황" style="width: 100px;height: 40px;" onclick="location.href='managerTicketingConfirm.html'">
		</div>
		
		<div style="float:left "display:inline;">
		</div>
		
		<div id="middle">
		<table border=0>
		<tr>
       	<td>
       		<p>영화제목</p>
       	</td>
        <td>
       		<input type="text" name="title" size="40" placeholder="영화제목을 입력해주세요">
       	</td>
       	</tr>
       	<tr>
       	<td>
       		<p>영화제목</p>
       	</td>
        <td>
       		<input type="text" name="title_origin" size="40" placeholder="원제를 입력해주세요">
       	</td>
       	</tr>
       	<tr>
       	<td>
       		 <p>썸네일 이미지</p>
       	</td>
        <td>
       		<input type="file" name="thumbnail_image" placeholder="썸네일 이미지">       		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>상영일시</p>
       	</td>
        <td>
       		<input type="date" name="release_date" value="2019-09-22">       		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>줄거리</p>
       	</td>
        <td>
       		<textarea name="summary" placeholder="줄거리"></textarea>       		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>자막 여부</p>
       	</td>
        <td>
       		<input type="text" name="type" placeholder="타입">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>감독</p>
       	</td>
        <td>
       		<input type="text" name="director" placeholder="감독">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>장르</p>
       	</td>
        <td>
       		<input type="text" name="genre" placeholder="장르">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>등급</p>
       	</td>
        <td>
       		<input type="text" name="rating" placeholder="등급">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>출연</p>
       	</td>
        <td>
       		<input type="text" name="cast" placeholder="출연">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>예고편</p>
       	</td>
        <td>
       		<input type="text" name="preview_url" placeholder="예고편">      		
       	</td>
      	</tr>
        </table>
	  	<div style="width:400px; height:200px; margin-left:55%; margin-top:35%;">
	 		<button style="width: 100px;height: 40px;">다음</button>
	  	</div>
	  	</form>
	</div>	
	</div>
</body>
</html>