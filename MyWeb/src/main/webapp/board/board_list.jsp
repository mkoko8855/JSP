<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tbody{
		font-size: 20px;
	}
	
	.btn-countPerPage {
		background-color: gray;
		color: white;
	}
	
	
</style>

</head>
<body>

	
	<%-- <c:if test="${user == null}">
		<script>
			alert('회원만 이용 가능한 게시판 입니다. 로그인 해 주세요.');
			location.href="/MyWeb/loginPage.user";
		</script>
	</c:if> --%>   					<%--이건이제 Filter가 해주니까 필요없다. --%>
	
	
	

	<jsp:include page="../include/header.jsp"/>

	<div class="container">
		<h2>My Web게시판</h2>
		
		
		<span style="float: right; margin-bottom: 15px">
			<input class="btn btn-countPerPage" type="button" value="10" onclick="location.href='/MyWeb/list.board?page=1&cpp=10'">
			<input class="btn btn-countPerPage" type="button" value="20" onclick="location.href='/MyWeb/list.board?page=1&cpp=20'">
			<input class="btn btn-countPerPage" type="button" value="30" onclick="location.href='/MyWeb/list.board?page=1&cpp=30'">
		</span>
		
		
		<table class="table table-secondary table-hover table-bordered">
			<thead style="font-size: 25px">
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>


			
			<tbody>
				<!-- tr과 td를 통해 값을 뿌리자 -->
				<c:forEach var="b" items="${boardList}"> <!-- 비긴앤드스텝이 아님. list돌릴꺼니 배열이나 컬렉션을 돌리고 싶을땐 items다. -->
					<tr> <!-- 하나씩 b라는 변수로 전달해서 보드객체들을 꺼내자 -->
						<td>${b.boardId}</td> <!-- td는 위에있는 th만큼. -->
						<td>${b.writer}</td> 
						<td><a href="/MyWeb/content.board?bId=${b.boardId}&page=${pc.paging.page}&cpp=${pc.paging.cpp}">${b.title}</a></td>
						<td>
							<fmt:parseDate value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
							<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분" />
						</td> 
						<td>${b.hit}</td> 
						<!-- 이것들을 List의 개수만큼 반복할 것이다. 그래서 포이치문 사용. -->
					</tr>
				</c:forEach>
			</tbody>
			
			
			
			
			
			
			<%-- 페이징을 처리할 구간 --%>
			<tbody>
				<tr>
					<td colspan="5" align="center">
						<ul class="pagination pagination-lg">
						
						
						<%-- 이전 버튼 --%>
						
                     <%--이전버튼이 나올수도있고 안나올수도있다. 다음 버튼도 마찬가지다. 이프문으로물어보자 --%>
                     
                     <c:if test="${pc.prev}">  <!-- pc로 담았으니 prev가 트루냐? 보여줘. false면 보여주지마~ -->
                     
	                        <li class="page-item"><a class="page-link"
	                           href="/MyWeb/list.board?page=${pc.beginPage-1}&cpp=${pc.paging.cpp}" <%--사용자가 이전버튼을 누르면, 현재 위치하고 있는 시작페이지보다 하나 작은 페이지로 이동하자 26페이지에있다면, 21~30그룹이니까 시작페이지는 21. 하나 작으니 20페이지로 넘어가게끔. cpp--%>
	                           style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
	                        </li>
	                        
                     </c:if>

                    	<%-- 페이지 버튼(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 그 번호를 의미). 반복문돌려야겠지? 일단포문인지 포이치 쓸건지 판단하자. 지금은 리스트나 배열이 아니니까 시작과 끝이 명확한 일반포문돌리자. 스텝은딱히필요없다. 하나씩올릴꺼니...--%>
   						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}"> <%--pageNum은 임의로 지어준 변수명 --%>
	                        <li class="page-item">
	                        <a href="/MyWeb/list.board?page=${pageNum}&cpp=${pc.paging.cpp}" class="page-link"
	                           style="margin-top: 0; height: 40px; color: pink; border: 1px solid #643691; ${pageNum == pc.paging.page ? 'background-color: orange' : ''}">${pageNum}</a> <%--조건문으로 사용자가 보고 있는 버튼을 눈에 띄게 칠해보자. 어느 페이지로 이동한지 모르니까. 트루면 오렌지색. 아니면 비운다는 뜻이다~ --%>
	                        </li>
               			</c:forEach>
               			
                     	<%-- 다음 버튼 --%>
    					<c:if test="${pc.next}"> <%--next가 트루면 보여주고 폴스면 보여주지마~ --%>
	                        <li class="page-item"><a class="page-link"
	                           href="/MyWeb/list.board?page=${pc.endPage+1}&cpp=${pc.paging.cpp}"
	                           style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
	                        </li>
						</c:if>
						</ul>
					</td>
				</tr>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="5" align="right">
						<form action="/MyWeb/search.board" class="form-inline" >
						  <div class="form-group">
						  
						  	<select name="category" class="form-control">
						  		<option value="title">제목</option>
						  		<option value="writer">작성자</option>
						  		<option value="content">내용</option>
						  	</select>
						  	
						    <input type="text" name="search" placeholder="검색어 입력" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='/MyWeb/write.board'">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>

	<jsp:include page="../include/footer.jsp"/>

</body>
</html>







