<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp"%>

	<title>亚欣和在线学习 — 后台管理系统</title>
	<link rel="icon" href="logo.ico">
</head>
<body>

	<%@ include file="left.jsp"%>

	<div class="Hui-admin-dislpayArrow">
		<a href="javascript:void(0);" onClick="displaynavbar(this)">
			<i class="Hui-iconfont Hui-iconfont-left">&#xe6d4;</i>
			<i class="Hui-iconfont Hui-iconfont-right">&#xe6d7;</i>
		</a>
	</div>

	<section class="Hui-admin-article-wrapper">
		<%@ include file="header.jsp"%>

		<div id="Hui-admin-tabNav" class="Hui-admin-tabNav">
			<div class="Hui-admin-tabNav-wp">
				<ul id="min_title_list" class="acrossTab clearfix" style="width: 241px; left: 0px;">
					<li class="active"><span title="我的桌面" data-href="welcome.jsp">我的桌面</span><em></em></li>
				</ul>
			</div>
			<div class="Hui-admin-tabNav-more btn-group" style="display: none;">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a>
				<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>

		<div id="iframe_box" class="Hui-admin-article">
			<div class="show_iframe">
				<iframe id="iframe-welcome" data-scrolltop="0" scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
			</div>
		</div>
	</section>
	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前 </li>
			<li id="closeall">关闭全部 </li>
		</ul>
	</div>
	<%@ include file="footer.jsp"%>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="static/business/js/main.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url : 'user/getLoginUser.action',
				type : 'POST', // GET
				async : true, // 或false,是否异步
				data : '',
				timeout : 5000, // 超时时间
				dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data, textStatus, jqXHR) {
					if(data.a_name ==null){
						$("#name-title").text(data.t_name);
					}else if(data.t_name ==null){
						$("#name-title").text(data.a_name);
					}
				}
			}); 	
		});
	</script>
</body>
</html>
