package kr.co.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.board") //@WebServlet을 지정하면 따로 Web.xml로 가서 맵핑 안하고 클래스를 만들 떄 서블릿클래스로 
					  //생성할 떄 Next누르면 어노테이션으로만 처리가 가능하다. 
					  //즉, 우리가 지금 매핑을 처리한 것이다. 
				      //1. 이것을 디렉토리 패턴이라고 하며 디렉토리 패턴은 디렉토리 형태로 서버의 해당 컴포넌트를 찾아서 실행하는 구조가 되겠다.
					  //즉, 정해진 url로만 서블릿에 요청을 보낼 수 가 있다.

					  //2. 확장자 패턴 : 확장자 형태로 서버의 해당 컴포넌트를 찾아서 실행하는 구조이다.
					  //@webServlet("/board")를 @webServlet("*.board") 라고 적어보면,
					  //앞에 무엇이 작성되어있든간에 .board요청으로만 끝나면 해당 서블릿이 반응하겠다 라는 의미이다.
					  //이 별 앞자리에 어떠한 요청을 하는가 라는 키워드를 달아주면 된다. front_con.jsp로가보자
					  //JspBasic/board이 아니라 write.board 이런 식으로 써주자.
					  //그럼 이제 앞에 키워드가 뭔지 확인만할 수 있으면 뭐눌렀는지 구별할 수 있겠다.
					  //아래 service메서드로가자

public class FrontController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L; //이건그냥 스레드사용할떄 사용되는 것
       
	
	
    public FrontController() {
        super();
    }
    
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board의 요청이 들어옴!");
		System.out.println("그래서 service()메서드가 호출되었다!");
		//이제 webapp의 servlet클래스의 front_con.jsp클래스로 가서 a href적어주자
		
		
		
		
		
		//아래 service 메서드로 왔다.
		System.out.println("요청 URI : " + request.getRequestURI());
		//이걸로 콘솔창에서 update를 눌렀다는 것을 알 수 있다.
		
		
		//이 update나 write를 눌렀다는 것을 간단하게 알기 위해 다시 알아보자
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); //이 conPath에는 /JspBasic 이라는 문자가 들어가있을것이다. 이렇게 준비를 하고
		//이제 기존의 uri를 얻어왔으니 여기다가 대입을 할 것이다. 기존 uri에 키워드만 부분추출하겠다.
		
		// /JspBasic/.write.board 인 상태니, write만을 출력하기 위한 구문을 써주자
		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));
		//잘 정제됐는지 확인하자
		System.out.println("정제된 uri " + uri);
		
		//출력 결과 : 
		 /*
		 /board의 요청이 들어옴!
		 그래서 service()메서드가 호출되었다!
		 요청 URI : /JspBasic/delete.board
		 정제된 uri delete 
		 */
		
		//이제 if문 편하게쓸수있겠지. 정제했으니까
		if(uri.equals("write")) {
			System.out.println("글 등록 요청이 들어옴!");
		} else if(uri.equals("list")) {
			System.out.println("글 목록 요청이 들어옴!");
		}
		//즉, 하나의 서블릿으로 여러가지를 처리하려면(front_con.jsp가면 4개잖아) 이렇게 하면 된다.
	}
}
