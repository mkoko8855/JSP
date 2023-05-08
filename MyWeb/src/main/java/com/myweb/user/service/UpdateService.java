package com.myweb.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UpdateService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * 1. form에서 넘어오는 데이터(파라미터)들 가져오기 
		 * 2. 데이터를 UserVO로 포장하기 
		 * 3. dao의 updateUser() 메서드를
		 * 호출해서 회원 정보 수정 
		 * 4. 수정된 정보로 세션 데이터를 교환(덮어씌우기) 
		 * 5. alter()을 이용해서 사용자에게 응답 주고
		 * 마이페이지로 이동.
		 */

		/*
		 * UserVO vo = new UserVO(); //데이터를 UserVO로 포장
		 * vo.setUserId(request.getParameter("id"));
		 */
		/*
		 * UserVO vo = new UserVO( request.getParamgeter("id"), null,
		 * request.getParameter("name"), request.getParameter("email),
		 * reqeust.getParameter("address) ); 로 써도됨 근데그냥
		 * vo.setUserId(request.getParameter("id")); 로 썻음
		 */

		UserVO vo = new UserVO();
		vo.setUserId(request.getParameter("id"));
		vo.setUserName(request.getParameter("name"));
		vo.setUserEmail(request.getParameter("email"));
		vo.setUserAddress(request.getParameter("address"));

		UserDAO dao = UserDAO.getInstance();
		dao.updateuser(vo); // dao의 updateuser에게 vo를 전달해주자~

		
		// 수정된 정보를 세션 데이터를 교환 어캐?
		request.getSession().setAttribute("user", dao.getUserInfo(vo.getUserId())); // DB에서 업데이트된 것을 가져와서 다시 새롭게 저장한
																					// 것이다.

		response.setContentType("text/html; charset=UTF-8");

		try {
			PrintWriter out = response.getWriter();
			String htmlCode = "<script>\r\n" + "  "
					+ "alert('회원 정보를 수정했습니다');\r\n"
					+ "                location.href='/MyWeb/loginPage.user';\r\n" + "  "
					+ "</script>";
			out.print(htmlCode);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
