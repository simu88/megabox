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
		<input type=button value="����� ��ȭ" style="width: 100px;height: 40px;" onclick="location.href='managerEnrolledMovie.html'">
		<input type=button value="�ű� ���" style="width: 100px;height: 40px;" onclick="location.href='managerEnrollNewMovie_1.html'">
		<input type=button value="���� ��Ȳ" style="width: 100px;height: 40px;" onclick="location.href='managerTicketingConfirm.html'">
		</div>
		
		<div style="float:left "display:inline;">
		</div>
		
		<div id="middle">
		<table border=0>
		<tr>
       	<td>
       		<p>��ȭ����</p>
       	</td>
        <td>
       		<input type="text" name="title" size="40" placeholder="��ȭ������ �Է����ּ���">
       	</td>
       	</tr>
       	<tr>
       	<td>
       		<p>��ȭ����</p>
       	</td>
        <td>
       		<input type="text" name="title_origin" size="40" placeholder="������ �Է����ּ���">
       	</td>
       	</tr>
       	<tr>
       	<td>
       		 <p>����� �̹���</p>
       	</td>
        <td>
       		<input type="file" name="thumbnail_image" placeholder="����� �̹���">       		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>���Ͻ�</p>
       	</td>
        <td>
       		<input type="date" name="release_date" value="2019-09-22">       		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>�ٰŸ�</p>
       	</td>
        <td>
       		<textarea name="summary" placeholder="�ٰŸ�"></textarea>       		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>�ڸ� ����</p>
       	</td>
        <td>
       		<input type="text" name="type" placeholder="Ÿ��">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>����</p>
       	</td>
        <td>
       		<input type="text" name="director" placeholder="����">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>�帣</p>
       	</td>
        <td>
       		<input type="text" name="genre" placeholder="�帣">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>���</p>
       	</td>
        <td>
       		<input type="text" name="rating" placeholder="���">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>�⿬</p>
       	</td>
        <td>
       		<input type="text" name="cast" placeholder="�⿬">      		
       	</td>
      	</tr>
      	<tr>
       	<td>
       		 <p>������</p>
       	</td>
        <td>
       		<input type="text" name="preview_url" placeholder="������">      		
       	</td>
      	</tr>
        </table>
	  	<div style="width:400px; height:200px; margin-left:55%; margin-top:35%;">
	 		<button style="width: 100px;height: 40px;">����</button>
	  	</div>
	  	</form>
	</div>	
	</div>
</body>
</html>