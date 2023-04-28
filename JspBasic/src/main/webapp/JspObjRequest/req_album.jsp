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
	 <table
      border="1"
      width="50%"
      height="200"
      cellspacing="5">
	
	<div align="center">
		<td></td>
		<th> 앨컴 커버 </th>
		<th> 가수 </th>
		<th> 앨범 제목 </th>
		<th> 발매일 </th>
	</div>
	
	<tr>
		<th>
		<form action='req_album_result.jsp'>
		 <input type="radio" name="title" value="sel1" ><br>
		</form>
		</th>
		
		<td> <img src="ntgg.jpg" width="250" height="150"> </td>
		<td> NewJeans </td>
		<td> Ditto </td>
		<td> 2022.08.08 </td>
	</tr>
	<tr>
		<th>
		<form action='req_album_result.jsp'>
		<input type="radio" name="title" value="sel2" ><br>
		</form>
		</th>
		
		<td> <img src="njhn.jpg" width="300" height="200"> </td>
		<td> NewJeans-picture </td>
		<td> HypeBoy </td>
		<td> 2022.08.08 </td>
	</tr>
	
	<tr>
		<td colspan="5">
			<input type="submit" value="확인">
		</td>
	</tr>
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
		<form action="req_album_result.jsp">
			<table border="1">
				<tr>
					<th></th>
					<th>앨범 커버</th>
					<th>가수</th>
					<th>제목</th>
					<th>발매일</th>
				</tr>
				<tr>
					<td>
						<input type="radio" name="title" value="sel1">
					</td>
					<td>
						<img alt="pic1" src="njhn.jpg" width="100px" height="100px">
					</td>
					<td>뉴진스</td>
					<td>하입보이</td>
					<td>2023.04.10</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="title" value="sel2">
					</td>
					<td>
						<img alt="pic1" src="ntgg.jpg" width="100px" height="100px">
					</td>
					<td>뉴진스</td>
					<td>디토</td>
					<td>2023.04.10</td>
				</tr>
				<tr>
					<td colspan="5">
						<input type="submit" value="확인">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
	
	
	
	
	
	
	








</body>
</html>