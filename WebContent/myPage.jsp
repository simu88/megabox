<%@page import="service.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import ="service.*"
    import ="model.*"
    %>
    
    <% 
    String id=(String)session.getAttribute("id");
    
    CustomerService.viewCustomerByID(id);
    
    
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>마이페이지</title>
<link href="all.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<iframe class="menu" src=afterMenu.html name=home scrolling=no style="width:100%; height:165px; border:none; text-align:center;"></iframe>
	
	<div style="position:absolute; width:100px; height:300px; top:200px; left:500px;">
		<img src="user.png" width="100px" height="100px">
		<p style="font-size:5px; text-align:center;">user1</p>
		   <a href="userUpdate.html" target="_top"><input type=button value="정보수정" style="position:relative; left:30px; width:60px; height:20px; font-size:3px;"></a>
	</div>
	
		<div style="position:absolute; width:600px; height:300px; top:200px; left:600px; border:1px; background-color:gray; z-index:1">
		
			<div>
				<b style="margin-left:5px; font-size:4px;">회원정보</b>
			</div>
			
			<div style="position:absolute; width:586px; height:120px; top:20px; left:5px; border:1px; background-color:white; z-index:2">	
				<p style="margin-left:5px; font-size:13px;">회원 ID : <%=CustomerService.viewCustomerByID(id).getID()%></p>
				<p style="margin-left:5px; font-size:13px;">회원 이메일 : <%=CustomerService.viewCustomerByID(id).getEmail() %></p>								
				<p style="margin-left:5px; font-size:13px;">회원 전화번호 : <%=CustomerService.viewCustomerByID(id).getPhone() %></p>																
			</div>
			
			<div style="position:absolute; width:600px; height:120px; top:136px; left:2px; border:0px; z-index:2">	
				<b style="margin-left:5px; font-size:4px;">예약내역</b>
			</div>
			
			<div style="position:absolute; width:586px; height:130px; top:160px; left:5px; border:1px; background-color:white; z-index:2">
				<p style="margin-left:5px; font-size:13px;">1.닥터 스트레인지 대혼돈의 멀티버스 / 2022.04.26 16:01~18:15 / 1명</p>
			    <a href="reserveUpdate.html" target="_top"><input type=button value="예약수정" style="position:relative; left:520px; top:76px; width:60px; height:20px; font-size:3px; z-index:2"></a>		
			</div>
			
		</div>
</body>
</html>















    
    

