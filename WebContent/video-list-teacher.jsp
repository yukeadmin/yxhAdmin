<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp"%>
   <link rel="stylesheet" href="lib/pager.css"/>
   <link rel="stylesheet/less" href="video.less"/>
	<title>图片列表</title>
	<style>
    	.table>tbody>tr>td{
       	 	text-align:center;
		}
    </style>
</head>
<body>
	<div class="wap-container">
		<nav class="breadcrumb" style="background-color:#fff;padding: 0 24px">
			首页
			<span class="c-gray en">/</span>
			资料管理
			<span class="c-gray en">/</span>
			视频管理
			<span class="c-gray en">/</span>
			视频
			<a class="btn btn-success radius f-r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
		</nav>
		<article class="Hui-admin-content clearfix">
			<div class="panel mt-20">
				<div class="panel-body">
					<div class="mt-20 clearfix">
						<table id="driverTable" class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th></th>
									<th>视频名称</th>
									<th>课程名称</th>
									<th>教师名称</th>
									<th>视频简介</th>
									<th>操作</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</article>
	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog " role="document">
        <div class="modal-content yxh-model" >
            <div class="modal-header yxh-model-head" style="height:20px;line-height:20px;margin-top:-10px;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="padding-top:8px"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel" style="padding-bottom:10px">亚欣和在线</h4>
            </div>
            <div class="modal-body yxh-modal-body">
                <video src="" id="video1" controls="controls"></video>
            </div>

        </div>
    </div>
</div>
    <%@ include file="footer.jsp"%>  

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="lib/datatables/1.10.15/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="static/business/js/main.js"></script>
	<script type="text/javascript" src="yk.js"></script>
	<script type="text/javascript" src="less.js"></script>
 	<script src="lib/pager.js">  </script> 
    <script src="lib/bootbox.js" ></script> 
    <script type="text/javascript">
    function videoPlay(img,name){
    	$("#myModalLabel").html(name);
		$("#video1").attr("src",img);
		$('#myModal').modal('show');// 显示修改
    }
    //删除视频
    function statusVideo(id,state){
    	bootbox.confirm({
    		buttons : {
    			confirm : {
    				label : '确定',
    				className : 'btn-myStyle'
    			},
    			cancel : {
    				label : '取消',
    				className : 'btn-default'
    			}
    		},
    		message : '确定要执行本操作吗?',
    		callback : function(result) {
    			if (result) {
    				// 发送请求删除数据
    				$.ajax({
    					url : 'user/statusVideo.action',
    					type : 'POST', // GET
    					async : true, // 或false,是否异步
    					data : {id:id,state:state},
    					timeout : 5000, // 超时时间
    					dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    					success : function(data, textStatus, jqXHR) {
    						bootbox.alert({
    							buttons : {
    								ok : {
    									label : '确定',
    									className : 'btn-myStyle'
    								}
    							},
    							message : data.message,
    							title : "操作消息",
    						});
    						driverTable.api().ajax.reload();
    					},
    					error : function(xhr, textStatus) {
    						bootbox.alert({
    							buttons : {
    								ok : {
    									label : '确定',
    									className : 'btn-myStyle'
    								}
    							},
    							message : data.message,
    							title : "操作消息",
    						});
    						driverTable.api().ajax.reload();
    					}
    				});
    			}
    		},
    		title : "确认框",
    	});
    }
    </script>
    <c:if test="${addmsg!=null}">
	    <input type="hidden" id="addmsg" value="${addmsg}">
	    <script type="text/javascript">
		    bootbox.confirm({
				buttons : {
					confirm : {
						label : '确定',
						className : 'btn-myStyle'
					},
					cancel : {
						label : '取消',
						className : 'btn-default'
					}
				},
				message : $("#addmsg").val(),
				callback : function(result) {
					if (result) {
						// 发送请求删除数据
						$.ajax({
							url : 'user/clearSessionMsg.action',
							type : 'POST', // GET
							async : true, // 或false,是否异步
							success : function(data, textStatus, jqXHR) {
							}
						});
					}
				},
				title : "操作消息",
			});
	    </script>
	</c:if>
	<script type="text/javascript">
	var myVideo=document.getElementById("video1");
	$(".close").click(function () {
        myVideo.pause();
    })
	//为模态框添加监听事件
    var vol = 0.01;//每次减少
    var ct = 0.3;

    var video = document.getElementById("video1");
    document.onkeyup = function (event) {//键盘事件
        var e = event || window.event || arguments.callee.caller.arguments[0];
//    alert(e.keyCode)
//    alert(video.paused)
        if (e && e.keyCode == 38) { // 按 向上键
            if (video.volume == 1) return;
            video.volume += vol;
        }
        if (e && e.keyCode == 40) { // 按 向下键
            if (video.volume == 0) return;
            video.volume -= vol;
        }
        if (e && e.keyCode == 37) {
            if (video.currentTime == 0) return;
            video.currentTime = video.currentTime - ct;
        }
        if (e && e.keyCode == 39) {
            if (video.currentTime == video.duration) return;
            video.currentTime = video.currentTime + ct;
        }
        if (e && e.keyCode == "32") {
        	if (video.paused) {
       		  video.play();
            } else {
                video.pause();
            }
        }
        if (e && e.keyCode == "27") {
            video.pause();
        }

    };
	var driverTable;
		$(function(){
			driverTable=$('#driverTable').dataTable({
      	    	processing: true,//是否显示处理状态
      	    	paginationType:'simple_numbers',
      	        serverSide: false,//true代表后台处理分页，false代表前台处理分页 
      	        scrollX: true,//设置水平滚动
      	        ordering: false,//是否允许Datatables开启排序
      	        autoWidth: false,//控制Datatables是否自适应宽度
      	        bLengthChange: false,
      	      	iDisplayLength: 5,
      	        ajax:{
      	            url: 'user/getVideoListTeacher.action',
      	            type: 'POST'
      	        },
      	        language: {
      	          	"Processing":   "处理中...",
      	            "lengthMenu":   "显示 _MENU_ 项结果",
      	            "zeroRecords":  "没有匹配结果",
      	            "info":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
      	            "infoEmpty":    "显示第 0 至 0 项结果，共 0 项",
      	            "infoFiltered": "(由 _MAX_ 项结果过滤)",
      	            "infoPostFix":  "",
      	            "search":       "搜索:",
      	            "url":          "",
      	            "emptyTable":     "表中数据为空",
      	            "loadingRecords": "载入中...",
      	            "thousands":  ",",
      	            "paginate": {
      	                "first":    "首页",
      	                "previous": "上页",
      	                "next":     "下页",
      	                "last":     "末页"
      	            },
      	            "aria": {
      	                "sortAscending":  ": 以升序排列此列",
      	                "sortDescending": ": 以降序排列此列"
      	            }
      			},
      			"columns": [
      			            { "data": null,"targets": 0},
      			         	{ "data": "v_name",
      			            	"render" : function(data,type, row, meta) {
   						    		return "<span width='100'>"+data+"</span>";
     							}
      			            },
      			          	{ "data": "c_name",
      			            	"render" : function(data,type, row, meta) {
   						    		return "<span width='100'>"+data+"</span>";
     							}
      			            },
      			          	{ "data": "t_name",
      			            	"render" : function(data,type, row, meta) {
   						    		return "<span width='100'>"+data+"</span>";
     							}
      			            },
      						{ "data": "v_messag"}
      			        ],
      			  "columnDefs": [//设置列定义初始化属性
      			            {
      			            	"targets": [5],
      			            	"render" : function(data,type,row, meta) {
      			            		var str='<a title="播放" href="javascript:;" class="ml-5" onclick="videoPlay(\''+row.v_img+'\',\''+row.v_name+'\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e6;</i></a>';
      			            		str+='<a title="删除" href="javascript:;" class="ml-5" onclick="statusVideo(\''+row.v_num+'\',\'5\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe609;</i></a>';
    			            		if(row.v_type=='1'){
    			            			str+='<a title="下架" class="ml-5"  onclick="statusVideo(\''+row.v_num+'\',\'0\')" style="text-decoration:none">下架</a>';
    			            		}else{
    			            			str+='<a title="发布" class="ml-5"  onclick="statusVideo(\''+row.v_num+'\',\'1\')" style="text-decoration:none">发布</a>';
    			            		}
    			            		return str;
    			            		
    							}
      			            }
      			        ],
      			        //回掉函数，用来设置行号
      			        "fnDrawCallback": function(){
      			        	　　var api = this.api();
      			        	　　api.column(0).nodes().each(function(cell, i) {
      			        	　　　　cell.innerHTML =  i + 1;
      			        	　　}); 
      			        	}
      	    });
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
