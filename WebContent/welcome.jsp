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
	<script type="text/javascript" src="lib/html5shiv.js"></script>
	<script type="text/javascript" src="lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.9/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/business/css/style.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>我的桌面</title>
	</head>
<body>
	<div class="wap-container">
		<article class="Hui-admin-content clearfix">
			<div class="row-24 clearfix" style="margin-left: -12px; margin-right: -12px;">
				<div class="col-24-xs-24 col-24-sm-12 col-24-md-12 col-24-lg-12 col-24-xl-6" style="padding-left: 12px; padding-right: 12px; margin-bottom: 24px;">
					<div class="panel">
						<div class="panel-header" style="padding:15px 24px;font-weight: 400;color:#999;">总学生数：</div>
						<div class="panel-body" style="padding:0 24px;">
							<div class="c-primary" style="font-size: 30px;line-height: 38px;padding-bottom: 24px;">
								<span id="studentcount"> 9,999,999</span>&nbsp;人
							</div>
							<div class="f-14" style="padding: 10px 0;border-top:solid 1px #eee"><span class="c-999">今日新增学生</span> <span id="daystudentcount"> 1,234 </span>&nbsp;人</div>
						</div>
					</div>
				</div>
				<div class="col-24-xs-24 col-24-sm-12 col-24-md-12 col-24-lg-12 col-24-xl-6" style="padding-left: 12px; padding-right: 12px; margin-bottom: 24px;">
					<div class="panel">
						<div class="panel-header" style="padding:15px 24px;font-weight: 400;color:#999;">总访教师数：</div>
						<div class="panel-body" style="padding:0 24px;">
							<div class="c-success" style="font-size: 30px;line-height: 38px;padding-bottom: 24px;">
								<span id="teachercount"> 9,999,999 </span>&nbsp;人
							</div>
							<div class="f-14" style="padding: 10px 0;border-top:solid 1px #eee"><span class="c-999">今日新增教师</span> <span id="dayteachercount">1,234 </span>&nbsp;人</div>
						</div>
					</div>
				</div>
				<div class="col-24-xs-24 col-24-sm-12 col-24-md-12 col-24-lg-12 col-24-xl-6" style="padding-left: 12px; padding-right: 12px; margin-bottom: 24px;">
					<div class="panel">
						<div class="panel-header" style="padding:15px 24px;font-weight: 400;color:#999;">总课程数：</div>
						<div class="panel-body" style="padding:0 24px;">
							<div class="c-danger" style="font-size: 30px;line-height: 38px;padding-bottom: 24px;">
								<span id="coursecount">99,999 </span>&nbsp;节
							</div>
							<div class="f-14" style="padding: 10px 0;border-top:solid 1px #eee"><span class="c-999">今日新增课程</span> <span id="daycoursecount">1,234 </span>&nbsp;节</div>
						</div>
					</div>
				</div>
				<div class="col-24-xs-24 col-24-sm-12 col-24-md-12 col-24-lg-12 col-24-xl-6" style="padding-left: 12px; padding-right: 12px; margin-bottom: 24px;">
					<div class="panel">
						<div class="panel-header" style="padding:15px 24px;font-weight: 400;color:#999;">总书籍数：</div>
						<div class="panel-body" style="padding:0 24px;">
							<div class="c-warning" style="font-size: 30px;line-height: 38px;padding-bottom: 24px;">
								<span id="bookcount">99,999 </span>&nbsp;本
							</div>
							<div class="f-14" style="padding: 10px 0;border-top:solid 1px #eee"><span class="c-999">今日新增书籍</span> <span id="daybookcount">1,234 </span>&nbsp;本</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel">
				<div class="panel-body" >
					<p class="f-20 text-success">
						欢迎登录&nbsp;&nbsp;&nbsp;&nbsp;亚欣和在线学习 — 后台管理系统！
					</p>
					<p >本次登陆时间：<span class="nowtime"></span></p>
					<img src="img/1.png" alt="" style="width: 40%;margin-left: 28%">
				</div>
			</div>
		</article>
		<footer class="footer Hui-admin-footer">
			<p>Copyright &copy; 2018版权归亚欣和科技所有</p>
		</footer>
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/3.1.1/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="static/business/js/main.js"></script>
	<script>
        $(function () {
        	$.ajax({
				url : 'user/getCountOfUser.action',
				type : 'POST', // GET
				async : true, // 或false,是否异步
				data : '',
				timeout : 5000, // 超时时间
				dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data, textStatus, jqXHR) {
					$("#studentcount").html(data.studentcount.studentcount);
					$("#daystudentcount").html(data.studentcount.daystudentcount);
					$("#teachercount").html(data.teachercount.teachercount);
					$("#dayteachercount").html(data.teachercount.dayteachercount);
					$("#coursecount").html(data.coursecount.coursecount);
					$("#daycoursecount").html(data.coursecount.daycoursecount);
					$("#bookcount").html(data.bookcount.bookcount);
					$("#daybookcount").html(data.bookcount.daybookcount);
				}
			});
            var myDate = new Date();
            var year=myDate.getFullYear();
            var month=myDate.getMonth()+1;
            if(month<10){
                month = "0"+month;
			}
            var date=myDate.getDate();
            if(date<10){
                date = "0"+date;
            }
            var h=myDate.getHours();
            var m=myDate.getMinutes();
            var s=myDate.getSeconds();
            var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
            $(".nowtime").text(now);
        })
	</script>
</body>
</html>
