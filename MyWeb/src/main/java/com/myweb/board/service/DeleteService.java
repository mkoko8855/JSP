package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//한번에써보자
//		BoardDAO.getInstance().deleteBoard(Integer.parseInt(request.getParameter("bId")));
		
//		int bId = Integer.parseInt(request.getParameter("bId"));
//		BoardDAO dao = BoardDAO.getInstance();
		
			BoardDAO
				.getInstance()
				.deleteBoard(Integer.parseInt(request.getParameter("bId")));
		}
	}
