<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp"%>

    <title>新增课程</title>
    <link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
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
        课程添加
        <a class="btn btn-success radius f-r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
    </nav>
    <article class="Hui-admin-content clearfix">
        <div class="panel">
            <div class="panel-body">
                <form action="user/courseAddTeacher.action" method="post" class="form form-horizontal" id="form-course-add" enctype="multipart/form-data">
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程名称：</label>
                        <div class="form-controls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" placeholder="请输入课程名称" id="coursename" name="coursename">
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程简介：</label>
                        <div class="form-controls col-xs-8 col-sm-9">
                            <!--<input type="text" class="input-text" placeholder="请输入课程简介" id="course-ind" name="course-ind">-->
                            <textarea id="courseind" name="courseind" class="textarea "  placeholder="请输入课程简介......最少输入10个字符" style="height: 33px"></textarea>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程类别：</label>
                        <div class="form-controls col-xs-2 col-sm-2">
						<span class="select-box" style="width: 60%">
						<select name="coursestate" class="select" title="请选择课程类别!" required>
						 	<option value=""></option>
							<option value="1">前端课程</option>
							<option value="2">Java开发</option>
							<option value="3">大数据</option>
						</select>
						</span>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程原价：</label>
                        <div class="form-controls col-xs-2 col-sm-2">
                            <input type="text" class="input-text" placeholder="请输入课程原价" id="courseopri" name="courseopri" style="width: 70%">
                            <span>元</span>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程现价：</label>
                        <div class="form-controls col-xs-2 col-sm-2">
                            <input type="text" class="input-text" placeholder="请输入课程现价" id="coursenpri" name="coursenpri" style="width: 70%">
                            <span>元</span>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程计划：</label>
                        <div class="form-controls col-xs-8 col-sm-9">
                            <textarea id="courseplan" name="courseplan" class="textarea textarea-picture"  placeholder="请输入课程计划......最少输入10个字符"></textarea>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程封面：</label>
                        <div class="form-controls col-xs-8 col-sm-9">
						<span class="btn-upload">
							<a href="javascript" class="btn btn-primary radius btn-upload"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
							<input type="file" name="file" id="btn-upload-file-thumb" class="input-file">
						</span>
                        </div>
                    </div>

                    <div class="row clearfix">
                        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                            <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
                            <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </article>
</div>
<%@ include file="footer.jsp"%>  

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
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
    $(function(){
    	$(".textarea-picture").Huitextarealength({
            minlength: 10,
            maxlength: 500
        });
        $("#course-ind").Huitextarealength({
            minlength: 10,
            maxlength: 50
        });
    	$.ajax({
			url : 'user/getAllTeacher.action',
			type : 'POST', // GET
			async : true, // 或false,是否异步
			data : '',
			timeout : 5000, // 超时时间
			success : function(data, textStatus, jqXHR) {
				$("#form-course-add").load(location.href+" #form-course-add"); 
			}
		}); 
    	$("#form-course-add").validate({
            rules:{
            	coursename:{
                       required:true,
                       minlength:2,
                       maxlength:16
                  },
                  courseind:{
                      required:true,
                      minlength:10,
                      maxlength:50
                  },
                  courseopri:{
                       required:true,
                       number:true,
                  },
                  coursenpri:{
                      required:true,
                      number:true,
                 },
                 courseplan:{
                     required:true,
                     minlength:10,
                     maxlength:500
                 }
            },
            messages: {
            	   coursename:{
                       required:"请输入课程名称",
                       minlength:"课程名称最少2位",
                       maxlength:"课程名称最长16位"
	               },
	               courseind:{
	                   required:"请输入课程简介",
	                   minlength:"请输入最少十个字",
	                   maxlength:"课程简介不能超过50个字"
	               },
	               courseopri:{
	                    required:"请输入课程原价",
	                    number:"请输入正确的课程价格",
	               },
	               coursenpri:{
	            	    required:"请输入课程现价",
	                    number:"请输入正确的课程价格",
	              },
	              courseplan:{
	            	   required:"请输入课程计划",
	                   minlength:"请输入最少十个字",
	                   maxlength:"课程简介不能超过500个字"
	              }
              }
       });

    });
</script>
</body>
</html>
