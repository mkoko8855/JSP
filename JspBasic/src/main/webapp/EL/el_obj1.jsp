<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 객체 생성해서 세션에 보관해서 el을 이용해서 꺼내는 방법. (자바 User클래스를 만든 직후다) -->


	<form action="el_obj2.jsp"> <!-- 사용자가 입력한 정보들은 el_obj2.jsp로간다 -->
		#아이디 : <input type="text" name="id"> <br>
		#비밀번호 : <input type="password" name="pw"> <br>
		#이름 : <input type="text" name="name"> <br>
		#이메일 : <input type="text" name="email"> <br>
		<input type="submit" value="확인">
	</form>





</body>
</html>