package com.myweb.board.service;

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
		BoardVO vo = dao.contentBoard(bId);  //컨텐츠보드는 하나만 가져오기 때문에 BoardVO객체를 리턴한다. BoardVO vo로 받아주자.
		
		//클릭한 그 글을 몽땅 받아내자 (BoardDAO가서 contentBoard메서드를 먼저 완성하고 오자)
		request.setAttribute("content", vo); //content라는 이름으로 vo들을 다 담겠다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
