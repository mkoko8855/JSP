<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<%
	
		/* 
		
		   세션에 저장한 데이터는 브라우저 창이 종료될 때 까지, 혹은
		
		   세션의 유효시간이 만료되기 전까지 웹 어플리케이션의 모든 jsp파일에서 사용이 가능하다.
		   
		   브라우저가 종료되면 세션도 같이 종료된다.
		   
		   세션도 쿠키처럼 유효시간을 설정할 수 있다. 그 시간이 만료되면 세션도 소멸됨.
		   
		   
		   세션에 저장된 값을 꺼내려면(가져오려면)
		   getAttribute()를 사용하며,
		   매개값으로는 가져올 세션 데이터의 이름을 적는다.
		
		*/
	
	
		//값을 꺼내보자
		String nick = (String)session.getAttribute("nickname");
		//그리고 나서 우리는 닉네임이란 이름으로 홍길동을 저장했는데,
		//홍길동은 String이잖아? String nick붙여줘봐. 에러메시지가 뜬다.
		//타입 미스매치가 뜬다. 오버젝트타입을 String타입으로 넣을 수 없다는 것이다.
		//session의 메서드인 getAttribute의 리턴 타입은 오브젝트이다.
		//(String)을 써줌으로써 강제 형변환해주자
		
		//배열도 마찬가지로 스트링 배열 타입으로 형변환해주자
		String[] hobbies = (String[]) session.getAttribute("hobbies");
	
		
		
		
		
		
		//값을 출력해보자~out.print로..바디에다가 해도되긴하는데..더배울거있으니
		out.print(nick + "<br>");
		out.print(Arrays.toString(hobbies) + "<br>");
		out.print("---------------------------------<br>");
		
		
		
		
		
		
		
		
		//세션의 유효기간 설정
		//참고로 세션의 수명을 따로 지정하지 않으면 기본 30분의 유효시간을 갖는다.
		//세션의 수명은 새로운 요청이 서버로 들어오면 초기화 된다. (쿠키는 요청이 몇번오든 자기가 갖고있는 수명까지만 유지하고 사라지지만, 세션은 그렇지 않다. 즉, 1시간을 설정했는데 1시간 내에 요청들어오면 다시 1시간이 된다.)
		session.setMaxInactiveInterval(60 * 60); //초단위라 60 * 60이면 1시간. 60* 5면 5분이다. 이걸 안적으면 30분의 유효시간이 있다.
		
		
		
		//세션의 남은 시간 확인
		int sTime = session.getMaxInactiveInterval();
		//원래 1800초인데 우리가 3600초로 바꿨으니 한번 확인해보자
		out.print("세션의 유효시간 : " + sTime + "초 <br>");
		out.print("---------------------------------<br>");

		
		
		
		
		//세션 데이터를 저장할 수 있으니 이번엔 특정 세션 데이터를 삭제해보자
		session.removeAttribute("nickname");
		//정말 지워졌는지 확인해보자
		nick = (String) session.getAttribute("nickname");
		out.print("삭제 후 nick의 값: " + nick + "<br>");
		out.print("---------------------------------<br>");
		//출력 결과 : null
		
		
		
		
		//이번엔 모든 세션 데이터를 삭제하는 법.(즉, 아예 무효화)
		session.invalidate();
		//위에서는 nick을 지웠는데 hobbies는 남아 있을 꺼잖아.
		//하비스가 남아 있는지 확인해보자
		hobbies = (String[]) session.getAttribute("hobbies");
		out.print("삭제 후 hobbies의 값: " + Arrays.toString(hobbies));
		//그러나 session.invalidate();로 모든 세션데이터를 삭제 했기 때문에 에러가 난다.
		//즉, 해당 페이지에서는 더 이상 세션 객체를 사용할 수 없기 때문에 에러가 난다.
		//그래서 getAttribute라는 행위 자체가 안된다.
		//그래서 새롭게 요청이 다시 들어오기 전까지는 세션 객체를 사용할 수 없다.
		
		
		
		
		
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