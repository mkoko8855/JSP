<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
	
		//쿠키 내용을 다 꺼내보자(홍길동 안꺼냈었잖아)
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			//반복문 이용해서 다 꺼내자
			for(Cookie c : cookies){
				out.print(c.getName() + " : " + c.getValue() + "<br>"); //스크릿틀립하기귀찮으니
				out.print("-------------------------------------<br>");
			}
		}
	%>








<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2023/05/01 3번 -->






</body>
</html>