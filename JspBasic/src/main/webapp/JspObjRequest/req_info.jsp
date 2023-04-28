<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	 <%--
	
		request는 브라우저에 대한 정보, 사용자가 전달하는 값에 대한
		많은 정보가 들어 있다. (요청에 대한 전반적인 정보)
	
		request 객체는 내장 객체 이다. 직접 생성하지 않아도 요청이 들어올 떄,
		자동으로 객체가 생성이 되기 때문에 바로 사용하면 된다.
		
	 --%>

	
	<%-- 리퀘스트 객체를 생성하지 않아도 부를 수 있다는 것을 보여주겠다. --%>	
		
	URL 주소 : <%=request.getRequestURL()%> <br> <%-- request야~요청들어온걸URL을 줘 > getRequestURL --%>
	
	URI 주소 : <%=request.getRequestURI()%> <br> <%-- request야~요청들어온걸URI을 줘 > getRequestURI --%>
	
	컨텍스트 루트 : <%=request.getContextPath()%> <br>
	
	서버이름 : <%=request.getServerName()%> <br>
	
	포트번호 : <%=request.getServerPort()%> <br>
	
	IP주소 : <%=request.getRemoteAddr()%>
	

</body>
</html>