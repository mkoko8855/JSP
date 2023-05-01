<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


			<!-- 
			
			여기는 radio버튼으로 하는게 아닌, 노래제목으로 요청을 넣어보자 
			
			페이지 이동시키는 a태그를 통해 노래제목을 클릭하면 페이지를 넘기는 방식으로..
				 
			즉, 제목에다가 a태그를 감싸서 클릭할 수 있는 링크로 만들어 주자
				 
				 
			즉, 결과론적으로는 Get방식은 폼 태그가 무조건으로 필요하지 않다. 그래서 a태그 방식이 가능.
			그러나 Post는 a태그형식은 X, 폼태그가 무조건 필요하다.
			 -->

	
	<style>
		table {
			width: 800px;
		}
		
		tr {
			text-align: center;
		}
	</style>

</head>
<body>

	<div align="center">
			<table border="1">
			
				<tr>
					<th>앨범 커버</th>
					<th>가수</th>
					<th>제목</th>
					<th>발매일</th>
				</tr>
				
				
				<tr>
					<td>
						<img alt="pic1" src="njhn.jpg" width="100px" height="100px">
					</td>
					<td>뉴진스</td>
					<td>
					<a href="req_album_result.jsp?title=sel1">하입보이</a> <!-- 즉, 뭐를 클릭했는지 구분을 위해서는, ?를 붙이고 title=sel1이면됨..이게 게시판방식이야.. -->
					</td>
					<td>2023.04.10</td>
				</tr>
				
				
				<tr>
					<td>
						<img alt="pic1" src="ntgg.jpg" width="100px" height="100px">
					</td>
					<td>뉴진스</td>
					<td>
					<a href="req_album_result.jsp?title=sel2">디토</a> <!-- 즉, 뭐를 클릭했는지 구분을 위해서는, ?를 붙이고 title=sel1이면됨..이게 게시판방식이야.. -->
					</td>
					<td>2023.04.10</td>
				</tr>
				
			</table>
	</div>
</body>
</html>
	
	
	
	
	
	
	








</body>
</html>