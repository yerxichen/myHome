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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.min.js"></script>
<title>自主选机</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<img alt="cpu" src="http://img.pconline.com.cn/images/product/6317/631793/i57500_45_sn8.jpg" id="cpu">
			</div>
			<div class="col-md-3">
				<img alt="内存条" src="http://img.pconline.com.cn/images/product/6318/631888/JSDDDR424008G_Z_sn8.jpg" id="nc">
			</div>
			<div class="col-md-3">
				<img alt="主板" src="" id="zb">
				<input type="text" value="" style="display: none" id="zhjk"/>
				<input type="text" value="" style="display: none" id="zcnc"/>
				<input type="text" value="" style="display: none" id="zcgg"/>
			</div>
			<div class="col-md-3">cpu风扇</div>
		</div>
		<div class="row">
			<div class="col-md-3">显示器</div>
			<div class="col-md-3">
				<img alt="" src="">
			</div>
			<div class="col-md-3">
				<img alt="" src="">
			</div>
			<div class="col-md-3">机箱</div>
		</div>
		<div class="row">
			<div class="col-md-3">显卡</div>
			<div class="col-md-3">电源</div>
			<div class="col-md-3">硬盘</div>
			<div class="col-md-3">固态硬盘</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#cpu").click(function(){
			cpuList(zbjk);
		});
	});
	//cpu选择
	function cpuList(zbjk){
		$()
	}
</script>
</html>