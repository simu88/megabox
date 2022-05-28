
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR" import="service.*" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 jsp</title>
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

      <!-- 아래 메시지 경고를 띄우고 이전 페이지로 돌린다 -->

      <script>
         alert('회원가입 성공!!');
      
      </script>

      <%
         response.sendRedirect("main.html");
         
         

      } else {
   %>

   <!-- 아래 메시지 경고를 띄우고 이전 페이지로 돌린다 -->

   <script>
      alert('아이디가 중복됩니다.');
      window.history.back();
   </script>

   <%
      }
      %>

</body>
</html>