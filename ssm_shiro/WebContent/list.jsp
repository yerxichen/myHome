<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome<shiro:principal></shiro:principal>
	<h4>list page</h4>
	<a href="user.jsp">go user</a>
	<a href="admin.jsp">go admin</a>
	<a href="shiro/logout">logout</a>
	
	<shiro:hasRole name="admin">
		<h5>只有admin 才能看到我</h5>
	</shiro:hasRole>
	<shiro:hasRole name="user">
		<h5>拥有user权限就能看到我</h5>
	</shiro:hasRole>
	<shiro:hasRole name="guest">
		<h5>拥有guest权限就能看到我</h5>
	</shiro:hasRole>
	
	<shiro:hasPermission name="read">
		<h5>我能查询</h5>
	</shiro:hasPermission>
	<shiro:hasPermission name="delete">
		<h5>我能删除</h5>
	</shiro:hasPermission>
	<shiro:hasPermission name="update">
		<h5>我能修改</h5>
	</shiro:hasPermission>
	<shiro:hasPermission name="write">
		<h5>我能增加</h5>
	</shiro:hasPermission>
</body>
</html>