<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 주 석 -->


	<%
	//스크립틀릿 안에는 자바코드 쓴다했지.
	//스크립틀릿 내부에서 자바 주석을 사용할 수 있다.
	
	/*
	여러 줄 주석도 가능하다.
	123
	12
	ABC
	*/
	%>


	<!-- HTML 주석 > 페이지 소스 보기를 하면 보임  -->
	여기는 주석이 아니에요1
	
	<%-- 이것은 JSP 주석 > 페이지 소스 보기를 하면 안보임 --%>
	여기도 주석이 아니에요2
	
	<!-- 프론트쪽이랑 공유할 내용 있으면 HTML주석을 달면 되겠다. 공개를 원치 않으면 JSP주석을 쓰자 -->

</body>
</html>