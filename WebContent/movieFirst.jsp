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
<title>��ȭ�� ù��°</title>
<link href="all.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	
	<iframe class="menu" src=beforeMenu.html name=home scrolling=no style="width:100%; height:165px; border:none; text-align:center;"></iframe>
	
	<div style="display: flex; justify-content: center; align-items: center;">
	<div style="float:left "display:inline;">
	<img src="first.jpg" alt="��� ����" loading="lazy"  width="200" height="400" hspace="30">
	</div>
	
	<div style="display:inline;">
	<p><%=vc.get(1).getTitle() %></p>
	<p><input type="text" name="review" size="40" value="����  : 8.8��     ���������� : 550��"></p>
	<p><textarea name="info" rows="20" cols="80">
���ݲ� �� �� ���� ������ ���� ����!
5��, ������ ��Ƽ������ �����! 
	 
������ �տ��Ǵ� �ڿ��� �ھ�Ų �ð����� ��Ƽ������ ������ ���� �����, 
�׸��� ������ �Ѿ� ���� ���ο� ������� �´ڶ߸��� �� '���� ��Ʈ������', 
��ȥ�� ��, �״� ����ġ ���� ������ ���� �¼� �ο��߸� �ϴµ�...</textarea></p>
	</div>	
	</div>
	<div style="width:200px; height:100px; margin-left:80%; margin-top:3%;">
	 	<button style="width: 100px;height: 40px;" onclick="location.href='movieSecond.html'">����</button>
	 </div>
</body>
</html>