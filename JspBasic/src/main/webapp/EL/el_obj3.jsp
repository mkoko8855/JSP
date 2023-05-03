<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!-- 일단 세션데이터 먼저 받아야해서 스클립틀릿(자바문법) 열자 -->
	<%
	User user = (User) session.getAttribute("member"); //그럼 얘가 객체를 리턴하는데, 리턴 타입이 오브젝트타입이니 User타입으로 끌어내리자
	%>
	
	
	
	<!-- 이제 세션데이터 받았으니 출력해야지 -->
	
	<p>  <!-- 지금까진 우린 이렇게 했었다. -->
		# 이름: <%=user.getUserName() %> <br>
		# 아이디: <%=user.getUserId() %> <br>
		# 이메일: <%=user.getUserEmail() %>	<br>
		# 비밀번호: <%=user.getUserPw() %>
	</p>

	<hr>
	
	<p>	<!-- 그러나 el을 이용하면 이렇게 한다. -->
		# 이름: ${sessionScope.member.userName} <br>  <!-- 일단 FM으로 쓴다면 -->
		# 아이디:${member.userId} <br> 
		# 이메일:${member.userEmail} <br>
		# 비밀번호:${member.userPw} 
	</p>
	
	
	
	

</body>
</html>