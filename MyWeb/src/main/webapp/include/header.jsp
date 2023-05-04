<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-idth, initial-scale=1">


<title>Welcome to MyWorld</title>

<!-- Bootstrap Core CSS -->
<link href="/MyWeb/css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/MyWeb/css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="/MyWeb/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/MyWeb/js/bootstrap.min.js"></script>

<!-- 위 내용들이 모든 페이지에 적용이 되게끔 만들 것이다. -->

</head>
<body>

	<!-- header -->
	<div class="brand">
		<a href="/MyWeb">My Web</a>
	</div>
	<div class="address-bar">Welcome to MyWorld</div>


	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/Test">My First Web</a>
			</div>


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li><a href="MyWeb">HOME</a></li> <%--MyWeb만 적어도 홈페이지로 갈 수 있다. WEB_INF에 lib의 web.xml에 적혀 있기 때문이다. --%>
					<li><a href="">Member</a></li>
					<li><a href="">BOARD</a></li>
					<li><a href="/MyWeb/loginPage.user">LOGIN</a></li>
					<li><a href="/MyWeb/joinPage.user" style="color: red">JOIN</a></li> <%--JSP가 JSP로 가는것은 MVC2패턴에 어긋남. 무조건 컨트롤러를 통해야함. 그래야 문제 발생 시 유지보수가 쉬움. 스프링도 그렇기 떄문에 작성법을 미리 익혀놓자 --%>
				</ul>
			</div>


			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- end header -->

	<!-- 위 내용들이 모든 페이지에 적용이 되게끔 만들 것이다. -->

</body>
</html>