<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%
    
    	//Post 방식을 통해 전달된 데이터의 한글 처리는 메서드를 사용하면 된다.
    	//Post 전송 방식은 요청 헤더 파일의 메세지 바디 부분에 숨겨져서 전송이 되는데,
    	//전송 과정에서 문자열이 디코딩 되어서 전송된다. (한글이 표현이 안되니 특문으로 전송된다)
    	//이제 디코딩 된 문자를 인코딩하는 과정이 필요하다.
    	//즉, 이름은 정상출력이 안되서 깨지니까 인코딩 해야한다는 소리다.
    	//getParameter하기 전에 바로 아래 코드를 써서 처리를 하면 된다.
    	request.setCharacterEncoding("UTF-8"); //소문자도가능
    	
    
    	
    	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
	%>
	
		<!-- 겟파라미터로 가져온 데이터를 바디에다가 확인하자 -->
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<p>
		
		# 아이디 : <%=id %> <br>
		# 비밀번호 : <%=pw %> <br>
		# 이름: <%=name %>
		
	</p>




</body>
</html>