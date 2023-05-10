package com.myweb.board.commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("*.board")   //.board로 끝나는 모든 요청에 반응.

@WebFilter( //이렇게써도됨. 위에꺼 주석하고.
		//원하면 필터이름 정하기 가능
		filterName = "loginAuth", //임의로지어봄
		//URL패턴(스트링배열형태)로 전달 가능
		urlPatterns = {"/write.board", "/modify.board", "/delete.board", "/myPage.user", "/modPage.user"}, //비회원이라도 목록은 볼 수 있게끔 만들었으니 board.list는 통과시키자
		servletNames = {"basic"}
		
		)
public class LoginAuthFilter extends HttpFilter implements Filter {
       
    public LoginAuthFilter() {
        super();
    }

    
    
    
    
	public void destroy() { //사실없어도그만인 메서드
		//필터 객체가 소멸할 때 실행되는 메서드
		//보통 초기화 시 생성했던 자원들을 종료하는 기능으로 사용한다.
	}

	
	
	
	
	
	//얘가 메인. 중요한 메서드. (로그인 중인지 아닌지 권한 확인하는 필터)
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		/*
		 	필터의 핵심 메서드인 doFilter()메서드는 클라이언트의 요청이 있을 때 마다 실행된다.
		 	request객체와 response객체를 넘겨주기 때문에 얘네를 가지고 요청과 응답을 조작할 수 있다.
		 	그리고 매개값으로 받는 FilterChain(위에적혀있음)을 통해 조작 이후, 요청을 원래 목적지인 서블릿으로 전달 할 수 있다.
		 */
			System.out.println("doFilter 메서드가 발동!");
			//로그인 했다 안했다를 세션 내에 있는 데이터로 파악한다.
			//그래서 세션부터 얻어오자
			//위의 ServletRequest request에 매개값으로 리퀘스트 들어오니, 달라하자
			HttpSession session = ((HttpServletRequest) request).getSession(); 
			//우리가 평소에 사용하던 타입은 HttpSErvletRequest 이다.
			//부모 타입의 ServletRequest를 자식 타입으로 끌어 내리시면 사용이 가능하다.
			//아무튼, 이제 받았으니 물어보자
			if(session.getAttribute("user") == null) { //유저라는 데이터가 없을리 없지. 로그인 했다면. 
				//그럼 필터를 통과할 수 없다.
				System.out.println("회원 권한 없음! 통과 안됨!");
				HttpServletResponse resp = (HttpServletResponse) response; //매개값으로 받은 레스폰스가 부모타입이니 자식타입으로 끌어내리자
			
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter(); //메서드쓸떄 throws~ 썼으니..예외처리X
				out.print("<script> \r\n");
				out.print("alert('로그인이 필요한 페이지 입니다.'); \r\n");
				out.print("location.href='/MyWeb/loginPage.user'; \r\n");
				out.print("</script> \r\n");
				
				
				//이제 위 스크립트 내용을 바로 쏘자
				out.flush();
				out.close();
				return; //doFilter 메서드를 끝내자 > 로그인 유효성을 통과하지 못했기 때문에 여기서 요청은 강제 종료.
			}
		
		//유효성 문제가 없다면 필터를 통과하게 하자.
		//이제 통과한 요청은 서블릿 클래스로 진입하게 된다. 즉, 로그인 중이라면 위내용들을 생략하고 여기로 바로 오겠지. 위로 올라가서 @WebFilter("/LoginAuthFilter") 부분을 맵핑해주자 ("*.board")로 바꿔주자
		chain.doFilter(request, response);
	}

	
	
	
	
	public void init(FilterConfig fConfig) throws ServletException { //사실없어도그만인 메서드
		//웹 컨테이너(서버)가 시작될 때 필터 객체를 생성하는데,
		//이 때, 객체가 생성되면서 최초 한 번 호출이 되는 메서드이다.(생성자랑비슷)
		//필터에서 처리 시 필요한 객체 등을 초기화(JDBC 관련 설정) 하는데 사용한다.
		//우리는 JDBC를 굳이 필터에서 사용할 필요 X. 이미 커넥션 풀로 초기화를 해놓은 상태이다.
		System.out.println("로그인 권한 필터 객체가 생성!");
		
	}
}
