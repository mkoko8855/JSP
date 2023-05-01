<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 일부러 null point exception을 유발 시켜보자 -->
	
	<%
		String s = null; //s변수에 널 넣어놓고 거기에 값을 넣는다? 그냥 무조건 에러나오게 한 것이다.
		s.indexOf("메롱");
	%>



</body>
</html>

