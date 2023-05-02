<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 3 -->

	<!-- age_form태그에서 넘어온 값들을 출력해주자 -->
	<c:set var="youngage" value="${param.youngage}"/> <!-- value는 youngage에 입력한 값이 들어간다! -->

	<!-- 사용자가 입력한 값 출력하자 -->
	# 이름 : ${param.name} <br> <!-- 얜 EL로 가져왔음 -->
	# 나이 : ${youngage} <br>
	
	
	
	<!-- 조건문시작(if문 말고 else문까지하는법) -->
	<c:choose> <!-- choose를 크게 열고 순차적으로. -->
		<c:when test="${youngage >= 20}">  <!-- test엔 조건식 쓰면 된다. -->
			<c:choose><!-- 이건 중첩 if문 -> 다시 choose열어줘야함 -->
				<c:when test="${youngage >= 40}">
					장년층 입니다.
				</c:when>
				<c:otherwise>
				<h3>청년층 입니다.</h3>
				</c:otherwise>
			</c:choose>
			<h2>당신은 성인 입니다.</h2>
		</c:when>
		<c:when test="${youngage >= 17}"> <!-- 첫번째 when은 20살이 넘지 않으니까 17살넘니? -->
			<h2>당신은 고등학생 입니다.</h2>
		</c:when>
		<c:when test="${youngage >= 14}">
			<h2>당신은 중학생 입니다.</h2>
		</c:when>
		<c:when test="${youngage >= 8}">
			<h2>당신은 초등학생 입니다.</h2>
		</c:when>
		<c:otherwise> <!-- otherwise는 else문과 같다. -->
			<h2>당신은 미취학 아동입니다.</h2>
		</c:otherwise>
	</c:choose>


</body>
</html>