
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR" import="service.*" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ jsp</title>
</head>
<body>
   <%
      String id = request.getParameter("ID");
      String pw = request.getParameter("PW");
      String checkPW = request.getParameter("CHECKPW");
      String email = request.getParameter("EMAIL");
      String phone = request.getParameter("PHONE");

      boolean a = SignUpService.signUp(id, pw, email, phone);

      if (a == true) {%>

      <!-- �Ʒ� �޽��� ��� ���� ���� �������� ������ -->

      <script>
         alert('ȸ������ ����!!');
      
      </script>

      <%
         response.sendRedirect("main.html");
         
         

      } else {
   %>

   <!-- �Ʒ� �޽��� ��� ���� ���� �������� ������ -->

   <script>
      alert('���̵� �ߺ��˴ϴ�.');
      window.history.back();
   </script>

   <%
      }
      %>

</body>
</html>