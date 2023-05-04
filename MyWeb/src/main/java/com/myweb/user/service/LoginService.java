package com.myweb.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class LoginService implements IUserService {
	// 로그인 서비스 구현하는 부분

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) { 

		
		//리퀘스트와 레스폰스를 전달 받았으니
		
		/*
		우리가 할 일은
	    1. 파라미터값 얻어오기 (id, pw)
	    2. DAO 주소값 얻어오기
	    3. 로그인 유효성 검증 메서드 userCheck() 호출하기. //유저체크만드는법은 아래 있다. > UserDAO에다가 메서드 만들기
	    - 아이디가 없다면 스크립트 경고창 출력 후 로그인 페이지로 이동 (-1) (리턴 -1)
	    - 비밀번호가 틀렸다면 비밀번호가 틀렸다고 경고창 출력 후 뒤로가기 (0) (리턴 0)
	    - 로그인 성공일 경우 user_mypage.jsp로 리다이렉팅 (1) (리턴 1)
	    
	    4. 로그인 성공 시 페이지 이동 전에 getUserInfo()를 호출하여 (리턴타입이 userVO)
	     로그인을 성공한 회원의 모든 정보를 받아와서 세션에 저장해 주세요.
	    ( 세션 이름: user, 저장할 값: 로그인 성공한 회원의 UserVO 객체)
	    서블릿 클래스에서 세션을 사용하려면 request.getSession()을 통해 세션 객체를 받아 와야한다.
	    (type: HttpSession 인터페이스 타입)
	    */
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		UserDAO dao = UserDAO.getInstance(); //주소값 받아오기
		response.setContentType("text/html; charset=UTF-8"); //브라우저에 직접 응답을 써야하니 만들자(경고창을 브라우저에 띄워야 하니)
		String htmlCode; //상황에 따라 다른 문자를 만들어야할 수도 있으니까 변수선언.
		
		int result = dao.userCheck(id, pw); //id와 pw를 전달할 예정이며 리턴할 값은 int값이다. > 0 , 1, -1 셋 중 하나가 온다.
		
		try {
			PrintWriter out = response.getWriter(); //html도 해야 하니 이거 써주자
			
			if(result == -1) { 	//Usercheck 메서드 결과에서 얻은 결과값이 혹시 -1이니?
				//여긴 그럼 존재하지 않는 아이디다. 바로 쏘자
				htmlCode = "<script>\r\n"
                        + "                alert('아이디가 존재하지 않습니다.');\r\n"
                        + "                location.href='/MyWeb/loginPage.user';\r\n"
                        + "                </script>";
				out.print(htmlCode);
				out.flush(); //브라우저로 밀어내주자
				out.close();
			} else if(result ==0) { //아이디는 있고 비밀번호가 잘못된경우
				htmlCode = "<script>\r\n"
                        + "                alert('비밀번호가 틀렸습니다.');\r\n"
                        + "                history.back();\r\n"   //이건 뒤로가기!
                        + "                </script>";
				out.print(htmlCode);
				out.flush(); //쏴재껴
				out.close();
			} else { //로그인 성공은 브라우저에 내용(알러트)을 안쏘게 하자. 마이페이지로 보내달라했지. 근데 그 전에 회원의 모든 정보를 끌어오는 메서드인 getUserInfo를 불러 세션 데이터로 만들어 주세요 라고 했었지.
					 //그럼 우리는 getUserInfo 메서드를 완성해야겠다.
				UserVO vo = dao.getUserInfo(id); //매개값으로는 (지금 로그인을 성공한 겟파라미터한 id를 가져오자)
				HttpSession session = request.getSession(); //리퀘스트야 세션좀줘 > 내장객체 세션을 리턴해주겠지
				session.setAttribute("user", vo); //유저라는 이름으로 vo를 넣어라~
				response.sendRedirect("/MyWeb/myPage.user"); //이 요청을 다시 보내주세요~ 리다이렉트는 재요청이니~ 컨트롤러로 요청이 다시 들어간다 라는 것이다
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		
	                
	}
}
