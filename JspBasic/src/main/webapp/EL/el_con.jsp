<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


	<%
	//이쪽으로 데이터 넘어온거니 우리는 기존에 이렇게 했다
	
	/* 
	   String name = request.getParameter("name");
	   String nick = request.getParameter("nick"); 
	*/
	
	//바디로 가서 출력을 해보면,
	%>









<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2	(1 다음으로 연결) -->

	<!-- 바디로 와서 출력. 그러나 이제 이렇게는 X. 위에도 여기도 주석처리하자 -->
	<%-- <p>
	  # 이름 : <%=name %> <br>
	  # 별명 : <%=nick %> <br>
	</p> --%>
		
	
	
	
	
	<!--  EL로 똑같이 이름과 별명을 출력해보자 -->
	<p>
		<!-- 파라미터값에 바로 접근하게하는 메서드는 param.변수명 -->
		# 이름 : ${param.name} <br> <!-- 파라미터값 중에 name을 불러와라 -->
		# 별명 : ${param.nick}
	</p>







	<!-- EL은 값 저장은 없다. 값을 꺼내오는 것에 특화되어있다. 비교를 위해 일단 세션과 어플리케이션에 저장해보자-->
	<%
		session.setAttribute("data1", "hello~!"); 
		application.setAttribute("data2", "bye~!");
		session.setAttribute("data2", "이름은 같지만 다른 데이터"); //중복된 이름인데 el_result.jsp에서는 data2 말고는 데이터 영역을 명시하지 않았다. 그럼 session에 있는 ${data2} 는 data2인 "이름은 같지만 다른 데이터" 라는 것을 불러오겠지.
	%>
	<a href="el_reuslt.jsp">EL과 비교를 위한, 세션과 어플리케이션 데이터를 화면에 출력해보자</a>







</body>
</html>