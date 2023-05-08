package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		String writer = request.getParameter("bWriter");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		BoardDAO.getInstance().regist(writer, title, content); //주소값을 받아오면서 SQL을 만들고 DB에 집어 넣어주게 된다.
		//이제 regist작성하러 가자 > BoardDAO에 작성해줬다.
		//글등록했다고 alert띄우지 않기 떄문에 여기서 할일은 끝~
		
		
		
	}
}
