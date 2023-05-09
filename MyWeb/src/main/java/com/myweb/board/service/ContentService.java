package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		
		//상세보기요청은 글번호가 몇번인지 알아야한다. board_list클래스에 .board?bId=${b.bardId} 라는 번호를 적었었으니 얻어오자
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		//DAO의 주소값얻자
		BoardDAO dao = BoardDAO.getInstance(); //주소를받아야 객체부를수있으니. 싱글톤이니 new는 X
		
		
		
		
		
		/*
        # 쿠키로 조회수를 컨트롤 해 보자.
        1. 사용자가 글 제목을 눌러서 상세보기 요청을 보낼 때 
        글 번호로 된 쿠키를 하나 만들어 줄 겁니다. (String)
        쿠키 이름과 쿠키에 저장할 값을 모두 글 번호로 만들어 주겠습니다.
        쿠키의 수명은 15초로 설정하겠습니다.
        
        2. 요청을 보낼 때 같이 넘어온 쿠키 중에, 
         현재 글 번호와 일치하는 쿠키가 존재한다면 조회수를 올려주지 않을 겁니다.
         현재 글 번호와 일치하는 쿠키가 없다면 조회수를 올려주도록 하겠습니다.  
        */
		Cookie cookie = new Cookie(request.getParameter("bId"), request.getParameter("bId"));
		cookie.setMaxAge(15);
		
		
		Cookie[] cookies = request.getCookies();
		response.addCookie(cookie);
					
		boolean flag = false;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(request.getParameter("bId"))) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				dao.upHit(bId);
			}
		}
		
		
		
		
		
		
		
		
		
		
//		dao.upHit(bId); //컨텐츠보드 부르기 전에 조회수 올려야한다. 즉, 이 자리에서 적어야 됨.
		
		
		
		
		
		BoardVO vo = dao.contentBoard(bId);  //컨텐츠보드는 하나만 가져오기 때문에 BoardVO객체를 리턴한다. BoardVO vo로 받아주자.
		
		vo.setContent(vo.getContent().replace("\r\n", "<br>")); //vo에다가 Content내용을 다시 써줄꺼야. 기존의 vo가 갖고있는 content를 가지고 오되, 리플레이스해주자(교체) > 즉, textarea가 자동 줄개행이 되는 것을 표현할 것이다.
		
		
		
		
		
		//클릭한 그 글을 몽땅 받아내자 (BoardDAO가서 contentBoard메서드를 먼저 완성하고 오자)
		request.setAttribute("content", vo); //content라는 이름으로 vo들을 다 담겠다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
