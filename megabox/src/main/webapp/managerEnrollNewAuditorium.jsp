<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <% 
    if (session.getAttribute("role") != "0") {
    	%>
    	<script>alert('�߸��� �����Դϴ�.');
    	location.href="main.html";
    	</script>
    	<%
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�󿵰� ���</title>
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
       		<p>�󿵰� �߰�</p>
       	</td>
        <td>
       		<input type="text" name="theater" size="40" placeholder="�������� �Է����ּ���">
       	</td>
       	</tr>
        </table>
	  	<div style="width:400px; height:200px; margin-left:50%; margin-top:35%;">
	 		<button style="width: 100px;height: 40px;">����</button>
	  	</div>
	</div>	
	</div>
	</form>
</body>
</html>