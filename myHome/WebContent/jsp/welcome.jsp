<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=basePath%>dropload-gh-pages/dist/dropload.css">
<script type="text/javascript"
	src="<%=basePath%>jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>dropload-gh-pages/dist/dropload.min.js"></script>
<title>装机世界</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>欢迎登陆页面！</h1>
			<p>这是一个超大屏幕（Jumbotron）的实例。</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button"
					onclick="jump()">开始选机之旅</a>
			</p>

		</div>
	</div>
	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner text-center">
			<div class="item active" id="page1">
				<img class="center-block"
					src="http://192.168.1.107:80/pc_cpu/Intel奔腾G2010_散装_232.jpg"
					alt="First slide">
				<div class="carousel-caption">标题 1</div>
			</div>
			<div class="item" id="page2">
				<img class="center-block"
					src="http://192.168.1.107:80/pc_cpu/Intel奔腾G2010_散装_232.jpg"
					alt="Second slide">
				<div class="carousel-caption">标题 2</div>
			</div>
			<div class="item" id="page3">
				<img class="center-block"
					src="http://192.168.1.107:80/pc_cpu/Intel奔腾G2010_散装_232.jpg"
					alt="Third slide">
				<div class="carousel-caption">标题 3</div>
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
</body>
<script type="text/javascript">
	function jump() {
		window.location="<%=basePath%>jsp/cpuList.jsp";
	}
</script>
</html>