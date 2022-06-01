<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="service.*"
    import="java.util.Date"
    import="java.text.SimpleDateFormat"
    import="java.time.LocalDate"
    import="java.time.format.DateTimeFormatter"
    import="model.*"
    import="java.sql.Timestamp"
    %>
    <%
    	Date date = StringToDateService.transformDate(request.getParameter("date"));
    
    	Timestamp time = StringToTimeService.transformTime(request.getParameter("time") + "");
    	
    	Timestamp endTime = StringToTimeService.transformTime(request.getParameter("end_time") + "");
    
    	
    	ScheduleService.addSchedule(Integer.parseInt(request.getParameter("movie")), Integer.parseInt(request.getParameter("auditorium")), date, time, endTime, Integer.parseInt(request.getParameter("rest_seat")));
    	 %>
    	  	<script>alert('상영시간표를 추가했습니다.');
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