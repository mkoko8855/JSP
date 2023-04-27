<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%!
	/*    <%!는 Declaration(선언자) 라고 합니다.
		  jsp 파일 내부에서 사용할 멤버변수나 메서드 등을 선언할 때 사용하는 태그입니다.
		  선언자에 작성한 코드는 jsp파일이 클래스로 변환이 될 때 
		  메서드가 아닌 클래스 블록에 선언됩니다. 스크립틀릿은 메서드 내부로 들어가고, 디클라레이션은 클래스 블록에 들어가기 때문에
	*/
	
	
	public int i;
	
	int add(int n1, int n2){
		return n1 + n2;
	} //이것들이 가능하다는 것이다.
%>



<!-- 
	1. 스크립틀릿 
	지역변수 및 메서드 내부의 코드를 작성하는 태그입니다.
	스크립틀릿에 작성한 내용은 jsp파일이 클래스로 변환 될 때,
	jsp_service()라는 메서드 내부에 작성됩니다.
	페이지 요청이 발생할 때마다 실행할 로직을 작성할 수 있습니다. 
	-->
<% 
	int j = 0; //가능. 그러나 메서드 내부로 들어가는 코드이기 때문에 public void hello(){} 같은 것은 안된다. 메서드 내부에 메서드는 선언이 안되니까.

	i++;
	j++;

	
	
	
	
	LocalDateTime now = LocalDateTime.now();	
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
	
	
	
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	jsp페이지 내에서 사용되는 변수의 값 또는 메서드의 리턴값을 브라우저에
	바로 출력할 때 사용하는 태그는 expression(표현자) 라고 한다.
	결과값의 타입은 > String으로 인식하고 
	jsp 파일이 클래스로 변환될 때는 out.print()로 변환이 된다.
 -->




<!-- 바디부분에서 i의 값과 j의 값을 확인 해보자 -->

	i의 값: <% out.print(i); %>

	j의 값: <%= j %>

	난수값: <%= Math.random() %> 


<!-- 
	 출력 결과 : i의 값: 2 j의 값: 1 난수값: 0.4677849457940617
	 그러나 계속 F5눌러보면 i와 난수값은 올라가는데 j값은 1에서 멈춰있는 것을 알 수 있다.
	 i는 디클라레이션이라는 선언자에 선언했음(얘는 클래스블록에들어감) > 멤버변수: 객체가 소멸하지 않는 이상 계속 누적 가능.
	 j는 스크립틀릿으로 선언했는데, 메서드로 들어감(지역변수의 소멸시기는 메서드 호출이 종료되면 소멸하니까)
-->







<!-- 스트립틀릿으로 구구단을 출력해보자 -->
<h2>
	구구단 7단
</h2>
<%
	for(int hang=1; hang<=9; hang++){
		out.print("7 x " + hang + " = " + 7*hang + "<br>"); 
	}
%>




	<hr>
	
	
	
	
<!-- 익스프레션으로 구구단을 출력해보자 -->
<h2>
	구구단 7단
</h2>
<% for(int hang=1; hang<=9; hang++) { %>
	7 x <%=hang %> = <%= 7*hang %> <br>
<% } %>





	<hr>
	<!-- 	LocalDateTime now = LocalDateTime.now();	<위에다 작성한 후   -->
	오늘 날짜 정보 : <%= now %>
	<!--    출력 결과 : 오늘 날짜 정보 : 2023-04-27T14:26:45.507882700        -->
	오늘 날짜 정보 : <%= now.format(dtf) %>
	<!--    출력 결과 : 오늘 날짜 정보 : 2023년 04월 27일 목요일 오후 02시 29분 07초 -->



 
</body>
</html>