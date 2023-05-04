package com.myweb.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.service.ChangePwService;
import com.myweb.user.service.IUserService;
import com.myweb.user.service.JoinService;
import com.myweb.user.service.LoginService;


@WebServlet("*.user") //이건 맵핑한건데, 바꿀 수도 있다~ 바꾸는게 자유로움
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 인터페이스 타입의 변수를 하나 선언해서
	//요청이 무엇이냐에 따라 하나의 변수로 여러 종류의 객체를 사용한다. (바꿔끼운다)
	private IUserService sv;
	
	
	
    public UserController() {
        super();
    }
    
    
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//서비스 메서드가 시작되자마자 해야하는 일을 간단한 로직을 추가해주자
		if(request.getMethod().equals("POST")) { //리퀘야 혹시 POST와 방식이 같니? 겟메서드가 스트링이니 문자열비교를위해 equals로 썼다.
			request.setCharacterEncoding("utf-8"); //같으면 utf-8로 바꿔줘
		}
		
		
		
		
		//제일 먼저 정제하는 과정부터 처리하자
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length() + 1, uri.lastIndexOf(".")); //변수선언안하고 쭉 썼음 리퀘스트객체한테 받아낸거에 길이를 구하고 그 길이의 1보다 큰 부분에서 시작하고, 뒤에서 부터 탐색을 했을 떄 .이 있으면 . 미만까지 자르겠다~
		//혹시모르니 한번 출력해보자
		System.out.println("정제된 uri: " + uri);
		
		
		
		//이프문보다 스위치문쓰면 깔끔하겠지
		//사용자가 상단 메뉴의 join을 누르게 되면 join으로 가게끔하자. include파일 안에 header.jsp로가자 > 가서 "/MyWeb/joinPage.user" 를 추가해주자(공부할땐 이걸 찾기로 찾아서 공부하자)
		switch (uri) { 
		case "joinPage" :
			System.out.println("회원 가입 페이지로 이동 요청!");
			response.sendRedirect("user/user_join.jsp"); //절대경로쓰기 귀찮으면 상대경로써도되는데, 이건 jsp가 아니라 클래스니까 /MyWeb만 빼고 적자~
			break;
				
		case "join":
			System.out.println("회원 가입 요청이 들어옴!");
			//근데 id는 프라이머리키다. 회원가입 한 사람의 아이디가 있을테니 먼저 파악을 해야지. 
			//이미 테이블에 아이디가 존재한다면 돌려보내야지?
			//DB로 보내서 테이블에 아이디가 존재하니? 라고 물어봐야되는데 여기다가 DB연동로직 안적을꺼잖아?
			//연동로직을 담당하는 클래스를 만들러가자~ 모델계층에다가 user.DAO를 만들자
			
			
			
			
			//그러나 여기 적었던걸 모두 joinService클래스에 잘라서 복붙 해줬다.
			sv = new JoinService();
			sv.execute(request,  response); //리퀘스트와 레스폰스는 service 메서드에서 온 것이다. 서비스한테 그대로 넘겨서 서비스는 겟파라미터 등 기타등등의 작업을 할 수 있다.
			break;
			
			
			
		case "loginPage":
			System.out.println("로그인 페이지로 이동 요청!");
			response.sendRedirect("user/user_login.jsp");
			break;
			
			
			
		case "login":
			System.out.println("로그인 요청이 들어옴!");
			sv = new LoginService(); //로그인 서비스 객체를 이용하겠다. 빨간줄 들어올텐데 갖다대고 클래스 만들어주자
			sv.execute(request, response); //로그인 서비스가 일을 한 다음 브레이크 ㄱ
			break;
			
			
		case "myPage":
			System.out.println("마이페이지로 이동 요청입니다!");
			response.sendRedirect("user/user_mypage.jsp");
			break;
			
			
			
		case "pwPage":
			System.out.println("비밀번호 변경 페이지로 이동 요청!");
			response.sendRedirect("user/user_change_pw.jsp");
			break;
			
			
		case "changePw":
			System.out.println("비밀번호 변경 요청!");
			sv = new ChangePwService();
		}
	}
}
