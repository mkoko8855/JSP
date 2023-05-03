<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%-- 여디에 간단한 링크들을 만들 것이다.  게시판 메뉴라고 생각해보자 --%>
	
	<h2>서블릿 클래스에서 각각 다른 요청 구분하기!</h2>
	
	<a href="/JspBasic/write.board">글 작성 요청</a>
	<a href="/JspBasic/list.board">글 목록 요청</a>
	<a href="/JspBasic/update.board">글 수정 요청</a>
	<a href="/JspBasic/delete.board">글 삭제 요청</a>
	<%--a href는 적지않은 상태에서, 이제 ko.co.jsp.servlet에 새로운 클래스만들자  --%>
	
	

</body>
</html> 