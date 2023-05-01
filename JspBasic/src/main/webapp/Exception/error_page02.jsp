<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%> <!-- 여기가 에러나면 발생할 페이지가 맞니? 네! -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<p>
		요청 처리 과정에서 에러가 발생했습니다. <br>
		빠른 시간 내에 문제를 해결 하겠습니다 .<br>
		잠시만 기다려 주세요
	</p>

	<p>
		에러 원인 : <%=exception.getMessage() %> <!-- exception이라는 내장 객체 쓰려면 위의 에러 페이지 맞냐는 선언을 해줘야 한다. -->
	</p>

</body>
</html>