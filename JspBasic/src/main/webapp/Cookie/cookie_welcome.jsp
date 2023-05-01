<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
	
		Cookie[] cookies = request.getCookies(); //리퀘스트야 응답한거 다 나한테넣어줘
		String userId = null; //일부로 null을 넣음. > id를 찾았으면 id를 userId에 넣어줄거고 쿠키에 id없으면 null이니까 널을 넣어줌
		
		if(cookies != null){
			//널이 아니라면 뭔가 있다는 것이니
			for(Cookie c : cookies){  //flag말고 다른 방식으로 썼다.
				if(c.getName().equals("login_cookie")){
					//로그인 성공도 되고 쿠키도 살아있으니까
					userId = c.getValue();//userId에 밸류값넣어주겠지
					//찾았으니까 break널어주자
					break;
				}
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
<!-- 2023/05/01 6번 -->

    			<!--userId가 널이냐 아니냐에 따라서 화면에 출력되는 것이 다르도록 처리해보자 -->
    			
    			
	<% if(userId != null) { //아직 로그인 유효하다는 거다(쿠키안없어진것) %>
	
		<p>
			<%=userId %> 님 환영합니다! <br>
		</p>
	
	
	<% } else { //else는 애초에 로그인 안했거나 로그인 쿠키 시간이 만료 된 것%>
	
		<p>
			시간이 지나 자동 로그아웃 처리 되었습니다.
		</p>
	
	<% } %> 
	
	
	<a href="cookie_login.jsp"> 로그인 화면으로 </a>
	
	


</body>
</html>