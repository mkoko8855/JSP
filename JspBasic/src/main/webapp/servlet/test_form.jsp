<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


								<!-- post방식도 가능 -->
	<form action="/JspBasic/basic" method="post">  <!-- servers파일의 Tomcat의 server.xml가서 맨아래로내리면 path부분에서 확인할 수 있음 -->
		# 아이디 : <input type="text" name="account"> <br>
		# 비밀번호 : <input type="password" name="password"> <br>
		# 이름 : <input type="text" name="name"> <br>
		# 이메일 : <input type="text" name="email"> <br>
		<input type="submit" value="확인">	
	</form>



</body>
</html>