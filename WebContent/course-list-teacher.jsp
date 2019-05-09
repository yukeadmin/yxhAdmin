<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp"%>
   <link rel="stylesheet" href="lib/pager.css"/>
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
			课程管理
			<span class="c-gray en">/</span>
			课程列表
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
									<th>课程名称</th>
									<th>分类</th>
									<th>教师名称</th>
									<th>封面</th>
									<th>原价</th>
									<th>现价</th>
									<th>发布状态</th>
									<th>操作</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</article>
	</div>
    <div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
    		<div class="modal-content radius">
    			<div class="modal-header" style="height:30px;line-height:30px">
    				<h3 class="modal-title">课程信息修改</h3>
    				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
    			</div>
    			<div class="modal-body">
    				<jsp:include page="courseform.jsp"></jsp:include>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="modal-demo2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
    		<div class="modal-content radius">
    			<div class="modal-header" style="height:30px;line-height:30px">
    				<h3 class="modal-title">课程封面修改</h3>
    				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
    			</div>
    			<div class="modal-body">
    				<jsp:include page="addfile.jsp"></jsp:include>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="modal-demo3" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
    		<div class="modal-content radius">
    			<div class="modal-header" style="height:30px;line-height:30px">
    				<h3 class="modal-title">课程视频上传</h3>
    				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
    			</div>
    			<div class="modal-body">
    				<jsp:include page="addVideo.jsp"></jsp:include>
    			</div>
    		</div>
    	</div>
    </div>
     <div id="modal-demo4" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
    		<div class="modal-content radius">
    			<div class="modal-header" style="height:30px;line-height:30px">
    				<h3 class="modal-title">课程视频上传</h3>
    				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
    			</div>
    			<div class="modal-body">
    				<jsp:include page="addBook.jsp"></jsp:include>
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
 	<script src="lib/pager.js">  </script> 
    <script src="lib/bootbox.js" ></script> 
    <script type="text/javascript">
    //删除视频
    function statusCourse(id,state){
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
    					url : 'user/statusCourse.action',
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
    /* 编辑课程信息*/	
    function editCourse(id) {
    	$.ajax({
    		url : 'user/getCourseById.action',
    		type : 'POST', // GET
    		async : true, // 或false,是否异步
    		data : {id:id},
    		timeout : 5000, // 超时时间
    		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    		success : function(data, textStatus, jqXHR) {
    			$("#form-course-update").attr("action", "user/courseUpdate.action");
    			$("#coursename").val(data.c_name);//
    			$("#courseind").val(data.c_ind);//
    			$("#coursestate").val(data.c_state);
    			$("#courseopri").val(data.c_opri);
    			$("#coursenpri").val(data.c_npri);
    			$("#courseplan").val(data.c_plan);
    			$('#modal-demo').modal('show');// 显示修改
    		},
    		error : function(XMLHttpRequest,xhr, textStatus) {
    			alert(XMLHttpRequest.status);
    			alert(XMLHttpRequest.readyState);
    			alert(textStatus);
    		}
    	});
    }
    /* 编辑课程封面*/	
    function editCourseImg(id) {
    	$.ajax({
    		url : 'user/getCourseById.action',
    		type : 'POST', // GET
    		async : true, // 或false,是否异步
    		data : {id:id},
    		timeout : 5000, // 超时时间
    		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    		success : function(data, textStatus, jqXHR) {
    			//$("#form-course-update").attr("action", "user/editCourseImg.action");
    			$('#modal-demo2').modal('show');// 显示修改
    		},
    		error : function(XMLHttpRequest,xhr, textStatus) {
    			alert(XMLHttpRequest.status);
    			alert(XMLHttpRequest.readyState);
    			alert(textStatus);
    		}
    	});
    }
    /* 添加课程视频*/	
    function addCourseVideo(id) {
    	$.ajax({
    		url : 'user/getCourseById.action',
    		type : 'POST', // GET
    		async : true, // 或false,是否异步
    		data : {id:id},
    		timeout : 5000, // 超时时间
    		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    		success : function(data, textStatus, jqXHR) {
    			//$("#form-course-update").attr("action", "user/addCourseVideo.action");
    			$('#modal-demo3').modal('show');// 显示修改
    		},
    		error : function(XMLHttpRequest,xhr, textStatus) {
    			alert(XMLHttpRequest.status);
    			alert(XMLHttpRequest.readyState);
    			alert(textStatus);
    		}
    	});
    }
    /* 添加课程书籍*/	
    function addCourseBook(id) {
    	$.ajax({
    		url : 'user/getCourseById.action',
    		type : 'POST', // GET
    		async : true, // 或false,是否异步
    		data : {id:id},
    		timeout : 5000, // 超时时间
    		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    		success : function(data, textStatus, jqXHR) {
    			//$("#form-course-update").attr("action", "user/addCourseVideo.action");
    			$('#modal-demo4').modal('show');// 显示修改
    		},
    		error : function(XMLHttpRequest,xhr, textStatus) {
    			alert(XMLHttpRequest.status);
    			alert(XMLHttpRequest.readyState);
    			alert(textStatus);
    		}
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
      	            url: 'user/getAllCourseTeacher.action',
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
      			         	{ "data": "c_name",
      			            	"render" : function(data,type, row, meta) {
   						    		return "<span width='100'>"+data+"</span>";
     							}
      			            },
      			            { "data": "c_state",
      			            	"render" : function(data,type, row, meta) {
     						    	if(data=='1'){
   						    		   return "<span>WEB前端</span>";
   						    	   }else if(data=='2'){
   						    		   return "<span>Java基础</span>";
   						    	   }else if(data=='3'){
   						    		   return "<span>大数据</span>";
   						    	   }
     							}
      			         	},
      						{ "data": "t_name"},
      						{ "data": "c_img",
      							"render" : function(data,type, row, meta) {
      								 return "<img width='100' class='picture-thumb' src="+data+">";
      							}
     						},
      						{ "data": "c_opri",
     							"render" : function(data,type, row, meta) {
     								return '<span>￥'+data+'</span>';
     							}
      						},
      						{ "data": "c_npri" ,
      							"render" : function(data,type, row, meta) {
      								return '<span>￥'+data+'</span>';
 								}
      						},
      						{ "data": "state",
      						       "render" : function(data,type, row, meta) {
      						    	 if(data=='1'){
    						    		   return "<span class='label label-success radius'>已发布</span>";
    						    	   }else{
    						    		   return "<span class='label label-default radius'>已下架</span>";
    						    	   }
      								}
      						}
      			        ],
      			  "columnDefs": [//设置列定义初始化属性
      			            {
      			            	"targets": [8],
      			            	"render" : function(data,type,row, meta) {
      			            		var str='<a title="编辑" href="javascript:;" class="ml-5" onclick="editCourse(\''+row.c_num+'\')"  style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
      			            		str+='<a title="修改封面" href="javascript:;" class="ml-5" onclick="editCourseImg(\''+row.c_num+'\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe646;</i></a>';
      			            		str+='<a title="上传视频" href="javascript:;" class="ml-5" onclick="addCourseVideo(\''+row.c_num+'\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe600;</i></a>';
      			            		str+='<a title="上传书籍" href="javascript:;" class="ml-5" onclick="addCourseBook(\''+row.c_num+'\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe642;</i></a>';
      			            		str+='<a title="删除" href="javascript:;" class="ml-5" onclick="statusCourse(\''+row.c_num+'\',\'5\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe609;</i></a>';
    			            		if(row.state=='1'){
    			            			str+='<a title="下架" class="ml-5"  onclick="statusCourse(\''+row.c_num+'\',\'0\')" style="text-decoration:none">下架</a>';
    			            		}else{
    			            			str+='<a title="发布" class="ml-5"  onclick="statusCourse(\''+row.c_num+'\',\'1\')" style="text-decoration:none">发布</a>';
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
