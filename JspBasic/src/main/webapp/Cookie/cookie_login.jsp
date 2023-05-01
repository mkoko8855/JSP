<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- 문제.
        - 생성된 login_cookie 쿠키를 검색하여 쿠키가 이미 존재한다면
         로그인 폼 대신 브라우저에 "이미 로그인한 사용자입니다." 를 출력 후
         welcome 페이지로 이동할 수 있는 링크를 제공하세요.
        - login_cookie가 없는 사용자는 로그인 입력창이 등장하도록 구성하세요.
    --%>

<%
//아래 폼태그를 확인하기전에(로그인 전에)
Cookie[] cookies = request.getCookies();
boolean flag = false;
String userId = ""; //기억하기 체크박스 쿠키에서 값을 꺼내서 채울 변수다. 인풋창에 들어갈 값인데 null을 적어버리면 null이라고 뜬다. 비어있는 것이니 ""로 했다.

if (cookies != null) {
	for (Cookie c : cookies) {
		if (c.getName().equals("login_cookie")) { //로그인 쿠키가 없으면 flag는 폴스로 바뀌겠지~
	flag = true;
	break;
		}
		if (c.getName().equals("remember_id")) { //혹시 쿠키의 이름을 얻었는데 이것이 remember_id니?
	//그럼 사용자가 기억하기 라는 체크박스에 체크를 했다는 것이니 위로가서 String userId = ""; 를 선언해주자
	userId = c.getValue();
	//기억하기 체크했다면 쿠키의 들어있는 id가 user_Id라는 변수에 들어갈 것이다.
	//이제 form태그가서 value="" 에다가 완성해주자.
		}
	} //그리고 바디태그로 돌아가서 플래그가 폴스일때 폼 태그를 보여주는 거니 내려가서 스트릿플립으로 자바코드더쓰자
}
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 2023/05/01 4번 -->

	<%
	if (!flag) {
	%>
	<form action="cookie_login_con.jsp" method="post">
		<input type="text" name="id" size="10" placeholder="ID"
			value="<%=userId%>"> <input type="checkbox"
			name="id_remember" value="true"> <small
			style="font-size: 0.7em">아이디 기억하기</small> <br> <input
			type="password" name="pw" size="10" placeholder="PW"> <br>
		<input type="submit" value="로그인">
	</form>

	<%	} else { %>
	<h2>이미 로그인 중인 사용자입니다.</h2>
	<a href="cookie_welcom.jsp"> 웰컴 페이지로~</a>
	<%  }%>

</body>
</html>