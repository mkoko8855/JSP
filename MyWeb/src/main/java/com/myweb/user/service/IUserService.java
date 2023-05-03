package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스로 클래스를 만들었다.
//모든 서비스 객체가 하나의 인터페이스 타입으로 객체를 생성할 수 있게,
//같은 이름의 메서드로 동작 할 수 있게끔 인터페이스를 제작
public interface IUserService {

	//추상메서드 선언해보자. 리턴타입이 void인 이유는 리턴할게 없으니까. 화면에 데이터 전달할때는 내장객체를 사용할 것이기 때문이다.
	//실행한다 라는 의미에서 execute로 지었다~ 서비스는 컨트롤러는 요청이 들어오면 
	//리퀘스트내장객체와 리스폰스내장객체를 받으니 서비스가 일할수 있게 넘겨줄 것이다. 
	//그래서 execute메서드의 매개변수는 리퀘스트와 리스폰스가 되겠다.
	void execute(HttpServletRequest request, HttpServletResponse response); 
	
	
	
	
	
	
	
	
}
