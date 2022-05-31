<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    import="java.util.Date"
    import="java.text.SimpleDateFormat"
    import="java.time.LocalDate"
    import="java.time.format.DateTimeFormatter"
    %>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
	<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
	<%@ page import="java.util.*" %>
	<%@ page import="java.io.*" %>
	<%@ page import="common.FileConfig" %>
    <% 
    response.setCharacterEncoding("UTF-8");
    if ((Integer) session.getAttribute("role") != 0) {
    	out.println(session.getAttribute("role"));
    	response.sendRedirect("403.html");
    }
    
    //���� ���ε�
    MultipartRequest multi = new MultipartRequest(request, FileConfig.directory, FileConfig.fileSize, "utf-8", new DefaultFileRenamePolicy());
    
    //���� �̸�
    Enumeration files = multi.getFileNames();
	String name = (String)files.nextElement();
	String filename = multi.getFilesystemName(name);
    
    //String�� Date�� ��ȯ
    LocalDate date = LocalDate.parse(request.getParameter("release_date"), DateTimeFormatter.ISO_DATE);
    
   MovieService.addNewMovie(request.getParameter("title"), 
		   request.getParameter("title_origin"), 
		   filename, 
		   java.sql.Date.valueOf(date), 
		   request.getParameter("summary"), 
		   request.getParameter("type"), 
		   request.getParameter("director"), 
		   request.getParameter("genre"), 
		   Integer.parseInt(request.getParameter("rating")), 
		   request.getParameter("cast"), 
		   request.getParameter("preview_url")
		   );
   %>
  	<script>alert('��ȭ�� �߰��߽��ϴ�.');
  	window.history.back();
  	</script>
  	<%
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