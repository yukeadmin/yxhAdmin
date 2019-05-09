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
				<form action="" method="post" class="form form-horizontal" id="form-member-update">
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="username" name="username">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="username2" name="username2">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
					<div class="form-controls col-xs-8 col-sm-9 skin-minimal">
						<div class="radio-box">
							<input name="sex" type="radio" id="sex-1" checked value="1">
							<label for="sex-1">男</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-2" name="sex" value="0">
							<label for="sex-2">女</label>
						</div>
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="mobile" name="mobile">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>QQ号：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text"  placeholder="" id="qnum" name="qnum">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text" placeholder="@" name="email" id="email">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>学校：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text" placeholder="" name="school" id="school">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>专业：</label>
					<div class="form-controls col-xs-8 col-sm-9">
						<input type="text" class="input-text" placeholder="" name="subject" id="subject">
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
			jQuery.validator.addMethod("regex", //addMethod第1个参数:方法名称 
					function(value,element,params){//addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
				var exp = new RegExp(params);//实例化正则对象，参数为传入的正则表达式 
				return exp.test(value); //测试是否匹配 
				},"格式错误");//addMethod第3个参数:默认错误信息
			$('.skin-minimal input').iCheck({
				checkboxClass: 'icheckbox-blue',
				radioClass: 'iradio-blue',
				increaseArea: '20%'
			});

			$("#form-member-update").validate({
                rules:{
                      username:{
                           required:true,
                           minlength:2,
                           maxlength:16
                      },
                      username2:{
                          required:true,
                          minlength:2,
                          maxlength:16
                     },
                      sex:{
                           required:true,
                      },
                      mobile:{
                           required:true,
                           isMobile:true,
                      },
                      qnum:{
                           required:true,
                           digits:true,
                           minlength:2,
                           maxlength:16
                      },
                      email:{
                           required:true,
                           email:true,
                      },
                      school:{
                           required:true,
                           regex:"^[\u4e00-\u9fa5]{0,}$",
                           minlength:2,
                           maxlength:16
                      },
                      subject:{
                           required:true,
                           regex:"^[\u4e00-\u9fa5]{0,}$",
                           minlength:2,
                           maxlength:16
                      }
                },
                messages: {
                      username: {
                        required: "请输入姓名",
                        minlength: "姓名最少由两个字母组成",
                      maxlength: "姓名最多由两个字母组成"
                      },
                      username2: {
                          required: "请输入用户名",
                          minlength: "用户名最少由两个字母组成",
                        maxlength: "用户名最多由两个字母组成"
                        },
                      mobile: {
                        required: "请输入大陆11位手机号",
                        isMobile: "请输入正确的手机号"
                      },
                      qnum:{
                          required:"请输入正确的QQ号",
                          digits:"请输入正确的QQ号",
                          minlength: "用户名最少由两个字符组成",
                       	  maxlength: "用户名最多由十六个字符组成"
                           },
                      email: {
                          required: "请输入一个正确的邮箱",
                          isMobile: "请输入正确的邮箱"
                            },
                      school: {
                          required: "请输入学校名称",
                          regex:"请输入正确的学校名称",
                          minlength: "用户名最少由两个字符组成",
                       	  maxlength: "用户名最多由十六个字符组成"
                            },
                      subject: {
                          required: "请输入专业名称",
                          regex:"请输入正确的专业名称",
                          minlength: "用户名最少由两个字符组成",
                          maxlength: "用户名最多由十六个字符组成"
                            }
                     }
           });
		});
	</script>