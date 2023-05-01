<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	
	<%
	
		request.setCharacterEncoding("utf-8"); //포스트방식은 이렇게 깨지지 않게 처리 해줘야 함
		
		
		//사용자가 입력한 id 와 pw를 받자
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		if(id.equals("abc1234") && pw.equals("aaa1111")){
			//값은 사용자가 입력했던 id를 저장
			Cookie loginCoo = new Cookie("login_cookie", id); //이름은 login_cookie라고 지었다.
			loginCoo.setMaxAge(15); //15초만줘보자.
			//쿠키만들엇으면 응답과 함께 전달해야하니까
			response.addCookie(loginCoo);
			//(중간에 끼워넣을거 있음. 페이지 이동 전에 할일추가)
			//사용자가 아이디 기억하기 체크박스를 체크했는지에 대한 여부까지 확인해주자
			if(request.getParameter("id_remember") != null){ 	//id.remember는 체크박스이다. 사용자가 체크를 했냐 안했냐만 보자. 
					//겟파라미터는 체크안되면 null이 나온니까.
					//근데 이자리는 체크가 된 것이니까
					//쿠키 하나 만들어주자
					Cookie idMemory = new Cookie("remember_id", id); //사용자가 입력한 id를 저장해준다.
					idMemory.setMaxAge(30);
					response.addCookie(idMemory);
					//그러면 이제 응답과 함께 쿠키도 전달이 되겠지.
					//위 if문은 사용자가 체크를 했다면, 동작을 한다! > 체크했다면 remember_id란 이름으로 쿠키를 하나더 추가를 해준 것이다.
					//쿠키로그인.jsp로가서 써주자
			}
			//쿠키 세팅 다했으니 페이지이동해야지
			response.sendRedirect("cookie_welcome.jsp");
		} else {  //else는 둘다 틀렸거나 하나만 틀림 > 어쨋든 로그인 실패니까
			response.sendRedirect("cookie_login.jsp");
		}
	
	%>

	







<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2023/05/01 5번 -->

	




</body>
</html>