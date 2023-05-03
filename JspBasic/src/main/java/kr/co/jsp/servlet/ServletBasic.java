package kr.co.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//servlet이라는 폴더도 만들었다.


	 /* JSP파일은 view의 역할만을 하고 컨트롤러는 클래스쪽에서 처리를 해주는 것이 좋다.
	   	
	  	서블릿이란?
	  	웹 페이지를 자바 언어로만 구성하는 것이다.
	  	즉, JSP 파일을 자바 언어로만 구성하는 것 이다. (우리가 만들었던 con.jsp..이런 것들은 비효율적이다)
	  	
	  	탐캣을 사용해서 JSP 파일을 자동으로 CLASS로 변환했다면,
	  	이제는 직접 클래스로 생성해서 클래스로 요청을 처리 해 보자는 것이다.
	 */


public class ServletBasic extends HttpServlet {

	
	// 서블릿 클래스를 만드는 방법
		 
	//#1. httpServlet 클래스를 상속. (임포트도필수~)
		  
	//#2. 생성자를 선언(필수가 아님. 선택임. 컨트롤+스페이스+엔터)
	
	
	
	public ServletBasic() {
		System.out.println("페이지에 요청이 들어왔다.");
		System.out.println("서블릿 객체가 생성되었다.(요청이 들어오면 자동으로 객체가 생성됨~)");
	}
	
	
	
	//#3. HttpServlet이 제공하는 상속 메서드를 목적에 맞게 오버라이딩(재정의) 하자
	//목적은 클라이언트가 어떠한 요청을 했을 때 서버는 어떠한 처리와 응답을 할 것인가?
	//init(), doGet, doPost(), service, destroy()....등등을 사용함
			
	
	
	@Override
	public void init() throws ServletException {   //init 치고 컨트롤 스페이스 치면 오버라이드 형태로 정의됨
		//이 메서드는 페이지 요청이 들어왔을 때, 처음 실행할 로직을 작성하는 부분이다.
		//init()은 컨테이너(서버프로그램)에 의해서 서블릿 객체가 생성될 때 최초 1회 자동으로 호출된다.
		//즉, 객체의 생성자와 비슷한 역할을 수행한다.
		System.out.println("init 메서드 호출!"); //객체가 생성되면 가장 먼저 호출이 된다!!!!!!!!!!!!!!!
	}
	
	
	
	
	
	@Override   //service가 HttpServletRequest의 req와 그옆의 resp를 받는다. 그러나 바꿀 수 있다. 편하게 리퀘스트, 레스폰스로 바꿔주자
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//페이지 요청이 들어왔을 때, 자동으로 호출된다. (init부터 호출되고 그 다음 service가 호출이 되는데,
		//get과 post 구분이 없이 들어오는 모든 요청과 응답을 관제할 수 있다.
		//매개값으로 요청, 응답 내장 객체가 전달 된다. (서버내에서 알아서 전달해준다) 그럼 이 메서드안에서 사용하면 된다.
		
		//요청방식(겟인지 포스트)인지 어떻게 확인?
		String method = request.getMethod();
		
		//요청 URI가 뭐니?
		String URI = request.getRequestURI();
		
		//요청 파라미터
		String queryString = request.getQueryString();
		
		//요청에 관련된 헤더 정보 일기
		String cc = request.getHeader("Cache-Control");
		
		//출력한번해보자
		System.out.println("----값 확인하기----");
		System.out.println("method : " + method);
		System.out.println("URI : " + URI);
		System.out.println("queryString : " + queryString);
		System.out.println("cc : " + cc);
		
		//클래스에다가 요청을 넣는 방식을 알아보자(JSP파일에서 JSP파일로 요청 보내는 법만 알지 다른 곳으로는 안배웠기 때문이다)
		//webapp에 servlet파일의 test_form.jsp로 가서 링크를 거는게 아니라 web.xml로 설정을 해줘야 한다.
		
		
		
		
		
		
		
		
		
		
		
		//응답 화면 제작
		//클래스에서 브라우저로 바로 응답을 구현하기 위해서
		//PrintWriter 객체를 사용한다.
		response.setContentType("text/html"); //내가 응답하고자하는 컨텐트의 타입은 text형식의 html파일을 응답할꺼야 라고 선언하자
		response.setCharacterEncoding("UTF-8");
		
		//자바IO패키지의 프린트라이터의 객체를 생성해주자
		PrintWriter w = response.getWriter(); 
		String htmlCode = "";
		htmlCode += "";
		htmlCode += "<!DOCTYPE html>\r\n"
                + "<html>\r\n"
                + "<head>\r\n"
                + "<meta charset=\"UTF-8\">\r\n"
                + "<title>Insert title here</title>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "\r\n"
                + "\t아이디: " + request.getParameter("account") + "\r\n"   //아이디가 브라우저에 응답이되도록
                + "\t이메일: " + request.getParameter("email") + "\r\n"     //이메일이 브라우저에 응답이되도록
                + "\r\n"
                + "</body>\r\n"
                + "</html>\r\n"
                + "";
		
		
		
		//이제 이 내용을 브라우저에 쏠 것이다.
		w.write(htmlCode); //버퍼라는 공간에 응답하고자 하는 데이터를 작성하기;
		w.flush(); //flush메서드는 버퍼를 비우면서 작성한 내용을 브라우저로 밀어내기
		w.close(); //객체 해제
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			  //겟 요청이 들어오면 자동으로 수행되는 메서드
			  //매개값으로 내장객체 리퀘스트와 리스폰스가 전달되므로
			  //객체의 메서드를 통해 파라미터값을 가져오거나 페이지 이동도 가능
		      System.out.println("doGet메서드가 호출되었다!");
		}
	
	
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 //포스트 요청이 들어오면 자동으로 수행되는 메서드
			 //두겟과 마찬가지로 내장객체 리퀘스트와 리스폰스를 매개값으로 받을 수 있다.
			 System.out.println("doPost메서드가 호출되었다!");
			 //만약 겟과 포스트를 구분해서 받고 싶으면 이렇게 위처럼 2줄로 적으면 된다.
			 //둘 중 아무거나 써도 되는거면 그냥 service방식으로 써도 된다.
		}
	
	
			 //그러나 지금은 service방식으로 했기 때문에 두겟과 두포스트 방식이 안먹는다.
		     //service를 주석처리하고 두겟과 두포스트가 자동으로 호출 되는지 확인해보자
			 //겟방식이 먹는다. 폼태그에 method="post"라는 포스트 방식을 적는다면 포스트방식이 먹는다.
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//그리고 destroy라는것이 있다.
		@Override
		public void destroy() {
			//서블릿 객체가 소멸이 될 때, 호출하는 메서드(객체 소멸 시 딱 1회 자동으로 호출)
			//대부분 객체 반납(close같은것들)이나 소멸 등에 사용한다. 없어도 그만이다.
			System.out.println("destroy메서드가 호출되었다!");
			//서블릿객체가 소멸되는건 서버가 내려간다던가 서블릿 객체의 주소값을 담고있는 변수에 널을 일부러 넣을 때 소멸을하겠지..
		}
		
		
		
		
		
		
		
		
		
}
