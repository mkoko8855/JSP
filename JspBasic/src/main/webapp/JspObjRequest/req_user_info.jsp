<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	String id = request.getParameter("id");   //name에 적힌 값을 적은 것이다.
    	String pw = request.getParameter("pw");   //name에 적힌 값을 적은 것이다.
    	String gender = request.getParameter("gender");   //name에 적힌 값을 적은 것이다.
    	String[] hobby = request.getParameterValues("hobby");   //name에 적힌 값을 적은 것이다.
    	String region = request.getParameter("region");   //name에 적힌 값을 적은 것이다.
    	String introduce = request.getParameter("introduce");   //name에 적힌 값을 적은 것이다.
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	
		<p>
			# ID : <%=id %> <br>
			# PW : <%=pw %> <br>
			# 성별 : <%=gender %> <br>
			# 취미 : <%=Arrays.toString(hobby) %> <br>
			# 지역 : <%=region %> <br>
			# 자기소개 : <%=introduce %>
		</p>



		  <!-- 그러나 취미는 3개를 골랐는데, 하나밖에 안뜬다. 왜? 겟파라미터는 값을 하나만 가져온다..다중선택할 수 있는 것은 일단 겟파라미터로 하진 말자..
		
			 String[] hobby = request.getParameterValues("hobby");  
			 
			 이걸로 바꿔주자...
			 
			 아래 p문단의 취미 값들도 위처럼 변경하자
		  -->


</body>
</html>