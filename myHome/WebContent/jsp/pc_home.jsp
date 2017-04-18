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
<link rel="stylesheet" href="<%=basePath%>dropload-gh-pages/dist/dropload.css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>dropload-gh-pages/dist/dropload.min.js"></script>
<title>自主选机</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<img alt="cpu" src="http://localhost:8080/localimg/pc_cpu/Intel奔腾G2010_散装_232.jpg" id="cpu">
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
			<div class="col-md-3">
				<img alt="电源" src="http://localhost:8080/localimg/pc_dy/海韵S12II-520_667.jpg">
			</div>
			<div class="col-md-3">硬盘</div>
			<div class="col-md-3">固态硬盘</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">cpu列表</h4>
	                
	            </div>
	            <div class="modal-body" id="dropPage" >
	            	<div id="list_group" style="height: 400px;overflow-y: auto;"></div>
	            </div>
	            <div class="modal-footer">
	            	<div class="col-md-3">
	                	<select class="form-control" id="cpu_hxlx">
		                	<option>--核心类型--</option>
		                </select>
	                </div>
	                <div class="col-md-3">
	                	<select class="form-control" id="cpu_jklx">
		                	<option>--接口类型--</option>
		                </select>
	                </div>
	                <div class="col-md-3">
	                	<select class="form-control" id="cpu_zcnc">
		                	<option>--支持内存--</option>
		                </select>
	                </div>
	                <div class="col-md-3">
	                	<select class="form-control">
		                	<option>--品牌--</option>
		                </select>
	                </div>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#cpu").click(function(){
			cpuList();
		});
		$("#cpu").popover({
	        trigger : 'hover',//鼠标以上时触发弹出提示框
	        html:true,//开启html 为true的话，data-content里就能放html代码了
	        placement:'bottom',
	        content:'<ul class="list-group"><li class="list-group-item">Cras justo odio</li><li class="list-group-item">Dapibus ac facilisis in</li><li class="list-group-item">Morbi leo risus</li><li class="list-group-item">Porta ac consectetur ac</li><li class="list-group-item">Vestibulum at eros</li></ul>'
	    });

	});
	//cpu选择
	function cpuList(zbjk){
		$("#myModal").modal('show');
		dropLoad();
	}
	//点击查询cpu
	function cpuInit(){
		
	}
	//上拉更新数据
	function dropLoad(){
		// 页数
	    var page = 0;
	    // 每页展示5个
	    var size = 5;
	    // dropload
	    $('#dropPage').dropload({
	        scrollArea : window,
	        domDown : {
	            domClass   : 'dropload-down',
	            domRefresh : '<div class="dropload-refresh" >↑上拉加载更多</div>',
	            domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>',
	            domNoData  : '<div class="dropload-noData" style="display:none">加载完成</div>'
	        },
	        loadDownFn : function(me){
	            page++;
	            // 拼接HTML
	            var result = '';
	            $.ajax({
	                type: 'GET',
	                url: '<%=basePath%>cpu/query.do',
	                data:{
	                	page:page,
	                	size:size
	                },
	                dataType: 'json',
	                success: function(data){
	                    var arr = data.result;
	                    if(arr.length > 0){
	                        for(var i=0; i<arr.length; i++){
	                            result += ' <li class="list-group-item" onclick="cpu_select('+arr[i].xxzjbh+')">'+arr[i].title+'</li>';
	                        }
	                    // 如果没有数据
	                    }else{
	                        // 锁定
	                        me.lock();
	                        // 无数据
	                        me.noData();
	                    }
	                    // 插入数据到页面，放到最后面
	                    $('#list_group').append(result);
	                    // 每次数据插入，必须重置
	                    me.resetload();
	                    $('.dropload-down').hide();
	                },
	                error: function(xhr, type){
	                    alert('Ajax error!');
	                    // 即使加载出错，也得重置
	                    //me.resetload();
	                }
	            });
	        }
	    });
	}
</script>
</html>