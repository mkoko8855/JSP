<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%-- 
	make폴더의 코드가 실행되고, 바디태그가 사용자에게 응답될 떄, 쿠키도 같이 간다. 
	
	즉, 사용자는 해당 링크를 누르면(서버에요청하는행위) 쿠키도 같이 간다.
	
	--%>

	
	
	
	 <%
			//클라이언트 쪽에서 요청과 함께 전송된 쿠키를 가져오는 방법.
			//쿠키도 요청에 대한 리퀘스트객체한테 쿠키가 전달된다.
			//우린 전달된 쿠키가 무엇인지 확인하기 위해 일단 받아야 겠다.
			//리퀘스트한테 모두 다 달라고해야지, 하나가 아닐 수 있으니 배열로 받자
			Cookie[] cookies = request.getCookies(); //요청과 함께 쿠키가 전송되니 리퀘스트한테 달라고하면됨
	 
	 		
	 		//배열안에서 내가 원하는 쿠키가 존재하는지 찾아보자
	 		boolean flag = false; 				//내가 찾는 쿠키의 존재 유무를 파악할 변수를 하나 선언하고
	 		//반복문을 이용해보자. 리퀘스트객체한테 쿠키를 달라고 했는데 전달된 쿠키가 없으면 NULL을 줄 수도 있으니까..
	 		//널체크한번하자
	 		if(cookies != null){ //널이 아니면 반복문을 돌리겠다.
	 			//배열이니 향상포문
	 			for(Cookie c : cookies){
	 				//c라는 변수에 쿠키 객체들이 하나씩 들어온다.
	 				//그럼 아까내가 만들었던 쿠키가 있니? 라는 것을 조건문으로 확인하자
	 						if(c.getName().equals("id_cookie")){ //쿠키의 이름을 얻어오는 메서드인 getName().   >   id_cookie만 불렀고 홍길동은 안불렀음
	 						//이름이 id_cookie와 이름이 같다면 브라우저에 출력하자
	 								out.print("<h3> 아이디 쿠키가 존재합니다. </h3>");
	 						//그리고 쿠키의 값도 한번 얻어볼까?
	 								String value = c.getValue(); //겟네임은 이름, 겟밸류는 쿠키의 값을 얻어오는 메서드이다.
	 						//값도 얻었으니 값도 출력해보자
	 								out.print("쿠키의 값: " + value);
	 								//그리고 나서 쿠키를 찾았다 라는 증거를 남겨야 하니 플래그 트루로 바꾸고 반복문 break때려서 종료해주자
	 								flag = true;
	 								break;	
	 						}
	 			}
	 		//반복문 끝나고 나서
	 		//쿠키가 없을 수도 있잖아?
	 			if(!flag){ //플래그가 false라면.
	 				out.print("<h3> 아이디 쿠키가 사라졌거나 존재하지 않습니다.");
	 			}
	 		}
	 %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2023/05/01 2번 -->

		
	<!-- 그럼 위에서 홍길동 안불렀으니까 쿠키를 다 불러볼까 -->
	
	<a href="cookie_check_all.jsp"> 모든 쿠키 확인하기 </a>
		
		




</body>
</html>