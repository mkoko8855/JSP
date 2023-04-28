<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%--
   	    이 페이지는 전달된 요청이 어떤 요청인지를 확인 후,
    	그 요청에 맞는 페이지로 이동하는 것을 전담하는, 즉 컨트롤러 하는 페이지이다.
    	그렇기 때문에 이 페이지는 어떠한 화면을 사용자에게 응답하는 페이지가 아니다.
		자바 코드를 통해 요청 처리 후, 적절한 페이지로 이동시키는 역할을 담당한다. 이걸 나중에 클래스로 만들 것이다. (지금은 JSP파일에 익숙해지려고..)
    --%>
    
    
    <%
    	//나이를 먼저 받자~
    	//request.getParameter("age"); 		이 age는 input의 name이다.
    	//그러나 겟파라미터의 리턴타입은 스트링이기때문에 리턴값도 스트링이겠지. 문자로 이뤄진 숫자는 대소비교가 안되기 때문에 정수로 변환을 시켜야 한다.
		//2줄로 쓰지 말고 한번에 쓰자
		int age = Integer.parseInt(request.getParameter("age"));
    	
    	
    	
    	//이제 비교해도됨
    	if(age >= 20){
    		//내장객체 response가 제공하는 메서드 sendRedirect()를 통해
    		//원하는 페이지로 강제 이동할 수 있다.
    		//괄호 안에 이동시킬 페이지의 URL을 문자열로 적어주면 된다.
    		response.sendRedirect("res_basic_ok.jsp");	//괄호에는 내가 이동시키고자 하는 url을 적어주면 된다.
    	} else {
    		response.sendRedirect("res_basic_no.jsp"); 
    	}
		    	
    %>
    
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	






</body>
</html>