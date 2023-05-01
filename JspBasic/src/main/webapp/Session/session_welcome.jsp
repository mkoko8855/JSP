<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%--
	문제
      1. 로그인하지 않은 사용자가 주소창에 이 페이지의 URL를 직접 적고
      들어왔을 경우 로그인창으로 돌려보내는 코드를 작성하세요.
      (조건문을 사용하여 로그인 성공 시 생성되는 세션이 있는지를 확인.)
      
      2. 로그인한 회원 아이디와 별명을 통해 "nick(id)님 환영합니다!" 바디에 
       출력하세요.
       
      3. a태그로 로그인창으로 돌아가는 링크와 request폴더에 앨범 선택 페이지로
       갈 수 있는 링크 2개를 작성하세요.
       
      4. session_login.jsp에서도 로그인 세션이 존재하는지를 확인하여 이미 로그인 중인 사용자와
       그렇지 않은 사용자가 서로 다른 화면을 볼 수 있도록 작성해 주세요.
       (로그인 성공 -> 이미 로그인 중이라는 화면, 로그인 x -> 폼)
	--%>

<%

	if(session.getAttribute("user_id") == null){ //로그인을 제대로 했다면 user_id가 null일 수가 없다. 세션을 만료됐거나 로그인 시도조차 안했다면 null이겠지
		response.sendRedirect("session.login.jsp");
	} else{
		String id = (String) session.getAttribute("user_id");
		String nick = (String) session.getAttribute("user_nick");
		 //요거이제 브라우저에 출력하면되지.
		 //else뚜껑을 여기서 닫지 않고 맨 맨 아래서 닫자. html부분도 보여줄 거니까. 일단 바디로 가서 else값 출력해주자


%>

<!-- 이건 Application파일 나갈 떄 세션과 비교하기 위해서 썼음 -->
<%@ include file="../Application/app_basic.jsp" %>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> <%=nick %> (<%=id %>)님 환영합니다!</h2>

	<!-- 3번 -->
	<a href="session_login.jsp">로그인 페이지로</a>
	<a href="../JspObjRequest/req_album.jsp">앨범 리스트 보기</a>


	<hr>
	
	
	
	
	<!-- 이것도 Applition진도 나갈 떄 세션과 비교해보기 위해 적음 -->
	<h3>요청된 횟수 : <%=count %>회</h3>




</body>
</html>


<% } %>


