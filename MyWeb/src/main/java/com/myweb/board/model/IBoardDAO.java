package com.myweb.board.model;

import java.util.List;

public interface IBoardDAO { //BoardDAO만들기전에 여기서 인터페이스 클래스 작성하자

	
	//글 등록 메서드(모든 게시판 등록은 이 regist로 사용하게끔 박아놈)
	void regist(String writer, String title, String content); 
	//이렇게 박아놓으면 나중에 게시판 종류가 늘어나던, 모든 게시판은 이 인터페이스를 구현하겠다 라고 얘기하면 등록메서드는 regist로 쓸 수 있다. 자유게시판도 공지사항도 건의사항게시판들도 regist로 가동될 것이다.
	//regist() 괄호 안에 돌리고자 하는 SQL을 생각해보자.
	//보내야하는 메서드는 writer, title, content만 전달하고자 한다면? String writer, String title, String content를 써주면 된다. 이러면 3가지로 SQL완성하면 된다.
	
	
	
	
	//등록했으면 글 전체 목록도 가지고 와야겠지
	//글 전체 목록을 가지고 오는 메서드. SELECT * FROM my_board를 돌릴꺼다.
	//리턴타입은 List로받아야겠지
	List<BoardVO>listBoard();  //boardVO객체 하나가 하나의 글이니, 그 안에 번호,작성자,작성일,조회수 등등이 있다. 그게 여러개란 소리다.
	
	
	
	
	//글 상세보기(글 하나 보기) 요청을 처리할 메서드
	BoardVO contentBoard(int bId); //SQL을 생각하면 매개변수가 어떻게 선언해야할지, 리턴타입을 뭘해야힐지 알 수 있다고 했다.
								   //contentBoard를 실행할떄 sql은 글 하나니까 where절이겠고, 글 번호(기본키)를 가져와야 겠지?(int bId). 리턴타입은 뭘까? 글번호지목해서 하나들고오는거니까 BoardVO다.

	
	
	
	//글 수정 요청을 처리할 메서드. (작성자는 수정안하고 제목만 내용만 수정할 것이다)
	void updateBoard(String title, String content, int bId); //제목과 내용만 수정할꺼니까 제목, 내용, 글번호 이다. 이걸 넘겨주겠지~
	//리턴타입은 업데이트 하고 뭘 받아야 할게 없으니 void. 
	
	
	
	
	
	//글 삭제 요청
	void deleteBoard(int bId); //where = 글번호? 니까 글번호가 매개값으로 오겠다.
	
	
	
	
	
	
	
}
