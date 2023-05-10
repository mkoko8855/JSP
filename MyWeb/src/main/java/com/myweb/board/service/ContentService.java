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
		
		
		String bNum = String.valueOf(bId); //문자열로 받아오기 위해(위에서 일단 int로받았으니) 이렇게쓰자.
		//String bNum = request.getParameter("bId"); 로 해도됨
		
		
		//요청과 함께 넘어온 쿠기가 있는지부터 확인해야겠지?
		//지금 글번호에 쿠키가있는지 살펴보자
		boolean flag = false;
		Cookie[] cookies = request.getCookies(); //쿠키배열로받자
		
		if(cookies != null) { //널체크. 없으면널이 올수도있으니까
			//반복문돌리자~
			for(Cookie c : cookies) {
				//c라는 변수에 쿠키들이 하나씩 들어올 때 물어볼 것이다
				if(c.getName().equals(bNum)) {  //쿠키변수의 이름들(1번, 2번 같은 글번호) 과 지금요청된글번호가 같니?
					flag = true; //얘넨 쿠기가 살아있으니(이전에 봤던걸 또 본 셈이니 조회수를 올리면 안된다)
					break;
				}
			}
			if(!flag) { //플래그가 false라면. > 쿠키가 살아있을때 요청을 또보내면 flag가 true로바뀐다. 폴스는 쿠키없이 이 글을 처음 본다는 것이다. 그럼 얘는 조회수를 올려줘도 된다는 것이다. 
				//너가요청한 그 글번호로 쿠키를 만든다
				Cookie hitCoo = new Cookie(bNum, bNum); //생성자의 매개값으로 요청한 글 번호를 주기로했었다~ 이름도 값도 bNum으로줬다~
				hitCoo.setMaxAge(15); //15초동안 쿠키살아있음
				
				//응답이나갈떄 쿠키를 태워서 보낸다. 응답을 전담하는 메서드인 response메서드의 hitCoo라는 쿠키를 태우자~
				response.addCookie(hitCoo);//응답과 함께 쿠키가 전달 될 것이다.
				dao.upHit(bId);
			}
		}
		
		
	
		
		
		
		
		
		
//		dao.upHit(bId); //컨텐츠보드 부르기 전에 조회수 올려야한다. 즉, 이 자리에서 적어야 됨.      >     그러나 위의 쿠키 문제를 풀기 위해 여기 주석처리.
		
		
		
		
		
		
		
		
		BoardVO vo = dao.contentBoard(bId);  //컨텐츠보드는 하나만 가져오기 때문에 BoardVO객체를 리턴한다. BoardVO vo로 받아주자.
		
		vo.setContent(vo.getContent().replace("\r\n", "<br>")); //vo에다가 Content내용을 다시 써줄꺼야. 기존의 vo가 갖고있는 content를 가지고 오되, 리플레이스해주자(교체) > 즉, textarea가 자동 줄개행이 되는 것을 표현할 것이다.
		
		
		
		
		
		//클릭한 그 글을 몽땅 받아내자 (BoardDAO가서 contentBoard메서드를 먼저 완성하고 오자)
		request.setAttribute("content", vo); //content라는 이름으로 vo들을 다 담겠다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
