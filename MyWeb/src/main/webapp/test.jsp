<%@page import="com.myweb.board.commons.PageVO"%>
<%@page import="com.myweb.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<%--
		for(int i=1; i<=300; i++){
			String writer = "김테스트" + i;
			String title = "테스트 입니다." + i;
			String content = "테스트 중이니까 조용히 하세요!" + i;
			BoardDAO.getInstance().regist(writer, title, content);
		}
	--%>






	<%
		int countArticles = BoardDAO.getInstance().countArticles();
		out.print("# 총 게시물 수: " + countArticles + "개 <br>");  //난 306개나옴
		out.print("------------------------------------<br>");
		
		
		
		//총 게시물 수 알았으니 끝 페이지 번호를 계산해보자
		//사용자가 현재 머물러있는 페이지 번호와 한 화면의 게시글 번호를 알아야 끝 페이지를 적용할 수 있지!
		//우린 지금 총 게시물 수 밖에 모른다
		//PageVO클래스 만들어주고 다시 왔다.
		
		
		//끝 페이지 번호 계산 테스트
		PageVO paging = new PageVO();
		paging.setPage(12);  //사용자가 선택한 페이지의 번호
		paging.setCpp(20);   //한 화면의 게시글
		int displayBtn = 6; //화면에보여지는 버튼 수
		
		
		//끝 페이지 공식  >  Math.ceil(현재 위치한 페이지 번호 / 한 화면에 보여줄 페이지 버튼 수) * 한 화면에 보여줄 페이지 버튼 수.
		int endPage = (int) Math.ceil(paging.getPage() / (double) displayBtn) * displayBtn;  //둘중의 하나의 타입을 더블로. 근데 또 빨간불 들어오니, Math.ceil 리턴값은 더블이다. 우리는 int변수를 맨 앞에 선언했다. 그래서 Math 앞에 int도 형변환을 한번 더 해주자
		out.print("끝 페이지 번호: " + endPage + "번 <br>");
		
	
		//시작 페이지 번호 계산 테스트 > (끝 페이지 번호 - 한 화면에 보여줄 페이지 버튼 수) + 1
		int beginPage = (endPage - displayBtn) + 1;
		out.print("시작 페이지 번호: " + beginPage + "번 <br>");
	
		
		
		//끝과 시작을 구했으니 이전 버튼을 활성, 비활성 여부 (시작페이지가 1이면 비활성, 나머지는 전부 활성이었다.)
		//boolean타입으로 선언하면 트루일땐 보여주고 폴스일떈 안보여주면 된다.
		boolean isPrev = (beginPage == 1) ? false : true; //if문쓰기 귀찮으니 삼항연산가능.
		out.print("이전 버튼 활성화 여부: " + isPrev + "<br>");
		
		//다음 버튼을 활성, 비활성 여부
		//공식: 보정 전 끝 페이지 번호 * 한 페이지에 들어갈 게시물 수가 만약 총 게시물 수보다 같거나 크다면(많다면) 비활성. 총게시물수가 더 많으면 다음 버튼은 계속 나와야 한다.
		boolean isNext = (countArticles <= (endPage * paging.getCpp())) ? false : true;
		out.print("다음 버튼 활성화 여부: " + isNext + "<br>");

		
		
		//끝 페이지 보정 >  다음 버튼이 비활성화 일떄만 들어간다했다.
		if(!isNext){ //isNext가 폴스니까 true가 되게끔.  즉, isNext == false
			endPage = (int)Math.ceil(countArticles / (double) paging.getCpp());
		}
		out.print("보정 후 끝 페이지 번호: " + endPage + "번");
		
		
		
		
	
	%>







</body>
</html>