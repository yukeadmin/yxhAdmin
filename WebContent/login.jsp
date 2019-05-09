<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<!--[if lt IE 9]>
	<script type="text/javascript" src="lib/html5.js"></script>
	<script type="text/javascript" src="lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin.pro.iframe/css/H-ui.login.min.css" />
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.9/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/business/css/style.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script><![endif]-->
	<title>后台登录 - 亚欣和在线学习系统</title>
	<link rel="icon" href="logo.ico">
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" name="form1" method="post">
				<div class="row clearfix">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="form-controls col-xs-8">
						<input id="username" name="username" type="text" placeholder="手机号" class="input-text size-L">
					</div>
				</div>
				<div class="row clearfix">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="form-controls col-xs-8">
						<input id="userpass" name="userpass" type="password" placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row clearfix">
					<div class="form-controls col-xs-8 col-xs-offset-3 yzmchange">
						<input id="yzm" name="yzm" class="input-text size-L" type="text" placeholder="验证码"  style="width:200px;">
						<img id="kaptchaImage" src="/yxhAdmin/captcha.jpg" style="margin-left:10px;width: 145px;height: 40px">
					</div>
				</div>
				<div class="row clearfix">
					<div class="form-controls col-xs-8 col-xs-offset-3 loginmsg">
						<label for="choseadmin" >
							<input type="radio" name="choseadmin" id="choseadmin" value="管理员" checked="checked">
							<!--checked="checked"-->
							管理员</label>
						<label for="choseteacher">
							<input type="radio" name="choseadmin" id="choseteacher" style="margin-left: 20px" value="教师" >
							教师</label>

						<p class="login-msg" style="height:10px"> ${loginmsg}</p>
					</div>
				</div>
				<div class="row clearfix">
					<div class="form-controls col-xs-8 col-xs-offset-3">
						<input name="" type="submit" class="btn btn-success radius size-L loginbtn " style="width: 160px;margin-right: 30px" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
						<input name="" type="reset" class="btn btn-default radius size-L" style="width: 160px" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright &copy; 2018版权归亚欣和科技所有</div>

	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript">
		$(function () {
            var ok1 = false;
            var ok2 = false;
            var ok3 = false;
            $("form :input").blur(function () {
                var $value = $.trim(this.value);
                if ($(this).is("#username")){
                    if($value !==""&&!(/^((13[0-9])|(14[5,7,9])|(15[^4])|(16[6])|(17[0,1,2,3,5,6,7,8])|(18[0-9])|(19[8,9]))\d{8}$/.test($value))||$value == ""){
                        var errorMsg = " 手机号格式不正确！";
                        ok1 = false;
                        $(".login-msg").text(errorMsg).css("color","red");
                    }else{
                        ok1 = true;
                        $(".login-msg").text("格式正确！").css("color","green");
                    }
                }
                if($(this).is("#userpass")) {
                    if($value.length < 6 ){
                        var errorMsg = " 密码不能低于六位！";
                        ok2 = false;
                        $(".login-msg").text(errorMsg).css("color","red");
                    }else if(!(/^(?![a-zA-z]+$)(?!\d+$)(?![`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]+$)[a-zA-Z\d`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]+$/.test($value))){
                        var errorMsg = " 数字/字母/特殊字符至少两种！";
                        ok2 = false;
                        $(".login-msg").text(errorMsg).css("color","red");
                    }else if($value.length > 16 ){
                        var errorMsg = " 密码不能超过十六位！";
                        ok2 = false;
                        $(".login-msg").text(errorMsg).css("color","red");
                    }else{
                        ok2 = true;
                        $(".login-msg").text("格式正确！").css("color","green");
                    }
                }
                if($(this).is("#yzm")) {
                    if($value.length !=5){
                        var errorMsg = " 验证码必须是五位！";
                        ok3 = false;
                        $(".login-msg").text(errorMsg).css("color","red");
                    }else if (!(/^[A-Za-z0-9]*$/.test($value))) {
                        var errorMsg = " 验证码格式不正确！";
                        ok3 = false;
                        $(".login-msg").text(errorMsg).css("color","red");
                    }else{
                        ok3 = true;
                        $(".login-msg").text("格式正确！").css("color","green");
                    }
                }
            }).keyup(function(){
                //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
                $(this).triggerHandler("blur");
            }).focus(function(){
                $(this).triggerHandler("blur");
            });
            $('#kaptchaImage').click(
                function() {
                    $(this).attr(
                        'src',
                        '/yxhAdmin/captcha.jpg?'
                        + Math.floor(Math.random() * 100));
                })
            $('.loginbtn').click(function () {
                $("form :input").trigger("blur");
                if(!ok1){
                    var errorMsg = " 手机号格式不正确！";
                    $(".login-msg").text(errorMsg).css("color","red");
                    return ok1;
                }else if(!ok2){
                    var errorMsg = " 密码格式不正确！";
                    $(".login-msg").text(errorMsg).css("color","red");
                    return ok2;
                }else if(!ok3){
                    var errorMsg = " 验证码格式不正确！";
                    $(".login-msg").text(errorMsg).css("color","red");
                    return ok3;
                }else if(ok1&ok2&ok3){
                    var list = $('input[name="choseadmin"]');
                    for(i = 0; i<list.length;i++){
                        if(list.eq(i).is(":checked")){
                            if(list[i].value=="管理员"){
                                $(".form").attr("action","user/Adminlogin.action");
                                $(".form").submit();
                                break;
                            }
                            if(list[i].value=="教师"){
                                $(".form").attr("action","user/Teacherlogin.action");
                                $(".form").submit();
                                break;
                            }
                        }
                    }
                    return true;
                }
            });
		})
	</script>
</body>
</html>
