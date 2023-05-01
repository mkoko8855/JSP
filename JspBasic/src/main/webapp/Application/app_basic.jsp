<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>





	<%
		//방문자수 카운트를 application 객체를 사용해보자
		
		int count = 0;
		if(application.getAttribute("visit") != null){
			count = (int)application.getAttribute("visit"); //겟어트리뷰트는 최상위객체니 인트로 강제형변환ㄱㄱ
			}
		count++;
		application.setAttribute("visit", count);
		
		//요청이 들어올 때마다 0으로 선언된 카운트 값들을 하나씩 올리면서 visit라는 이름으로 application이라는 이름으로 넣는다.
	
	%>







<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>