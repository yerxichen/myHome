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
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath %>jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
	Hello Word!
	<br>
	<a href="<%=basePath%>jsp/pc_home.jsp">点击这里，获取更新数据!</a>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		window.location="<%=basePath%>jsp/welcome.jsp";
	});
		
</script>
</html>