<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.LoginService"
    import="model.CustomerDTO"
    %>
    <% 
    if (session != null || request.isRequestedSessionIdValid()) {
    	%>
    	<script>alert('�̹� �α����� �̿����Դϴ�.');
    	window.history.back();
    	</script>
    	<%
    }
    %>
    
	<%
	//�α��� JSP ����
  	String id = request.getParameter("id");
  	String password = request.getParameter("password");
  	
  	//�α��� �޼ҵ��� ������� ��ü�� ����
  	CustomerDTO customerDTO = LoginService.loginProcess(id, password);
  	
  	int role = customerDTO.getRole();
  	
  	if (role == 4) {
  		%>
    	<script>alert('���̵�� ��й�ȣ�� ���� �ʽ��ϴ�.');
    	window.history.back();
    	</script>
    	<%
  	}
  	else {
  		//�α��� ����
  		id = customerDTO.getID();
  		
  		//���ǿ� ���̵� �߰�
  		session.setAttribute("role", role);
  		//���ǿ� ���� �߰�
  		session.setAttribute("id", id);
  	
  			response.sendRedirect("menu.jsp");
  	}
	%>


		
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>