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
<link rel="stylesheet"
	href="<%=basePath%>dropload-gh-pages/dist/dropload.css">
<script type="text/javascript"
	src="<%=basePath%>jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>dropload-gh-pages/dist/dropload.min.js"></script>
<title>CPU</title>
</head>
<body>
	<div class="page-header">
		<h1>
			CPU<small>中央处理器</small>
		</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-search"></span>
					</div>
					<input type="text" class="form-control" id="exampleInputAmount"
						placeholder="请输入CPU名字">
					<div class="input-group-addon" onclick="queryCpuName()">开始查找</div>
				</div>
			</div>
			<div class="col-sm-2">
				<button class="btn btn-block btn-primary" onclick="shaixuan()">条件筛选</button>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="cpuModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">cpu列表</h4>

				</div>
				<div class="modal-body" id="dropPage">

					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span>核心类型</span>
							</div>
							<select class="form-control" id="cpu_hxlx">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span>接口类型</span>
							</div>
							<select class="form-control" id="cpu_jklx">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span>支持内存</span>
							</div>
							<select class="form-control" id="cpu_zcnc">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
					<div class="form-group" >
						<div class="input-group">
							<div class="input-group-addon">
								<span>品牌厂方</span>
							</div>
							<select class="form-control" id="cpu_pp">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</body>
<script type="text/javascript">
	function shaixuan() {
		$("#cpuModal").modal('show');
	}
	$(function(){
		init();
	});
	//初始化
	function init(){
		//品牌
		$.ajax({
			type:"GET",
			url:"<%=basePath%>cpu/queryPp.do",
			data : {},
			dataType : "json",
			success : function(data) {
				var cpuPp = data.cpuPp;
				var cpuHxlx = data.cpuHxlx;
				var cpuJklx = data.cpuJklx;
				var cpuZcnc = data.cpuZcnc;
				for (var i = 0; i < cpuPp.length; i++) {
					$("#cpu_pp").append("<option>" + cpuPp[i].xpcf + "</option>");
				}
				for (var i = 0; i < cpuHxlx.length; i++) {
					$("#cpu_hxlx").append("<option>" + cpuHxlx[i].hxlx + "</option>");
				}
				for (var i = 0; i < cpuJklx.length; i++) {
					$("#cpu_jklx").append("<option>" + cpuJklx[i].jklx + "</option>");
				}
				for (var i = 0; i < cpuZcnc.length; i++) {
					$("#cpu_zcnc").append("<option>" + cpuZcnc[i].zcncpl + "</option>");
				}
			},
			error : function() {
				alert("ajaxError!");
			}
		});
		//核心类型
	}
</script>
</html>