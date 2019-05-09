<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--_menu 作为公共模版分离出去-->
	<aside class="Hui-admin-aside-wrapper">
		<div class="Hui-admin-logo-wrapper">
			<!--<a class="" href="/aboutHui.shtml">-->
				<i class="va-m iconpic global-logo"></i>
				<span class="va-m logo navbar-logo">亚欣和在线学习</span>
			<!--</a>-->
		</div>
		<div class="Hui-admin-menu-dropdown bk_2">
			<c:if test="${loginuser.isAdmin !='t' }">
				<dl id="menu-member" class="Hui-menu">
					<dt class="Hui-menu-title"><i class="Hui-iconfont">&#xe60d;</i> 用户管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
					<dd class="Hui-menu-item">
						<ul>
							<li><a data-href="student-list.jsp" data-title="学生列表" href="javascript:void(0)">学生列表</a></li>
							<li><a data-href="teacher-list.jsp" data-title="教师列表" href="javascript:void(0)">教师列表</a></li>
							<c:if test="${loginuser.isAdmin =='a' }">
								<li><a data-href="admin-list.jsp" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
							</c:if>
						</ul>
					</dd>
				</dl>
			</c:if>
			<c:if test="${loginuser.isAdmin !='t' }">
				<dl id="menu-course" class="Hui-menu">
					<dt class="Hui-menu-title"><i class="Hui-iconfont">&#xe63e;</i> 资料管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
					<dd class="Hui-menu-item">
						<ul>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">课程管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="course-list.jsp" data-title="课程列表" href="javascript:void(0)">课程列表</a></li>
											<li><a data-href="course-add.jsp" data-title="新增课程" onclick="Hui_admin_tab(this)" href="javascript:;" >新增课程</a></li>
										</ul>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">视频管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="video-list.jsp" data-title="视频列表" href="javascript:void(0)">视频列表</a></li>
										</ul>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">书籍管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="book-list.jsp" data-title="书籍列表" href="javascript:void(0)">书籍列表</a></li>
										</ul>
									</dd>
								</dl>
							</li>
	
						</ul>
					</dd>
				</dl>
			</c:if>
			<c:if test="${loginuser.isAdmin =='t' }">
				<dl id="menu-course" class="Hui-menu">
					<dt class="Hui-menu-title"><i class="Hui-iconfont">&#xe63e;</i> 资料管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
					<dd class="Hui-menu-item">
						<ul>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">课程管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="course-list-teacher.jsp" data-title="课程列表" href="javascript:void(0)">课程列表</a></li>
											<li><a data-href="course-add-teacher.jsp" data-title="新增课程" onclick="Hui_admin_tab(this)" href="javascript:;" >新增课程</a></li>
										</ul>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">视频管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="video-list-teacher.jsp" data-title="视频列表" href="javascript:void(0)">视频列表</a></li>
										</ul>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">书籍管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="book-list-teacher.jsp" data-title="书籍列表" href="javascript:void(0)">书籍列表</a></li>
										</ul>
									</dd>
								</dl>
							</li>
						</ul>
					</dd>
				</dl>
			</c:if>
			<dl id="menu-comments" class="Hui-menu">
				<dt class="Hui-menu-title"><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
				<dd class="Hui-menu-item">
					<ul>
						<li><a data-href="comment-list.html" data-title="评论列表" href="javascript:void(0)">评论列表</a></li>
						<c:if test="${loginuser.isAdmin !='t' }">
							<li><a data-href="suggestion-list.jsp" data-title="意见反馈" href="javascript:void(0)">意见反馈</a></li>
						</c:if>
					</ul>
				</dd>
			</dl>
			<c:if test="${loginuser.isAdmin =='n' }">
				<dl id="menu-article" class="Hui-menu">
					<dt class="Hui-menu-title"><i class="Hui-iconfont">&#xe616;</i> 活动管理<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
					<dd class="Hui-menu-item">
						<ul>
							<li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">资讯管理</a></li>
							<li><a data-href="article-add.html" data-title="新增资讯" onclick="Hui_admin_tab(this)" href="javascript:;">新增资讯</a></li>
							<li>
								<dl class="Hui-menu">
									<dt class="Hui-menu-title">二级菜单<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
									<dd class="Hui-menu-item">
										<ul>
											<li><a data-href="_blank.html" data-title="空页面" href="javascript:void(0)">三级菜单</a></li>
										</ul>
									</dd>
								</dl>
							</li>
						</ul>
					</dd>
				</dl>
			</c:if>
			<c:if test="${loginuser.isAdmin =='n' }">
				<dl id="menu-errorPage" class="Hui-menu" >
					<dt class="Hui-menu-title"><i class="Hui-iconfont">&#xe6e0;</i> 异常页面<i class="Hui-iconfont Hui-admin-menu-dropdown-arrow">&#xe6d5;</i></dt>
					<dd class="Hui-menu-item">
						<ul>
							<li><a data-href="error-404.html" data-title="404" href="javascript:void(0)">404</a></li>
							<li><a data-href="error-500.html" data-title="404" href="javascript:void(0)">500</a></li>
						</ul>
					</dd>
				</dl>
			</c:if>
		</div>
	</aside>
	<div class="Hui-admin-aside-mask"></div>
	<!--/_menu 作为公共模版分离出去-->