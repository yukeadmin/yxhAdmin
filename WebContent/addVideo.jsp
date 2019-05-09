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
				<form action="user/addCourseVideo.action" method="post" class="form form-horizontal" id="form-course-update" enctype="multipart/form-data">
                     <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>视频名称：</label>
                        <div class="form-controls col-xs-7 col-sm-8">
                            <input type="text" class="input-text" placeholder="请输入视频名称" id="videoname" name="videoname">
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>视频简介：</label>
                        <div class="form-controls col-xs-7 col-sm-8">
                            <!--<input type="text" class="input-text" placeholder="请输入视频简介" id="course-ind" name="course-ind">-->
                            <textarea id="videomessage" name="videomessage" class="textarea "  placeholder="请输入课程简介......最少输入10个字符" style="height: 33px"></textarea>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <label class="form-label col-xs-5 col-sm-3"><span class="c-red">*</span>视频文件：</label>
                        <div class="form-controls col-xs-7 col-sm-8">
						<span class="btn-upload">
							<a href="javascript" class="btn btn-primary radius btn-upload"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
							<input type="file" name="file" id="btn-upload-file-thumb" class="input-file">
						</span>
                        </div>
                    </div>

                    <div class="row clearfix">
                        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                            <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
                            <button data-dismiss="modal" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
