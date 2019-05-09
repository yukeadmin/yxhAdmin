<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!--_header 作为公共模版分离出去-->
		<header class="Hui-navbar">
			<div class="navbar">
				<div class="container-fluid clearfix">
					<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar">
						<ul class="clearfix">
						    <li id="name-title"></li>
							<li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A"  id="name-title"> <i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a href="javascript:;" onClick="person_info('个人信息','student-add.jsp','','510')">个人信息</a></li>
									<!-- myselfinfo() -->
									<li><a href="login.jsp">切换账户</a></li>
								</ul>
							</li>
							<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<!--/_header 作为公共模版分离出去-->
	