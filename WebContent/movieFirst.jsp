<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import= "service.*"
    import= "java.util.Vector"
    import= "model.*"
    %>

   <%
   Vector<MovieDTO> vc=MovieService.viewAllMovies();
   MovieDTO a=null;
   for(int i=0;i<vc.size();i++){
	   a=vc.get(i);
   }
	%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>영화탭 첫번째</title>
<link href="all.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	
	<iframe class="menu" src=beforeMenu.html name=home scrolling=no style="width:100%; height:165px; border:none; text-align:center;"></iframe>
	
	<div style="display: flex; justify-content: center; align-items: center;">
	<div style="float:left "display:inline;">
	<img src="first.jpg" alt="출시 예정" loading="lazy"  width="200" height="400" hspace="30">
	</div>
	
	<div style="display:inline;">
	<p><%=vc.get(1).getTitle() %></p>
	<p><input type="text" name="review" size="40" value="평점  : 8.8점     누적관객수 : 550만"></p>
	<p><textarea name="info" rows="20" cols="80">
지금껏 본 적 없는 마블의 극한 상상력!
5월, 광기의 멀티버스가 깨어난다! 
	 
끝없이 균열되는 자원과 뒤엉킨 시공간의 멀티버스가 열리며 오랜 동료들, 
그리고 차원을 넘어 들어온 새로운 존재들을 맞닥뜨리게 된 '닥터 스트레인지', 
대혼돈 속, 그는 예상치 못한 극한의 적과 맞서 싸워야만 하는데...</textarea></p>
	</div>	
	</div>
	<div style="width:200px; height:100px; margin-left:80%; margin-top:3%;">
	 	<button style="width: 100px;height: 40px;" onclick="location.href='movieSecond.html'">다음</button>
	 </div>
</body>
</html>