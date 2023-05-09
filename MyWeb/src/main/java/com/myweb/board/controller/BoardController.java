package com.myweb.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.service.ContentService;
import com.myweb.board.service.DeleteService;
import com.myweb.board.service.GetListService;
import com.myweb.board.service.IBoardService;
import com.myweb.board.service.ModifyService;
import com.myweb.board.service.RegistService;
import com.myweb.board.service.SearchService;
import com.myweb.board.service.UpdateService;

@WebServlet("*.board")   //컨트롤러는 서블릿클래스로 만듦(서블릿클래스만들떄 mapping과정을 사용하자~ *.board)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private IBoardService sv;
	private RequestDispatcher dp;
	
	
    public BoardController() {
        super();
    }

    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//이 서비스 메서드는 겟방식과 포스트방식을 구별하지 않는데, 포스트는 인코딩을 해야하잖아?
	if(request.getMethod().equals("POST")) {
		//포스트 방식이라면
		request.setCharacterEncoding("utf-8");
	}
	
	//url패턴을 동일하게 사용하니, 정제 처리를 해주자
	String uri = request.getRequestURI();
	uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf(".")); 
	
	//확인한번하기~
	System.out.println(uri);
	
	
	switch(uri) {
		
	case "write": //사용자가 글작성 버튼을 누르면 write.board라는 요청이 오는데, 위에 uri정제를 통해 .board를 걸러내고 있고, 앞에 My_Web도 걸러서 남은게 write뿐이다.
		System.out.println("글쓰기 페이지로 이동 요청!");
		response.sendRedirect("board/board_write.jsp");
		break;
	
	case "regist":
		System.out.println("글 등록 요청이 들어옴!");
		//이제 IBoardService에서 인터페이스 작성해주고왔으니,
		//위로 올라가서 (생성자위에) private IBoardService sv; 선언해주자 (IboardService타입의 sv변수)
		sv = new RegistService(); //객체만들어주고(빨간불 들어오니께 service패키지에서 RegistService클래스를 마우스 빨간줄에 대고 클래스 만들어주자.(이름만 RegistService로바꿔서)
		sv.execute(request, response);
		
		//글 등록이 완료됐으니 list로 가야겠지
		response.sendRedirect("/MyWeb/list.board");  //   board/board_list.jsp라고 적으면 안된다. 
													 //   jsp파일은 형태만있을뿐, 데이터 내용으로 뿌려주는 것이 아니다. 
		  											 //   글 등록 완료되었으니 글 목록을 보여달라고 다시 요청해야한다. 
													 //   그래야 글 목록을 싹다 뜯어올 수 있다.
													 //	  즉, board_list.jsp에는 DB로부터 전체 글 목록을 가져오는 로직을 작성하지 않을 것이다. (jsp는 단순히 보여지는 역할만 수행하기 때문이다)
												     //	  그래서 컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔, sendRedirect()를 사용하여 자동 목록 재 요청이 들어오게 해야 한다.
		break;
		
	case "list": //이게 바로 위 글이 말하는 재 요청 보내는 것이다. 이게 없으면 목록을 못본다.    (정제에 의해 MyWeb사라지고 board사라지고 list만 남음)
		System.out.println("글 목록 요청이 들어옴!");
		sv = new GetListService(); //클래스만들어야지~ 마우스갖다대서 만들자
		sv.execute(request, response); 
		//이제 어느페이지에 응답을 할 건지 판단해야한다.
		//세션이면 sendRedirect써도되지만, GetListService클래스에서 데이터를 리퀘스트에 담아서 전달했기 때문에, 세션이 아니기에 안된다.
		//옮겨주는 객체를 하나 만들어줘야 한다. forward방식을 사용해서 request를 원하는 jsp파일로 전달해서
		//그쪽에서 응답이 나갈 수 있도록 처리해야 한다.
		//즉, request객체를 다음 화면까지 운반하기 위한 forward 기능을 제공하는 객체는
		//RequestDispatcher 이다.
		dp = request.getRequestDispatcher("board/board_list.jsp"); //경로설정완료
		//이제 dp한테 명령내리자
		dp.forward(request, response); //그럼 디스패쳐가 리퀘스트내장객체와 리스폰스내장객체를 가지고 응답안나가고 우리가 지정한 path로 간다. 그쪽으로 전달된다.
		break; //꺼내는건 EL을 쓰자.  board_list.jsp의 tbody로가서 뿌려주자
		
		
	case "content":
		System.out.println("글 상세보기 요청이 들어옴!");
		sv = new ContentService();
		sv.execute(request, response);
		//list에도 dp를 사용하고 content에서도 dp를 사용하니, 전체적으로 이클래스안에서만 하기 위해 private RequestDispatcher dp; 를 선언해서 쓰자 맨 위로가서 선언하자
		dp = request.getRequestDispatcher("board/board_content.jsp"); //여기로가.
		dp.forward(request, response);
		break;
	
		
		
	case "modify":
		System.out.println("글 수정 페이지로 이동!");
		sv = new ModifyService();
		sv.execute(request, response);
		dp = request.getRequestDispatcher("board/board_modify.jsp");
		dp.forward(request,  response);
		break;
		
		
		
	case "update":
		System.out.println("글 수정 요청이 들어옴!");
		sv = new UpdateService();
		sv.execute(request, response);
		response.sendRedirect("/MyWeb/content.board?bId=" + request.getParameter("bId")); //포워드말고 sendredirect를 썼다. 그렇다고 이 줄에서 끝나면 안된다. 글 번호가 몇번인지 확실하게 알려줘야 한다. bId값 안주면 null인데 얘가 parse.int를 인식해버린다. 
		break;
		
		
	case "delete":
		System.out.println("글 삭제 요청이 들어옴!");
		sv = new DeleteService();
		sv.execute(request, response);
		response.sendRedirect("/MyWeb/list.board");
		break;
	
		
	case "search":
		System.out.println("글 검색 요청이 들어옴!");
		sv = new SearchService();
		sv.execute(request, response);
		if(request.getAttribute("boardList") != null) {
			dp = request.getRequestDispatcher("board/board_list.jsp");
			dp.forward(request, response);
		}
		break;
		
		
	}
  }
}
