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
	<form action="/JspBasic/basic" >  <!-- servers파일의 Tomcat의 server.xml가서 맨아래로내리면 path부분에서 확인할 수 있음. 참고로 이 주소는 클래스로 바로 요청넣을 수 없기에 가상의 url작성하고 이 url로 요청이 들어왔으면 우리가만든 서블릿클래스로 객체만들고 메서드호출하게 하자 라는 것이다. 이것을 web.xml에다 적었다.-->
		# 아이디 : <input type="text" name="account"> <br>
		# 비밀번호 : <input type="password" name="password"> <br>
		# 이름 : <input type="text" name="name"> <br>
		# 이메일 : <input type="text" name="email"> <br>
		<input type="submit" value="확인">	
	</form>

	
</body>
</html>