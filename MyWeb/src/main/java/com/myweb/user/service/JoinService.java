package com.myweb.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

//클래스로 만들되 interface에 add해서 IUService를 추가해주었다.

public class JoinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

//		String id = request.getParameter("id");
//		UserDAO dao = UserDAO.getInstance();
//		boolean flag = dao.confirmId(id);
//		if(flag) {
//			System.out.println("아이디가 중복되었습니다");
//		} else {
//			System.out.println("회원가입 계속 진행 가능");
//		} 확인했으니 주석
		
		String id = request.getParameter("id");
		UserDAO dao = UserDAO.getInstance();
		
		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;
		PrintWriter out;
		
		try {
			out = response.getWriter();
			
			//컨펌아이디 중복확인하자 > 아이디가 중복되면 브라우저로 바로 응답.
			if(dao.confirmId(id)) { //여기에 트루가 오면 중복 발생이다.
				htmlCode =  "<script>\r\n"
                        + "alert('아이디가 중복되었습니다.');\r\n"
                        + "history.back();\r\n"
                        + "</script>";
				out.print(htmlCode);
				out.flush(); //브라우저로 밀어내고 버퍼를 비워라~
				return; //메서드 강제 종료
			} else { //컨펌id의 리턴값이 false라면, 즉 아이디가 중복되지 않았기 때문에 회원가입이 계속 진행이 된다.
				//아이디 받아왔잖아 위에 String id = request.getParameger("id")로. 겟파라미터또할필요없지
				UserVO vo = new UserVO(
							id,
							request.getParameter("pw"),
							request.getParameter("name"),
							request.getParameter("email"),
							request.getParameter("address")
						);
				//dao야 인서트해줘 내가너한테 포장한 vo줄게^^ > 지금 insertUser메서드없으니 UserDAO가서 써주자
				dao.insertUser(vo);
				
				//이제 회원가입 끝났으니 로그인페이지로 이동시켜주자 대신 로그인페이지로 바로가지말고 축하한단 경고창하나띄워주면서~
				htmlCode = "<script>\r\n"
                        + "                alert('회원가입을 환영합니다!');\r\n"
                        + "                location.href='/MyWeb/loginPage.user';\r\n"
                        + "                </script>";
				out.print(htmlCode);
				out.flush();
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
