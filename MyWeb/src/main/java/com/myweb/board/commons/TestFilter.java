package com.myweb.board.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*@WebFilter("/*") //어떠한 메뉴를 누르던 다 동작해라 라고 선언했다. 뭘 하던 실행될 것이다.
*/public class TestFilter implements Filter { //TestFilter라는 클래스를 제작 후, 임포트 했다. 그럼 클래스명에 줄 다시 그이는데, 오버라이드 까지 자동생성해줬다.

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터 동작!");
	
		chain.doFilter(request,  response);
	}
	
	
	
}
