<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    	 <%--
	
		# 요청 파라미터 (request parameter)
		
		요청 파라미터란?
		
		클라이언트 측에서 서버로 데이터를 요청할 때, 함께 전달되는 값들을
		담은 변수를 요청 파라미터 라고 한다.
	
		요청 파라미터는 URL 주소 뒤에 ?를 붙인 후에, 
		
		[파라미터변수명=값]의 형식을 통해 서버로 데이터를 전송한다.
	
		요청 파라미터를 여러 개 전달할 때는 & 기호를 사용하여 나열해서 전달한다.
	
	 --%>



	
	<%
		//이제 클라이언트 쪽에서 전송된 요청 파라미터 값을 얻는 방법
		//키와 몸무게를 req_bim.jsp에서도 읽어야하니까!
		
//		request.getParameter("cm"); // 괄호안에는 얻고싶은 파라미터 변수명을 적자 > 인풋태그의 name에 보면 cm과 kg가 있다. 이제는 인풋태그도 name은 신경 써야 한다. 
									// 겟파라미터는 무조건 숫자도 문자열로 준다. 즉, 리턴타입이 스트링이다.
								    // bmi계산해야되는데 문자열이면 안되니
								    // 숫자로 변환해야한다. 정수면 Integer.ParseInt, 실수면 double.ParseDouble
	
		//일단은 문자열로 받아보자
		String strCm = request.getParameter("cm"); //리퀘야~요청들어온 cm값을줘
		String strKg = request.getParameter("kg"); //리퀘야~요청들어온 kg값을줘
		
		//bmi계산을 위해서는 변환을 해줘야겠지 키나 몸무게는 소수점도 있으니 double로 하자
		double cm = Double.parseDouble(strCm);
		double kg = Double.parseDouble(strKg);
		
		
		//이제 bmi 지수를 계산하자 > 일단 cm를 100으로 나누고 나눈거랑 곱한다. > 제곱이된다.
		double bmi = kg / (cm/100 * cm/100); //이렇게하면 소수점이 많이나오니 소수점둘쨰까지까리만.
		bmi = Math.round(bmi*100) / 100.0;   //둘째자리짜르자~
		
		//계산 구했으니 바디태그에 출력해주자
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>체질량 지수(BMI) 계산</h2>
	<hr>
	<p>
		- 신장 : <%=cm %> cm <br>
		- 체중 : <%=kg %> kg
	</p>
	
	<p>
	  BMI 지수 : <strong><%=bmi %></strong> <br>
	  <!-- 조건문으로 BMI 지수에 따라 저체중인가 과체중인지도 정해주자 -->
	  
	  <!-- 조건문은 자바문법이니 스트립틀릿 ㄱㄱ-->
	  <% if(bmi > 25) { %>
	  	당신은 과체중 입니다.
	  <% } else if(bmi < 18.5) { %>
		당신은 저체중 입니다.	  	
	  <% } else { %>
	  	당신은 정상 체중 입니다.
	  <% } %>
	</p>










</body>
</html>