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
<script type="text/javascript"
	src="<%=basePath%>jquery-session/jquery.session.js"></script>
<title>CPU</title>
<style type="text/css">
 	.top{margin-top: 10px}
</style>
</head>
<body>
	<h2 class="bg-primary">
		主板
	</h2>
	<div class="container">
		<div class="row">
			<div class="col-sm-10 top">
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-search"></span>
					</div>
					<input type="text" class="form-control" id="query_name"
						placeholder="请输入主板名字">
					<div class="input-group-addon" onclick="query()">开始查找</div>
				</div>
			</div>
			<div class="col-sm-2 top">
				<button class="btn btn-block btn-primary" onclick="shaixuan()">条件筛选</button>
			</div>
		</div>
		<div style="height: 400px;overflow-y: auto;overflow-x: hidden;">
			<div class="row" id="pageList">

			</div>
		</div>
		<div class="row ">
			<div class="col-sm-12 text-right top">
				<button class="btn btn-success btn-block" onclick="go()"><h5>点击选择主板<span class="glyphicon glyphicon-chevron-right"></span></h5></button>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
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
								<span>主板结构</span>
							</div>
							<select class="form-control" id="zb_zbjg">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span>芯片型号</span>
							</div>
							<select class="form-control" id="zb_xpxh">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span>CPU插槽类型</span>
							</div>
							<select class="form-control" id="zb_cpucclx">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
					<div class="form-group" >
						<div class="input-group">
							<div class="input-group-addon">
								<span>芯片厂商</span>
							</div>
							<select class="form-control" id="zb_xpcs">
								<option>我不清楚</option>
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</body>
<script type="text/javascript">
	function shaixuan() {
		$("#myModal").modal('show');
	}
	$(function(){
		init();
	});
	//初始化
	function init(){
		//品牌
		$.ajax({
			type:"GET",
			url:"<%=basePath%>cpu/queryInit.do",
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
	}
	//查找cpu
	function query(){
		var name=$("#query_name").val();
		var hxlx=$("#cpu_hxlx").val();
		var pp=$("#cpu_pp").val();
		var jklx=$("#cpu_jklx").val();
		var zcnc=$("#cpu_zcnc").val();
		$.ajax({
			type:"Post",
			url:"<%=basePath%>cpu/searchCpu.do",
			data : {
				name:name,
				hxlx:hxlx,
				pp:pp,
				jklx:jklx,
				zcnc:zcnc
			},
			dataType : "json",
			success : function(data) {
				var result=data.result;
				//alert(JSON.stringify(result));
				if(result.length>0){
					var list=$("#pageList");
					var res="";
					for(var i=0;i<result.length;i++){
						res+='<div class="col-sm-12">';
						res+='<div class="col-sm-4">';
						res+='<img alt="" src="http://192.168.1.107:80/pc_cpu/'+result[i].localPic+'" style="height:100px">';
						res+='</div>';
						res+='<div class="col-sm-4">';
						res+='<div class="col-sm-12">';
						res+='<h4><span class="label label-primary">'+result[i].title+'</span>&nbsp;<span class="label label-success">'+result[i].xpcf+'</span>&nbsp;<span class="label label-info">'+result[i].hxsl+'</span>&nbsp;<span class="label label-warning">'+result[i].zp+'</span></h4>';
						res+='</div>';
						res+='<div class="col-sm-12">';
						res+='<h4><span class="label label-default">'+result[i].gzgl+'</span>&nbsp;<span class="label label-danger">'+result[i].price+'</span></h4>';
						res+='<div class="radio">';
						res+='<label>';
						res+='<input type="radio" name="cpu_radio" value="'+result[i].xxzjbh+'&'+result[i].jklx+'&'+result[i].price+'&'+result[i].gzgl+'" >';
						res+='<strong>就选它了</strong>';
						res+='</div>';
						res+='</div>';
						res+='</div>';
						res+='</div>';
						res+='<hr/>';
					}
					list.html(res);
				}			
			},
			error : function() {
				alert("查询cpu列表失败!");
			}
		});	
	}
	//进入选择主板页面
	function go(){
		var str=$("input[type='radio']:checked").val();
		var arr=str.split("&");
		$.session.set("cpu_xxzjbh",arr[0]);
		$.session.set("cpu_jklx",arr[1]);
		$.session.set("cpu_price",arr[2]);
		$.session.set("cpu_gzgl",arr[4]);
		window.location="<%=basePath%>jsp/zbList.jsp";
	}
</script>
</html>s