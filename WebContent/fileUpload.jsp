<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="common.FileConfig" %>
 
<%

	//MultipartRequest 객체를 생성해야 합니다. 인자로 request 객체, 파일을 저장할 위치, 파일 용량, 인코딩 방법, 파일명 중복시 정책을 주입해 줍시다.
	MultipartRequest multi = new MultipartRequest(request, FileConfig.directory, FileConfig.fileSize, "utf-8", new DefaultFileRenamePolicy());
	//여기까지만 작성하면 파일이 업로드 됨
	
	Enumeration files = multi.getFileNames();
	String name = (String)files.nextElement();
	String filename = multi.getFilesystemName(name);
	
	out.println("저장된 파일 이름" + filename + "<br>");
	
	
%>