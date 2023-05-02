<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 기초 -->



	<!-- 지금까지 우리는 아래의 이런 jsp태그들로 브라우저에 표현할 수 있었다.. -->
	<%int i = 5; %> <!-- 이 스클립틀릿의 변수 선언은 아래 i를 부를 수 있다. -->
	<p>
			<%= 10 * 4 %> <br>   <!-- out.print(10*4) -->
			<%= 5.55 + 3 %> <br>
			<%= "안녕하세요" %> <br>
			<%= i %>
	</p>








	<hr>
	
	
	
	
	
	
	<!-- 그럼, 다음은 EL에 대해 살펴보자. 얘도 똑같이 브라우저에 출력할 때 사용한다. -->
	<!-- 
	
	EL은 브라우저에 특정 값을 표현하기 위한 언어이다.
	EL을 통해 데이터를 표현할 때, 스틀립틀릿으로 작성한 변수의 값은
	EL로 가지고 올 수 없다.
	EL이 접근하는 범위는 JSP 내장 객체 범위이다. (request, session, reponse, application..과같은)..
		
	 -->
	<p>
	 ${10 * 4} <br>
	 ${5.55 + 3} <br>
	 ${'안녕하세요~'} <br>
	 ${i}  <!-- 그러나 i는 출력이 안된다. 위 스트립틀릿은 이 i를 변수로 뽑아주지 않는다. -->
	</p>










</body>
</html>