package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
//		int boardid = Integer.parseInt(request.getParameter("bId"));
//		String boardtitle = request.getParameter("bTitle");
//		String boardcontent = request.getParameter("bContent");
//		BoardDAO dao = BoardDAO.getInstance();   더 가독성 좋게 써보자
		
		BoardDAO.getInstance().updateBoard(
					request.getParameter("bTitle"),
					request.getParameter("bContent"),
					Integer.parseInt(request.getParameter("bId"))
				); //이러면 코드 가독성이 좋지. 적고 BoardDAO의 updateBoard 완성하러고고
		
		
		//포워드방법이 아님을 생각하자. 더 쓸것은 없다.
		
		
		
		
		
		
		
		
		
		
		
	}
}
