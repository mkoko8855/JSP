package com.myweb.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.commons.PageCreator;
import com.myweb.board.commons.PageVO;
import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		//맨 아래 내용들보다 먼저 페이징을 처리할 것들이 있다.
		PageVO paging = new PageVO(); //객체생성
		BoardDAO dao = BoardDAO.getInstance();
		//사용자가 처음 게시판에 들어올 때는 페이지 선택을 하지 않기 떄문에
		//생성자가 기본값을 지정해 준다.
		//페이지 정보가 파라미터 값으로 넘어올 경우에만 getParameter를 하겠다.
		//즉, 사용자가 처음 들어왔을 때는 page와 cpp는 안온다. 거기서 getParameter쓰면 널이 오기 때문에 문제가 생긴다.
		//정보가 넘어올 경우에만 getparameter해주기 위해 조건문 쓰자
		if(request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page"))); //겟파라미터 변수명은 아직 안만들었지만 page라고 일단 정하자
			paging.setCpp(Integer.parseInt(request.getParameter("cpp")));
		}
		
		System.out.println(paging); //toString오버라이딩 해놨으니 찍어보자
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//DB한테 말해서 전부 다 가져오면 되겠다.
		//입력을 통해 로직을 쓰는게 아니니 겟파라미터할거는 없다.
		//바로부르자
		//BoardDAO dao = BoardDAO.getInstance();  > 주소값 가져왔는데, 페이징 처리할때부터 사용하려고 위에다쓰고 이건 주석처리.

		List<BoardVO> boardList = dao.listBoard(paging); //글 목록을 boardList로 받자. (BoardDAO의 public List<BoardVO> listBoard() { 메서드 내용을 받은 것이다)
													
		
		
												   	     //!!!!!!!!!!그러나 페이징한 후, 그에 맞는 정보만 가져오기 위해 ()에 paging쓰자. 페이징 전에는 아무것도 안적었다.
														 //!!!!!!!!!!그리고 BoardDAO가서 listboard를 오버라이딩 한 곳에 매개값 적어주자~~~~~~
												         //그리고 IBoardDAO가서도 메서드 적어주자
		
		
		//페이지 버튼 배치를 위해 객체를 생성
		PageCreator pc = new PageCreator();
		//페이징 버튼 알고리즘을 위해 PageVO 객체와 총 게시물 수를 setter를 이용해서 전달 할 것이다.
		pc.setPaging(paging); //PageVO객체인 paging을 전달.
		pc.setArticleTotalCount(dao.countArticles()); //알고리즘도 같이 돌자~
		
		
		
		
		
		//commons에 PrageCreate클래스를 만들어서 여기로 가보자
		
		
		
		
		
		
		
		
		
		
		
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
		
		
		
		
		
		
		//JSP파일에서 버튼 배치를 위해, 모든 정보가 완성된 PageCreator 객체를
		//request 객체에 담아서 forwarding 하겠다.
		request.setAttribute("pc", pc);
		
		
		
		//위 request와 위위 request를 객체에 담았다. pagecreate를 담았고, 컨트롤러에서는 디스패쳐 객체를 담아서 보드리스트.jsp로 보낼거다. 포워드를 이용해서 전달이 되겠다! board.list.jsp로가자
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
