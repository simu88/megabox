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
       		<p>��ȭ�� ����</p>
       	</td>
        <td>
       		<select name="theater" placeholder="��ȭ���� �������ּ���">
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
       		<p>�󿵰� �߰�</p>
       	</td>
        <td>
       		<input type="text" name="auditorium" size="20" placeholder="������ �Է����ּ���">
       	</td>
       	<td>	  	
       		<p>�¼� ��</p> </td>
       	<td>
	  	<input type="text" name="seat_number" size="24" placeholder="�¼� ������ �Է����ּ���"></td>
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