<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
  
     <% 
 
    if ((Integer)session.getAttribute("role") == 0) {
    	%>
    	<script>alert('�����ڷ� �α��� �Ͽ����ϴ�.');
    	location.href="main.html";
    	</script>
    	<%
    }else if((Integer)session.getAttribute("role") == 1) {
    	%>
    	<script>alert('�α��ο� �����߽��ϴ�.');
    	location.href="afterMenu.html";
    	</script>
    	<%
    	
    }else
    	%>
		<script>alert('�α��ο� �����߽��ϴ�.');
		location.href="login.html";
		</script>
		<%
    %>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>