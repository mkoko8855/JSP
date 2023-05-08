package com.myweb.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class ChangePwService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/*
	    1. 폼 데이터 처리 (기존 비번, 변경 비번)
	    2. dao주소값을 받아오시고, userCheck()를 활용하여 (userCheck는 로그인 할때 만들었던 int값 받는 그 3가지를 선택할 수 있는 메서드다 유저체크는 매개값으로 id와 pw를 받았었다.)
	     기존 비번과 아이디 정보를 바탕으로 해당 비밀번호가 일치하는지를 검사.
	     (id는 세션에서 구해옵니다.)
	    
	    3. 기존 비밀번호가 일치한다면 비밀번호 변경 메서드 changePassword() 호출. //DAO에 update실행.
	    4. "비밀번호가 정상적으로 변경되었습니다." 경고창 출력 후 mypage 이동.
	    5. 현재 비밀번호가 불일치 -> "현재 비밀번호가 다릅니다." 경고창 출력 후 뒤로가기.
	    */
		
		String oldPw = request.getParameter("old_pw");
		String newPw = request.getParameter("new_pw");
		
		/*
		HttpSession session = request.getSession(); 		//id를 세션에서 구해왔다.
		UserVO vo = (UserVO) session.getAttribute("user");  //세션한테 달라고하자(즉, 세션값 가져오기)
		String id = vo.getUserId(); 						//꺼내주자
		*/
		
		//위3줄을 한번에 처리하려면 이렇게 하면 된다. 익숙하지 않으면 위3줄처럼 하나씩 가져와라
		String id = ((UserVO)request.getSession()
									.getAttribute("user"))
									.getUserId(); //세션먼저받고 겟어트리뷰트하고 형변환 진행하고 거기에서 겟유저id를 바로 뽑자.
		
		
		
		
		UserDAO dao = UserDAO.getInstance(); //주소값받기
		//이제 userCheck를 부를건데, 한번에 부르자
		//일단 alert를 표현해서 응답줘야하니 프린트라이터가 필요하다.
		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;
		
		//프린트라이터로 객체를 받아오자
		try {
			PrintWriter out = response.getWriter(); //프린트라이터 객체 받기 성공
			
			if(dao.userCheck(id, oldPw) == 1) { //로그인을 한 이후이기 떄문에 0또는 1이오겠지. -1은없다.
				//1이왔다는건 기존 비밀번호가 일치했다는것이다.
				dao.changePassword(id, newPw); //변경은 newPw로 할 것이니까~
				//이제 html코드이용해서 응답줘야지
				htmlCode =  "<script>\r\n"
                        + "alert('비밀번호가 정상적으로 변경되었습니다.');\r\n"
						+ "location.href='/MyWeb/MyPage.user';\r\n"
                        + "</script>";
				
				
			} else { //0이면 기존 비밀번호가 틀렸다는 것이다.
				htmlCode =  "<script>\r\n"
                        + "alert('현재 비밀번호가 틀립니다. 그래서 변경 못해줘요!');\r\n"
                        + "history.back();\r\n" //뒤로가기
                        + "</script>";
				out.print(htmlCode); 	//이제 응답을 브라우저로 쏘자
				out.flush();			//밀어내주자~
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
