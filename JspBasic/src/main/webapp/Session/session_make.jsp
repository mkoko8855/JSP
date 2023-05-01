<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<%--
	
		세션은 쿠키와 마찬가지로 http 통신 데이터를 유지하기 위한 수단으로 사용한다.
		
		세션에 데이터를 저장할 때는 jsp 내장 객체 session이 지원하는
		setAttribute()라는 메서드를 사용한다.  (세션의 속성을 사용하겠다 라는 의미로 setAttribute라고 한다)
		해당 메서드의 첫번째 매개값으로는 세션의 이름,
				  두번째 매개값으로는 세션에 저장할 값을 지정한다.
	 --%>
	
	
	<%
		//쿠키는 생성했었지만 세션은 요청이 들어오면 자동 생성된다.
		session.setAttribute("nickname", "홍길동");
		//세션은 저장할 수 있는 한계가 없다. 쿠키는 문자열만 저장이 된다.
		session.setAttribute("hobbies", new String[]{"축구", "독서", "게임"}); //쿠키는 new String[] 안된다. 얘는 배열도 가능.
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<a href="session_check.jsp">세션 데이터 확인하기</a>









</body>
</html>