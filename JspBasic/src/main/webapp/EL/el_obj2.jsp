<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- el로는 생성을 못하니 스크립틀릿으로 유저객체 생성해주자 -->
    <%
    
    User user = new User( //생성자 만들어놨으니 괄호 크게 열자
    			request.getParameter("id"),
    			request.getParameter("pw"),
    			request.getParameter("name"),
    			request.getParameter("email")
    		); //사용자의 입력값을 user객체로 다 담고
    		
    		session.setAttribute("member", user); //세션에다가 member라는 이름으로 user라는 객체를 저장했다. 그리고 바디태그의 링크로가서 출력하자
			//이제 member를 통해 세션에서 꺼내서 사용자가 입력한 값을 출력해보자. 기본의 방법과 el의 방법이 뭐가 다른지 살펴보자    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="el_obj3.jsp">el로 세션 내의 객체의 값을 표현하기</a>

</body>
</html>