<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> BMI 계산기 </h2>
	
	<form action="req_bmi.jsp"> <%--키와 몸무게 정보는 submit을 누르면 req_bmi_jsp로 이동할 것이다. --%>
		키 : <input type="text" name ="cm" size ="5"> cm <br>
		몸무게 : <input type="text" name="kg" size="5"> kg <br>
		<input type="submit" value="계산">
	</form>

	
	
	
	
	
	



</body>
</html>