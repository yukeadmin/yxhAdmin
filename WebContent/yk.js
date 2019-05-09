/* 编辑用户信息*/	
function editUser(id,type) {
	$.ajax({
		url : 'user/getUserById.action',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {id:id,type:type},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			if(data.isAdmin=="s"){
				$("#form-member-update").attr("action", "user/studentUpdate.action");
				$("#username").val(data.s_Fname);//
				$("#username2").val(data.s_name);//
				if(data.s_sex == "1"){
    				$('input[name="sex"]').eq(1).attr("checked","checked");
    			}else{
    				
    				$('input[name="sex"]').eq(0).attr("checked","checked");
    			}
				$("#mobile").val(data.s_mobile);
				$("#qnum").val(data.s_qnum);
				$("#email").val(data.s_email);
				$("#school").val(data.s_col);
				$("#subject").val(data.s_sub);
				$("#id").val(data.s_num);
				$('#modal-demo').modal('show');// 显示修改
			}else if(data.isAdmin=="t"){
				$("#form-member-update").attr("action", "user/teacherUpdate.action");
				$("#username").val(data.t_Fname);//
				$("#username2").val(data.t_name);//
				if(data.t_sex == "1"){
    				$('input[name="sex"]').eq(0).attr("checked","checked");
    			}else{
    				$('input[name="sex"]').eq(1).attr("checked","checked");
    			}
				$("#mobile").val(data.t_mobile);
				$("#qnum").val(data.t_qnum);
				$("#email").val(data.t_email);
				$("#school").val(data.t_col);
				$("#subject").val(data.t_sub);
				$("#id").val(data.t_num);
				$('#modal-demo').modal('show');// 显示修改
			}else if(data.isAdmin=="a" || data.isAdmin=="b"){
				$("#form-member-update").attr("action", "user/adminUpdate.action");
				$("#username").val(data.a_Fname);//
				$("#username2").val(data.a_name);//
				if(data.a_sex == "1"){
    				$('input[name="sex"]').eq(0).attr("checked","checked");
    			}else{
    				$('input[name="sex"]').eq(1).attr("checked","checked");
    			}
				$("#mobile").val(data.a_mobile);
				$("#qnum").val(data.a_qnum);
				$("#email").val(data.a_email);
				$("#school").val(data.a_col);
				$("#subject").val(data.a_sub);
				$("#id").val(data.a_num);
				$('#modal-demo').modal('show');// 显示修改
			}
		},
		error : function(XMLHttpRequest,xhr, textStatus) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}
//重置密码
function resetpwd(id,type) {
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
		message : '确定要重置密码吗?',
		callback : function(result) {
			if (result) {
				// 发送请求删除数据
				$.ajax({
					url : 'user/resetPwd.action',
					type : 'POST', // GET
					async : true, // 或false,是否异步
					data : {id:id,type:type},
					timeout : 5000, // 超时时间
					dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data, textStatus, jqXHR) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.message,
							title : "操作消息",
						});
						// 刷新当前页面
						driverTable.api().ajax.reload();
//						$("#user-content").load(location.href+" #user-content"); 
					},
					error : function(xhr, textStatus) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.message,
							title : "操作消息",
						});
						driverTable.api().ajax.reload();
					}
				});
			}
		},
		title : "确认框",
	});
}
//删除用户
function statusUser(id,type,state){
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
		message : '确定要执行本操作吗?',
		callback : function(result) {
			if (result) {
				// 发送请求删除数据
				$.ajax({
					url : 'user/statusUser.action',
					type : 'POST', // GET
					async : true, // 或false,是否异步
					data : {id:id,type:type,state:state},
					timeout : 5000, // 超时时间
					dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data, textStatus, jqXHR) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.message,
							title : "操作消息",
						});
						driverTable.api().ajax.reload();
					},
					error : function(xhr, textStatus) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.message,
							title : "操作消息",
						});
						driverTable.api().ajax.reload();
					}
				});
			}
		},
		title : "确认框",
	});
}
//删除视频
function statusCourse(id,state){
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
		message : '确定要执行本操作吗?',
		callback : function(result) {
			if (result) {
				// 发送请求删除数据
				$.ajax({
					url : 'user/statusCourse.action',
					type : 'POST', // GET
					async : true, // 或false,是否异步
					data : {id:id,state:state},
					timeout : 5000, // 超时时间
					dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data, textStatus, jqXHR) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.message,
							title : "操作消息",
						});
						driverTable.api().ajax.reload();
					},
					error : function(xhr, textStatus) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.message,
							title : "操作消息",
						});
						driverTable.api().ajax.reload();
					}
				});
			}
		},
		title : "确认框",
	});
}
/* 编辑课程信息*/	
function editCourse(id) {
	$.ajax({
		url : 'user/getCourseById.action',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {id:id},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			$("#form-course-update").attr("action", "user/courseUpdate.action");
			$("#coursename").val(data.c_name);//
			$("#courseind").val(data.c_ind);//
			$("#coursestate").val(data.c_state);
			$("#courseteacher").val(data.t_name);
			$("#courseopri").val(data.c_opri);
			$("#coursenpri").val(data.c_npri);
			$("#courseplan").val(data.c_plan);
			$('#modal-demo').modal('show');// 显示修改
		},
		error : function(XMLHttpRequest,xhr, textStatus) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}
/* 编辑课程封面*/	
function editCourseImg(id) {
	$.ajax({
		url : 'user/getCourseById.action',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {id:id},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			$("#form-course-update").attr("action", "user/editCourseImg.action");
			$('#modal-demo2').modal('show');// 显示修改
		},
		error : function(XMLHttpRequest,xhr, textStatus) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}
/* 添加课程视频*/	
function addCourseVideo(id) {
	$.ajax({
		url : 'user/getCourseById.action',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {id:id},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			$("#form-course-update").attr("action", "user/addCourseVideo.action");
			$('#modal-demo3').modal('show');// 显示修改
		},
		error : function(XMLHttpRequest,xhr, textStatus) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}
