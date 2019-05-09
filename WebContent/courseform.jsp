<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="wap-container">
		<div class="panel">
			<div class="panel-body">
				<form action="" method="post" class="form form-horizontal" id="form-course-update">
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>课程名称：</label>
                        <div class="form-controls col-xs-7 col-sm-8">
                            <input type="text" class="input-text" placeholder="请输入课程名称" id="coursename" name="coursename">
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>课程简介：</label>
                        <div class="form-controls col-xs-7 col-sm-8">
                            <!--<input type="text" class="input-text" placeholder="请输入课程简介" id="course-ind" name="course-ind">-->
                            <textarea id="courseind" name="courseind" class="textarea "  placeholder="请输入课程简介......最少输入10个字符" style="height: 33px"></textarea>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>课程类别：</label>
                        <div class="form-controls col-xs-5 col-sm-5">
						<span class="select-box" style="width: 60%">
						<select id="coursestate" name="coursestate" class="select" title="请选择课程类别!" required>
						 	<option value=""></option>
							<option value="1">前端课程</option>
							<option value="2">Java开发</option>
							<option value="3">大数据</option>
						</select>
						</span>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>课程原价：</label>
                        <div class="form-controls col-xs-2 col-sm-2">
                            <input type="text" class="input-text" placeholder="请输入课程原价" id="courseopri" name="courseopri" style="width: 70%">
                            <span>元</span>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>课程现价：</label>
                        <div class="form-controls col-xs-2 col-sm-2">
                            <input type="text" class="input-text" placeholder="请输入课程现价" id="coursenpri" name="coursenpri" style="width: 70%">
                            <span>元</span>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>课程计划：</label>
                        <div class="form-controls col-xs-7 col-sm-8">
                            <textarea id="courseplan" name="courseplan" class="textarea textarea-picture"  placeholder="请输入课程计划......最少输入10个字符"></textarea>
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
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>

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