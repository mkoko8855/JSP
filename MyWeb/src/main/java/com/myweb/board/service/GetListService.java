package com.myweb.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		//DB한테 말해서 전부 다 가져오면 되겠다.
		//입력을 통해 로직을 쓰는게 아니니 겟파라미터할거는 없다.
		//바로부르자
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.listBoard(); //글 목록을 boardList로 받자.
		
		//dao.뒤의 listBoard(); 부터 완성해주자 f3눌러서 ㄱㄱ > 완성했다.
		
		
		//이 boardList를 board_list.jsp로 가야겠지? 어떻게 값들을 갖다줄까?
		//가져온 boardList는 계속 유지되는 세션 을 쓰기에는 아깝다. 글 목록은 일회성인데..
		//세션보다는 한번 응답을 주고나는 자동으로 소멸하는 내장 객체를 사용하는게 좋다.
		//자동 소멸하면 알아서 지워지니 관리하기에도 용이하다. 즉, 직접 removeAttribute쓸필요도없음
		//세션보다 수명 주기가 짧은 리퀘스트객체를 쓰자.
		request.setAttribute("boardList", boardList);  //boardList라는 이름으로 boardList를 담겠다.
		//즉, 왜 session을 사용하지 않고 request를 사용하는가?
		//DB로부터 받아온 글 목록은 일시적인 데이터이다.
		//글 목록은 언제든 변할 수 있기 때문에 이러한 데이터를 굳이 session에 담아서 유지할 필요가 있을까?
		//화면으로 응답이 나가고나서 자동으로 소멸할 수 있도록 request에 담아서 화면으로 전달하고자 한다.
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
