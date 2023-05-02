<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--1부터 100까지의 누적합 --%>
	<%
	int total = 0;
	for (int i = 1; i <= 100; i++) {
		total += i;
	}
	out.print("<h4> 1부터 100까지의 누적합: " + total + "</h4>");
	%>
	<%-- 근데 깔끔하지 않다. foreach를쓰자 --%>




	<%-- foreach태그를 열기 전에 <c:set로 변수선언부터하자 --%>

	<%--	c:set 태그는 변수의 생성과 동시에, 이미 동일한 이름의 데이터가 존재한다면 기존의 데이터를 지목해서 값을 변경할 때도 사용한다.
		마치 setAttribute()에서 이미 존재하는 이름을 지목하여 값을 변경하는 것처럼.
	 --%>
	<c:set var="total" value="0" />
	<c:forEach var="i" begin="1" end="100" step="1">
		<%-- 포이치 안에는 반복실행 할 것을 쓰자. 그리고 var라는 제어변수 선언해주자. step은 몇씩 증가하냐는 것이다. --%>
		<c:set var="total" value="${total + i}" />
		<%-- 해석은 위에 total은 선언이고, 반복문안에서 작성된 이 total은 기존에 있던 애를 지목을 하는 것이다. 하나 더 변수를 선언한 것이 아니다. --%>
	</c:forEach>
	<h4>1부터 100까지의 누적합 : ${total}</h4>




	<hr>



	<%-- 구구단을 표현해보자 jsp태그로 먼저 이용해보자 --%>
	<h4>구구단 4단</h4>
	<%-- <% for(int hang=1; hang<=9; hang++) { --%>
	<%-- 4 x <%=hang%> = <%= 4*hang %> <br> --%>
	<%--} --%>
	<!-- 근데 태그가 더럽다. -->

	<%-- 이거를 foreach로 사용해보자. 일단 위 코드 주석처리하고--%>




	<c:forEach var="hang" begin="1" end="9" step="1">
		<!-- step을 생략해도 된다. 생략은 1씩 증가다  -->
		4 x ${hang} = ${4 * hang } <br>
	</c:forEach>




	<!-- 문제 : 구구단을 2~9단까지 출력하는데, 짝수단만 출력해라 -->
	<c:forEach var="dan" begin="2" end="9">
		<c:if test="${dan % 2 == 0}">
			<h4>구구단 ${dan}단</h4>
			<c:forEach var="hang" begin="1" end="9">
				${dan} x ${hang} = ${dan*hang} <br>
				</c:forEach>
				${'----------------------------------'}
				</c:if>
	</c:forEach>








	<hr>
	
		
	
	
	
	
	<h2>배열이나 컬렉션 내부의 값을 출력</h2>

	<%-- 배열선언해보자 --%>
	<c:set var="arr" value="<%=new int[] {1, 3, 5, 7, 9}%>" />
	
	<%-- 배열 내부를 반복문으로 돌려보자 --%>
	<c:forEach var="n" items="${arr}">  <%-- 제어변수선언해주자. 반복문 돌릴 대상이 배열이나 컬렉션이기 때문에 비긴엔드스텝이 아니라 반복문 돌릴 것을 items에 적어주자 그럼 arr이 n에 하나씩들어간다--%>
		${n} &nbsp; <%--하나씩 출력될 것임--%>
	</c:forEach>
	



	<%-- 값이 들어있는 리스트로 리스트 내부의 값을 출력해보자 (asList메서드 사용) --%>
	<c:set var="list" value='<%=Arrays.asList("가", "나", "다", "라")%>'/>  <%--asList는 List를 스트링타입으로 리턴해준다.--%>
	
	
	<c:forEach var="str" items="${list}">
		${str} <br>
	</c:forEach>

	
</body>
</html>