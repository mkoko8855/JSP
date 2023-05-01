<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<%
	
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		if(id.equals("abc1234") && pw.equals("aaa1111")){
			
			//id와 pw가 맞으면 쿠키를 만들어줬었는데, 이번엔 세션하라했지? 세션을 만들자
					session.setAttribute("user_id", id);
					session.setAttribute("user_nick", nick);
					response.sendRedirect("session_welcome.jsp");
		} else {
			//로그인 실패 부분이니, 아래 자바스크립트까지 이용해서 처리했다. 자바스크립트는 스크릿틀립 안에 쓰면 안되기 때문에 밖으로 빼 내었다.
	%>
		<script>
		
			alert('로그인에 실패 했습니다.');
			
			//로케이션은 sendRedirect와 같다. 자바스크립트니까 로케이션쓴거임
			location.href = "session_login.jsp";
		
		</script>


		<% } %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>