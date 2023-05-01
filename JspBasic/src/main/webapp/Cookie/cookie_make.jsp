<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
//      # 쿠키 생성 방법
//      쿠키 객체를 생성 : 생성자의 매개값으로 쿠키의 이름과 저장할 데이터를 입력(String). 문자열로만.
     
 		String id = "abc1234";
    
    	//쿠키생성 > 임포트안되는 이유는 탐캣이 자동으로 임포트 해주기 떄문에 우리가 임포트할 필요는없다
    	//나중에 JSP파일이 아니라 클래스에서 쿠키를 사용할 때는 임포트가 필요하다.
    	//JSP파일에서는 쿠키 임포트 할 필요없다. 그냥 쓰면 된다.
    	Cookie idCoo = new Cookie("id_cookie", id); //일단 객체 생성하고 그리고 매개값을 id_cookie로주자
     	
    	//쿠키를 하나 더 만들어 보자, 위와는 다른 방법으로 이름을 한번에 한번 저장해볼까
    	Cookie nameCoo = new Cookie("name_cookie", "홍길동"); //쿠키의 이름인 name_cookie과 저장할 값으로 "홍길동"을 줬다.
    	
    	
    	//쿠키 객체를 생성했으면
    	//2. 쿠키 클래스의 setter메서드로 쿠키의 속성을 설정하자.
    	//가장 많이 쓰는 속성은 수명이다. 수명 속성을 지정해줘야 한다. 쿠키사용할때는 수명(유효시간) 설정이 필수다. 아니면 쿠키를 못쓴다.
    	nameCoo.setMaxAge(60 * 60); //쿠키의 유효 시간 설정. 초로 주면 된다. 1시간 > 60 * 60이면 1시간짜리 쿠키를 생성할 수 있다.
    	
    	//id쿠키도주자
    	idCoo.setMaxAge(20); //얘는 20초로만 만들어보자
    	
    	
    	
    	//3. 이제 쿠키를 설정했으면 HTTP 응답 시, response 객체에 생성된 쿠키를 탑재해서 클라이언트로 전송하자.
    	//서버에서 만든 쿠키는 사용자쪽에 저장이 된다. 그래서 쿠키를 생성했으면 사용자에게 지금 이 페이지가 전달이 될 때, 같이 전송을 해주면 된다.
    	//응답할 때 쿠키를 보내면 되니까 reponse객체의 메서드를 만들어서 전달해주자
    	response.addCookie(nameCoo);  //즉, 쿠키를 실어서 전달해주자
    	response.addCookie(idCoo);    //즉, 쿠키도 같이 전달된다~ 요청이 들어갈 때마다 쿠키도 항상 서버로 요청이 된다.
    %>
    
    
    	
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2023/05/01 1번 -->

	
		<!-- 그럼 이제 쿠키를 확인해보자. 쿠키가 유지되는지 다른 페이지로 이동(요청이 들어갈 때 쿠키도 같이 전달됨)했을 떄 제대로 되는지 확인해보자-->
		<a href="cookie_check.jsp">만든 쿠키 확인하기!</a>

</body>
</html>