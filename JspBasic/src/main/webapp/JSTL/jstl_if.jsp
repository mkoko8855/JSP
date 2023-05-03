<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%--JSTL을 사용하기 위해서는 외부 태그 라이브러리를 선언부터 해야 한다. --%>
	<%--lib에 jstl-1.2jar를 끌어왔다고 쓸 수 없음. 외부태그라이브러리를 이 페이지에서 쓰겠다 라고 선언부터 해야한다. --%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1 -->
	<%-- 
		 JSTL의 c:set으로 변수를 선언하면 EL 안에서 활용이 가능하다.
		 값도 EL을 이용해서 매겨줄 수 있다.
		 타입은 생각할 필요 없다. EL이 자동으로 인식해서 정해준다. (더블이면 더블, 인트값들어가면 인트로해주고..)
		 c:set을 이용해서 지정한 변수는 스크립틀릿의 자바변수와는 다르다.
		 내장 객체의 지정하는 데이터로 활용되기 때문에 EL이 가능한 것이다.
		 scope를 작성하지 않으면 이 페이지 안에서만 사용할 수 있는 데이터인 "page"로 지정된다.
	 --%>
	<c:set var="age" value="${param.age}" scope="session"/>		 <!-- c:set은 내장 객체의 데이터를 바로 세팅할 수 있는 태그이다. scope는 application, session, request 등을 사용할 수 있다. -->

	<!-- 값이 잘 오는지 확인해보자 -->
	<p>
	
	나이 : ${age}세  <!-- 주소창 맨뒤에 ?age=30 적으면 나이 : 30세가 뜬다. -->
	
	<!-- 이제 여기다가 나이를 물어볼 것이다. 20살넘니? 넘으면 성인이다. -->
	<c:if test="${age >= 20}">   <!-- 하나의 조건만 쓸꺼면 c:if. else문을 쓸 거면 다른 태그를 써야 한다. -->
		<h2>당신은 성인 입니다.</h2>
	</c:if>	
		
	<c:if test="${age < 20}">
	<h2>당신은 미성년자 입니다.</h2>
	</c:if>
		
		
		
	</p>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>