 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp"%>
	<title>管理员列表 - 用户管理 - 亚欣和在线学习系统</title>
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
			评论管理
			<span class="c-gray en">/</span>
			意见反馈
			<a class="btn btn-success radius f-r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
		</nav>

		<article class="Hui-admin-content clearfix">
			<div class="panel mt-20">
                <div class="panel-body">
                    <div class="clearfix mt-20">
                        <table id="driverTable" class="table table-border table-bordered table-hover table-bg table-sort" >
                            <thead>
                            <tr class="text-c">
                                <th></th>
                                <th>姓名</th>
                                <th>邮箱</th>
                                <th>职业</th>
                                <th>意见</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
		</article>
	</div>
	 <%@ include file="footer.jsp"%>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="lib/datatables/1.10.15/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="static/business/js/main.js"></script>
	<script type="text/javascript" src="yk.js"></script>
    <script src="lib/bootbox.js" ></script>
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
			runDatetimePicker();
			//消息列表分页展示
	      	  driverTable=$('#driverTable').dataTable({
	      	    	processing: true,//是否显示处理状态
	      	    	paginationType:'simple_numbers',
	      	        serverSide: false,//true代表后台处理分页，false代表前台处理分页 
	      	        scrollX: true,//设置水平滚动
	      	        ordering: false,//是否允许Datatables开启排序
	      	        autoWidth: false,//控制Datatables是否自适应宽度
	      	        bLengthChange: false,
	      	      	iDisplayLength: 10,
	      	        ajax:{
	      	            url: 'user/getSuggestionList.action',
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
	      			            { "data": "su_name"},
	      						{ "data": "su_email" },
	      						{ "data": "su_occupation" },
	      						{ "data": "su_message"},
	      			        ],
	      			  "columnDefs": [//设置列定义初始化属性
	      			            {
	      			            	"targets": [5],
	      			            	"render" : function(data,type,row, meta) {
	      			            		var str='<a title="回复" href="javascript:;" class="ml-5" onclick="editUser(\''+row.c_num+'\')"  style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
	      			            		str+='<a title="删除" href="javascript:;" class="ml-5" onclick="resetpwd(\''+row.c_num+'\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe609;</i></a>';
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
