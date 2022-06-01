<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="service.*"
    import="java.util.Date"
    import="java.text.SimpleDateFormat"
    import="java.time.LocalDate"
    import="java.time.format.DateTimeFormatter"
    import="model.*"
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
    
    //파일 업로드
    MultipartRequest multi = new MultipartRequest(request, FileConfig.directory, FileConfig.fileSize, "utf-8", new DefaultFileRenamePolicy());
    
    //파일 이름
    Enumeration files = multi.getFileNames();
	String name = (String)files.nextElement();
	String filename = multi.getFilesystemName(name);
	
	
    //String을 Date로 변환
    Date releaseDate = StringToDateService.transformDate(multi.getParameter("release_date"));
    
   MovieService.addNewMovie(multi.getParameter("title"), 
		   multi.getParameter("title_origin"), 
		   filename, 
		   releaseDate, 
		   multi.getParameter("summary"), 
		   multi.getParameter("type"), 
		   multi.getParameter("director"), 
		   multi.getParameter("genre"), 
		   (int) Integer.parseInt(multi.getParameter("rating")), 
		   multi.getParameter("cast"), 
		   multi.getParameter("preview_url")
		   );
   %>
  	<script>alert('영화를 추가했습니다.');
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