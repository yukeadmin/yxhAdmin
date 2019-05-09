package com.yxh.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yxh.pojo.Admin;
import com.yxh.pojo.Book;
import com.yxh.pojo.Course;
import com.yxh.pojo.Student;
import com.yxh.pojo.Suggestion;
import com.yxh.pojo.Teacher;
import com.yxh.pojo.Video;
import com.yxh.service.UserService;
import com.yxh.util.Contant;
import com.yxh.util.DataTablePageUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService = null;
    
	@RequestMapping(value={"/Adminlogin.action"},method={RequestMethod.POST})
	public ModelAndView StudentLogin(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		session.setAttribute("loginmsg", null);
		session.removeAttribute("loginuser");
		session.removeAttribute("loginadmin");
		ModelAndView mv = new ModelAndView();
		String mobile = request.getParameter("username");
		String password = request.getParameter("userpass");
		String captcha = request.getParameter("yzm");
		String ori_captcha =(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (captcha.equalsIgnoreCase(ori_captcha)) {
		Admin admin = null;
		try {
			admin = userService.checkAdminLogin(mobile,password);
			if(admin == null){
				mv.setViewName("redirect:/login.jsp");
				session.setAttribute("loginmsg", Contant.LOGIN_SUCESS);
			}
			else{
				session.setAttribute("isLogin", "1");
				session.setAttribute("loginuser", admin);
				session.setAttribute("loginadmin", admin);
				mv.setViewName("redirect:/index.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			session.setAttribute("loginmsg", Contant.CODE_WRONG);
			mv.setViewName("redirect:/login.jsp");	
		}		
		return mv;		
	}
	@RequestMapping(value={"/Teacherlogin.action"},method={RequestMethod.POST})
	public ModelAndView Teacherlogin(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		session.setAttribute("loginmsg", null);
		session.setAttribute("loginuser", null);
		session.setAttribute("loginteacher", null);
		ModelAndView mv = new ModelAndView();
		String mobile = request.getParameter("username");
		String password = request.getParameter("userpass");
		String captcha = request.getParameter("yzm");
		String ori_captcha =(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (captcha.equalsIgnoreCase(ori_captcha)) {
		Teacher teacher = null;
		try {
			teacher = userService.checkTeacherLogin(mobile,password);
			if(teacher == null){
				mv.setViewName("redirect:/login.jsp");
				session.setAttribute("loginmsg", Contant.LOGIN_SUCESS);
			}
			else{
				session.setAttribute("isLogin", "1");
				session.setAttribute("loginuser", teacher);
				session.setAttribute("loginteacher", teacher);
				mv.setViewName("redirect:/index.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			session.setAttribute("loginmsg", Contant.CODE_WRONG);
			mv.setViewName("redirect:/login.jsp");	
		}		
		return mv;		
	}
	@RequestMapping(value={"/getStudentList.action"},method={RequestMethod.POST})
	public void getStudentList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Student> studentList = userService.getStudentList();
		DataTablePageUtil<Student> data = new DataTablePageUtil<Student>();
		data.setData(studentList);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/getTeacherList.action"},method={RequestMethod.POST})
	public void getTeacherList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Teacher> teachertList = userService.getTeacherList();
		DataTablePageUtil<Teacher> data = new DataTablePageUtil<Teacher>();
		data.setData(teachertList);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/getAdminList.action"},method={RequestMethod.POST})
	public void getAdminList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Admin> admintList = userService.getAdminList();
		DataTablePageUtil<Admin> data = new DataTablePageUtil<Admin>();
		data.setData(admintList);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/getCourseList.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getCourseList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Course> AllCourselist=userService.getAllCourse();
		DataTablePageUtil<Course> data = new DataTablePageUtil<Course>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
	@RequestMapping(value={"/getAllCourseTeacher.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getAllCourseTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		List<Course> AllCourselist = new ArrayList<>();
		Teacher teacher = (Teacher) session.getAttribute("loginuser");
		if(teacher!=null){
			AllCourselist=userService.getAllCourseTeacher(teacher.getT_num());
		}
		DataTablePageUtil<Course> data = new DataTablePageUtil<Course>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
	@RequestMapping(value={"/getLoginUser.action"},method={RequestMethod.POST})
	public void getLoginAdmin(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		Admin admin = (Admin)session.getAttribute("loginadmin");
		if(null!=admin){
			ObjectMapper mapper = new ObjectMapper();
			String studentListString = mapper.writeValueAsString(admin);
			response.getWriter().write(studentListString);
		}
		Teacher teacher = (Teacher)session.getAttribute("loginteacher");
		if(null!=teacher){
			ObjectMapper mapper = new ObjectMapper();
			String studentListString = mapper.writeValueAsString(teacher);
			response.getWriter().write(studentListString);
		}
	}
	@RequestMapping(value={"/studentAdd.action"},method={RequestMethod.POST})
	public String studentAdd(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String username2 = request.getParameter("username2");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		String subject = request.getParameter("subject");
		String qnum = request.getParameter("qnum");
		String url = null;
		boolean falg = userService.checkStudentMobile(mobile);
		if(falg){
			boolean emailResult = userService.checkStudentEmail(email);
			if(emailResult){
				boolean result = userService.studentAdd(username,username2,sex,mobile,email,school,subject,qnum);
				if(result){
					session.setAttribute("addmsg", Contant.ADDUSER_SUCESS);
					url = "redirect:/student-add.jsp";
				}
				else{
					session.setAttribute("addmsg", Contant.ADDUSER_FAILD);
					url = "redirect:/student-add.jsp";
				}
			}else{
				session.setAttribute("addmsg", Contant.ADDUSER_EAMILNUMAGIN);
				url = "redirect:/student-add.jsp";
			}
		}else{
			session.setAttribute("addmsg", Contant.ADDUSER_PHONENUMAGIN);
			url = "redirect:/student-add.jsp";
		}
		return url;
	}
	@RequestMapping(value={"/adminAdd.action"},method={RequestMethod.POST})
	public String adminAdd(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String username2 = request.getParameter("username2");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		String subject = request.getParameter("subject");
		String qnum = request.getParameter("qnum");
		String url = null;
		boolean falg = userService.checkAdminMobile(mobile);
		if(falg){
			boolean emailResult = userService.checkAdminEmail(email);
			if(emailResult){
				boolean result = userService.adminAdd(username,username2,sex,mobile,email,school,subject,qnum);
				if(result){
					session.setAttribute("addmsg", Contant.ADDUSER_SUCESS);
					url = "redirect:/admin-add.jsp";
				}
				else{
					session.setAttribute("addmsg", Contant.ADDUSER_FAILD);
					url = "redirect:/admin-add.jsp";
				}
			}else{
				session.setAttribute("addmsg", Contant.ADDUSER_EAMILNUMAGIN);
				url = "redirect:/admin-add.jsp";
			}
		}else{
			session.setAttribute("addmsg", Contant.ADDUSER_PHONENUMAGIN);
			url = "redirect:/admin-add.jsp";
		}
		return url;
	}
	@RequestMapping(value={"/teacherAdd.action"},method={RequestMethod.POST})
	public String teacherAdd(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String username2 = request.getParameter("username2");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		String subject = request.getParameter("subject");
		String qnum = request.getParameter("qnum");
		String url = null;
		boolean falg = userService.checkTeacherMobile(mobile);
		if(falg){
			boolean emailResult = userService.checkTeacherEmail(email);
			if(emailResult){
				boolean result = userService.teacherAdd(username,username2,sex,mobile,email,school,subject,qnum);
				if(result){
					session.setAttribute("addmsg", Contant.ADDUSER_SUCESS);
					url = "redirect:/teacher-add.jsp";
				}
				else{
					session.setAttribute("addmsg", Contant.ADDUSER_FAILD);
					url = "redirect:/teacher-add.jsp";
				}
			}else{
				session.setAttribute("addmsg", Contant.ADDUSER_EAMILNUMAGIN);
				url = "redirect:/teacher-add.jsp";
			}
		}else{
			session.setAttribute("addmsg", Contant.ADDUSER_PHONENUMAGIN);
			url = "redirect:/teacher-add.jsp";
		}
		return url;
	}
	@RequestMapping(value={"/clearSessionMsg.action"},method={RequestMethod.POST})
	public void clearSessionMsg(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		session.removeAttribute("addmsg");
	}
	@RequestMapping(value={"/getUserById.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getUserById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		session.removeAttribute("updateUser");
		if(type.equals("s")){
			Student student = userService.getStudentById(id);
			session.setAttribute("updateUser", student);
			if(null!=student){
				ObjectMapper mapper = new ObjectMapper();
				String studentListString = mapper.writeValueAsString(student);
				response.getWriter().write(studentListString);
			}
		}else if(type.equals("t")){
			Teacher teacher = userService.getTeacherById(id);
			session.setAttribute("updateUser", teacher);
			if(null!=teacher){
				ObjectMapper mapper = new ObjectMapper();
				String studentListString = mapper.writeValueAsString(teacher);
				response.getWriter().write(studentListString);
			} 
		}else if(type.equals("a")){
			Admin admin = userService.getAdminById(id);
			session.setAttribute("updateUser", admin);
			if(null!=admin){
				ObjectMapper mapper = new ObjectMapper();
				String studentListString = mapper.writeValueAsString(admin);
				response.getWriter().write(studentListString);
			}
		}
	}
	@RequestMapping(value={"/studentUpdate.action"},method={RequestMethod.POST})
	public String studentUpdate(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String username2 = request.getParameter("username2");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		String subject = request.getParameter("subject");
		String qnum = request.getParameter("qnum");
		String url = null;
		Student student = (Student) session.getAttribute("updateUser");
		if(student != null){
			String s_num = student.getS_num();
			if((student.getS_mobile()).equals(mobile)){
				if((student.getS_email()).equals(email)){
					boolean result = userService.studentUpdate(s_num,username,username2,sex,mobile,email,school,subject,qnum);
					if(result){
						session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
						url = "redirect:/student-list.jsp";
					}
					else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
						url = "redirect:/student-list.jsp";
					}
				}else{
					boolean emailResult = userService.checkStudentEmail(email);
					if(emailResult){
						boolean result = userService.studentUpdate(s_num,username,username2,sex,mobile,email,school,subject,qnum);
						if(result){
							session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
							url = "redirect:/student-list.jsp";
						}
						else{
							session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
							url = "redirect:/student-list.jsp";
						}
					}else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_EAMILNUMAGIN);
						url = "redirect:/student-list.jsp";
					}
				}
			}else{
				boolean falg = userService.checkStudentMobile(mobile);
				if(falg){
					boolean emailResult = userService.checkStudentEmail(email);
					if(emailResult){
						boolean result = userService.studentUpdate(s_num,username,username2,sex,mobile,email,school,subject,qnum);
						if(result){
							session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
							url = "redirect:/student-list.jsp";
						}
						else{
							session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
							url = "redirect:/student-list.jsp";
						}
					}else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_EAMILNUMAGIN);
						url = "redirect:/student-list.jsp";
					}
				}else{
					session.setAttribute("addmsg", Contant.UPDATEUSER_PHONENUMAGIN);
					url = "redirect:/student-list.jsp";
				}
			}
		}
		return url;
	}
	@RequestMapping(value={"/teacherUpdate.action"},method={RequestMethod.POST})
	public String teacherUpdate(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String username2 = request.getParameter("username2");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		String subject = request.getParameter("subject");
		String qnum = request.getParameter("qnum");
		String url = null;
		Teacher teacher = (Teacher) session.getAttribute("updateUser");
		if(teacher != null){
			String t_num = teacher.getT_num();
			if((teacher.getT_mobile()).equals(mobile)){
				if((teacher.getT_email()).equals(email)){
					boolean result = userService.teacherUpdate(t_num,username,username2,sex,mobile,email,school,subject,qnum);
					if(result){
						session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
						url = "redirect:/teacher-list.jsp";
					}
					else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
						url = "redirect:/teacher-list.jsp";
					}
				}else{
					boolean emailResult = userService.checkTeacherEmail(email);
					if(emailResult){
						boolean result = userService.teacherUpdate(t_num,username,username2,sex,mobile,email,school,subject,qnum);
						if(result){
							session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
							url = "redirect:/teacher-list.jsp";
						}
						else{
							session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
							url = "redirect:/teacher-list.jsp";
						}
					}else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_EAMILNUMAGIN);
						url = "redirect:/teacher-list.jsp";
					}
				}
			}else{
				boolean falg = userService.checkTeacherMobile(mobile);
				if(falg){
					boolean emailResult = userService.checkTeacherEmail(email);
					if(emailResult){
						boolean result = userService.teacherUpdate(t_num,username,username2,sex,mobile,email,school,subject,qnum);
						if(result){
							session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
							url = "redirect:/teacher-list.jsp";
						}
						else{
							session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
							url = "redirect:/teacher-list.jsp";
						}
					}else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_EAMILNUMAGIN);
						url = "redirect:/teacher-list.jsp";
					}
				}else{
					session.setAttribute("addmsg", Contant.UPDATEUSER_PHONENUMAGIN);
					url = "redirect:/teacher-list.jsp";
				}
			}
		}
		return url;
	}
	@RequestMapping(value={"/adminUpdate.action"},method={RequestMethod.POST})
	public String adminUpdate(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String username2 = request.getParameter("username2");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		String subject = request.getParameter("subject");
		String qnum = request.getParameter("qnum");
		String url = null;
		Admin admin = (Admin) session.getAttribute("updateUser");
		if(admin != null){
			String a_num = admin.getA_num();
			if((admin.getA_mobile()).equals(mobile)){
				if((admin.getA_email()).equals(email)){
					boolean result = userService.adminUpdate(a_num,username,username2,sex,mobile,email,school,subject,qnum);
					if(result){
						session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
						url = "redirect:/admin-list.jsp";
					}
					else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
						url = "redirect:/admin-list.jsp";
					}
				}else{
					boolean emailResult = userService.checkAdminEmail(email);
					if(emailResult){
						boolean result = userService.adminUpdate(a_num,username,username2,sex,mobile,email,school,subject,qnum);
						if(result){
							session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
							url = "redirect:/admin-list.jsp";
						}
						else{
							session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
							url = "redirect:/admin-list.jsp";
						}
					}else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_EAMILNUMAGIN);
						url = "redirect:/admin-list.jsp";
					}
				}
			}else{
				boolean falg = userService.checkAdminMobile(mobile);
				if(falg){
					boolean emailResult = userService.checkAdminEmail(email);
					if(emailResult){
						boolean result = userService.adminUpdate(a_num,username,username2,sex,mobile,email,school,subject,qnum);
						if(result){
							session.setAttribute("addmsg", Contant.UPDATEUSER_SUCESS);
							url = "redirect:/admin-list.jsp";
						}
						else{
							session.setAttribute("addmsg", Contant.UPDATEUSER_FAILD);
							url = "redirect:/admin-list.jsp";
						}
					}else{
						session.setAttribute("addmsg", Contant.UPDATEUSER_EAMILNUMAGIN);
						url = "redirect:/admin-list.jsp";
					}
				}else{
					session.setAttribute("addmsg", Contant.UPDATEUSER_PHONENUMAGIN);
					url = "redirect:/admin-list.jsp";
				}
			}
		}
		return url;
	}
	@RequestMapping(value={"/resetPwd.action"},method={RequestMethod.POST})
	@ResponseBody
	public void resetPwd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		boolean falg = false;
		Map<String,String> map = new HashMap<>();
		if(type.equals("s")){
			falg = userService.resetStudentPwd(id);
			if(falg){
				map.put("message", Contant.RESETPASS_SUCESS);
			}else{
				map.put("message", Contant.RESETPASS_FAILD);
			}
		}else if(type.equals("t")){
			falg = userService.resetTeacherPwd(id);
			if(falg){
				map.put("message", Contant.RESETPASS_SUCESS);
			}else{
				map.put("message", Contant.RESETPASS_FAILD);
			}
		}else if(type.equals("a")){
			falg = userService.resetAdminPwd(id);
			if(falg){
				map.put("message", Contant.RESETPASS_SUCESS);
			}else{
				map.put("message", Contant.RESETPASS_FAILD);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = mapper.writeValueAsString(map);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/statusUser.action"},method={RequestMethod.POST})
	@ResponseBody
	public void statusUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String state = request.getParameter("state");
		boolean falg = false;
		Map<String,String> map = new HashMap<>();
		if(type.equals("s")){
			falg = userService.statusStudent(id,state);
			if(falg){
				map.put("message", Contant.STATUSUSER_SUCESS);
			}else{
				map.put("message", Contant.STATUSUSER_FAILD);
			}
		}else if(type.equals("t")){
			falg = userService.statusTeacher(id,state);
			if(falg){
				map.put("message", Contant.STATUSUSER_SUCESS);
			}else{
				map.put("message", Contant.STATUSUSER_FAILD);
			}
		}else if(type.equals("a")){
			falg = userService.statusAdmin(id,state);
			if(falg){
				map.put("message", Contant.STATUSUSER_SUCESS);
			}else{
				map.put("message", Contant.STATUSUSER_FAILD);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = mapper.writeValueAsString(map);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/getAllTeacher.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getAllTeacher(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		List<Teacher> AllTeacherCount=userService.getAllTeacher();
		session.removeAttribute("AllTeacherCount");
		session.setAttribute("AllTeacherCount", AllTeacherCount);
	}
	@RequestMapping(value="/getCountOfUser.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getCountOfUser() throws Exception{
		Map<String,Object> getCountofUser = new HashMap<>(); 
		getCountofUser.put("studentcount", userService.getCountofStudent());
		getCountofUser.put("teachercount", userService.getCountofTeacher());
		getCountofUser.put("coursecount", userService.getCountofCourse());
		getCountofUser.put("bookcount", userService.getCountofBook());
		return getCountofUser;
	}
	@RequestMapping(value={"/courseAdd.action"},method={RequestMethod.POST})
	public String courseAdd(HttpServletRequest request,MultipartFile file) throws Exception{
		HttpSession session=request.getSession();
		Admin admin = (Admin)session.getAttribute("loginuser");
		String num = admin.getA_num();
		String coursename = request.getParameter("coursename");
		String courseind = request.getParameter("courseind");
		String coursestate = request.getParameter("coursestate");
		String courseteacher = request.getParameter("courseteacher");
		String courseopri = request.getParameter("courseopri");
		String coursenpri = request.getParameter("coursenpri");
		String courseplan = request.getParameter("courseplan");
		String path = "/yxhStudyfile/course/img/";
		/**
		 * 上传图片操作
		 */
		//图片上传成功后，将图片的地址写到数据库
		if(file !=null){
			String filePath = "D:\\workspase\\bishefile\\course\\img\\";//保存图片的路径,tomcat中有配置
			//获取原始图片的名称
	        String originalFilename = file.getOriginalFilename();
	        //获取图片的类型
	        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
	        if(fileType.equals(".jpg")){
	        	//新图片的名称
	        	String newFileName = UUID.randomUUID() + fileType;
	        	//新图片
	        	File newFile = new File(filePath+newFileName);
	        	//将内存中的数据写入磁盘
	        	file.transferTo(newFile);
	        	path = path+newFileName;
	 			boolean result = userService.courseAdd(coursename,courseind,coursestate,courseteacher,courseopri,coursenpri,courseplan,path,num);
	 			if(result){
	 				session.setAttribute("addmsg", Contant.ADDCOURSE_SUCESS);
	 			}
	 			else{
	 				session.setAttribute("addmsg", Contant.ADDCOURSE_FAILD);
	 			}
	        }else{
	        	session.setAttribute("addmsg", Contant.ADDCOURSE_WRONGTYPE);
	        }
	       
		}else{
			session.setAttribute("addmsg", Contant.ADDCOURSE_FILENULL);
		}
		
		return "redirect:/course-add.jsp";
	}
	@RequestMapping(value={"/courseAddTeacher.action"},method={RequestMethod.POST})
	public String courseAddTeacher(HttpServletRequest request,MultipartFile file) throws Exception{
		HttpSession session=request.getSession();
		Teacher Teacher = (Teacher)session.getAttribute("loginuser");
		String coursename = request.getParameter("coursename");
		String courseind = request.getParameter("courseind");
		String coursestate = request.getParameter("coursestate");
		String courseteacher = Teacher.getT_num();
		String courseopri = request.getParameter("courseopri");
		String coursenpri = request.getParameter("coursenpri");
		String courseplan = request.getParameter("courseplan");
		String path = "/yxhStudyfile/course/img/";
		/**
		 * 上传图片操作
		 */
		//图片上传成功后，将图片的地址写到数据库
		if(file !=null){
			String filePath = "D:\\workspase\\bishefile\\course\\img\\";//保存图片的路径,tomcat中有配置
			//获取原始图片的名称
	        String originalFilename = file.getOriginalFilename();
	        //获取图片的类型
	        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
	        if(fileType.equals(".jpg")){
	        	//新图片的名称
	        	String newFileName = UUID.randomUUID() + fileType;
	        	//新图片
	        	File newFile = new File(filePath+newFileName);
	        	//将内存中的数据写入磁盘
	        	file.transferTo(newFile);
	        	path = path+newFileName;
	 			boolean result = userService.courseAddTeacher(coursename,courseind,coursestate,courseteacher,courseopri,coursenpri,courseplan,path);
	 			if(result){
	 				session.setAttribute("addmsg", Contant.ADDCOURSE_SUCESS);
	 			}
	 			else{
	 				session.setAttribute("addmsg", Contant.ADDCOURSE_FAILD);
	 			}
	        }else{
	        	session.setAttribute("addmsg", Contant.ADDCOURSE_WRONGTYPE);
	        }
	       
		}else{
			session.setAttribute("addmsg", Contant.ADDCOURSE_FILENULL);
		}
		
		return "redirect:/course-add-teacher.jsp";
	}
	@RequestMapping(value={"/getSuggestionList.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getSuggestionList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Suggestion> AllCourselist=userService.getSuggestionList();
		DataTablePageUtil<Suggestion> data = new DataTablePageUtil<Suggestion>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
	@RequestMapping(value={"/statusCourse.action"},method={RequestMethod.POST})
	@ResponseBody
	public void statusCourse(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		boolean falg = false;
		Map<String,String> map = new HashMap<>();
		falg = userService.statusCourse(id,state);
		if(falg){
			map.put("message", Contant.STATUSUSER_SUCESS);
		}else{
			map.put("message", Contant.STATUSUSER_FAILD);
		}
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = mapper.writeValueAsString(map);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/statusVideo.action"},method={RequestMethod.POST})
	@ResponseBody
	public void statusVideo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		boolean falg = false;
		Map<String,String> map = new HashMap<>();
		falg = userService.statusVideo(id,state);
		if(falg){
			map.put("message", Contant.STATUSUSER_SUCESS);
		}else{
			map.put("message", Contant.STATUSUSER_FAILD);
		}
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = mapper.writeValueAsString(map);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/statusBook.action"},method={RequestMethod.POST})
	@ResponseBody
	public void statusBook(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		boolean falg = false;
		Map<String,String> map = new HashMap<>();
		falg = userService.statusBook(id,state);
		if(falg){
			map.put("message", Contant.STATUSUSER_SUCESS);
		}else{
			map.put("message", Contant.STATUSUSER_FAILD);
		}
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = mapper.writeValueAsString(map);
		response.getWriter().write(driverListString);
	}
	@RequestMapping(value={"/getCourseById.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getCourseById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		session.removeAttribute("updateCourse");
		Course course = userService.getCourseById(id);
		session.setAttribute("updateCourse", course);
		if(null!=course){
			ObjectMapper mapper = new ObjectMapper();
			String studentListString = mapper.writeValueAsString(course);
			response.getWriter().write(studentListString);
		}
	}
	@RequestMapping(value={"/courseUpdate.action"},method={RequestMethod.POST})
	public String courseUpdate(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Course course = (Course)session.getAttribute("updateCourse");
		String coursenum = course.getC_num();
		String coursename = request.getParameter("coursename");
		String courseind = request.getParameter("courseind");
		String coursestate = request.getParameter("coursestate");
		String courseopri = request.getParameter("courseopri");
		String coursenpri = request.getParameter("coursenpri");
		String courseplan = request.getParameter("courseplan");
		Admin admin = (Admin)session.getAttribute("loginuser");
		String url = "";
		boolean result = false;
		if(admin!=null){
			String num = admin.getA_num();
			result = userService.courseUpdate(coursenum,coursename,courseind,coursestate,courseopri,coursenpri,courseplan,num);
			url = "redirect:/course-list.jsp";
		}else{
			result = userService.courseUpdateTeacher(coursenum,coursename,courseind,coursestate,courseopri,coursenpri,courseplan);
			url = "redirect:/course-list-teacher.jsp";
		}
		if(result){
			session.setAttribute("addmsg", Contant.UPDATECOURSE_SUCESS);
		}
		else{
			session.setAttribute("addmsg", Contant.UPDATECOURSE_FAILD);
		}
		
		return url;
	}
	@RequestMapping(value={"/editCourseImg.action"},method={RequestMethod.POST})
	public String editCourseImg(HttpServletRequest request,MultipartFile file) throws Exception{
		HttpSession session=request.getSession();
		Course course = (Course)session.getAttribute("updateCourse");
		String coursenum = course.getC_num();
		String path = "/yxhStudyfile/course/img/";
		String url = "";
		/**
		 * 上传图片操作
		 */
		//图片上传成功后，将图片的地址写到数据库
		if(file !=null){
			String filePath = "D:\\workspase\\bishefile\\course\\img\\";//保存图片的路径,tomcat中有配置
			//获取原始图片的名称
	        String originalFilename = file.getOriginalFilename();
	        //获取图片的类型
	        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
	        if(fileType.equals(".jpg")){
	        	//新图片的名称
	        	String newFileName = UUID.randomUUID() + fileType;
	        	//新图片
	        	File newFile = new File(filePath+newFileName);
	        	//将内存中的数据写入磁盘
	        	file.transferTo(newFile);
	        	path = path+newFileName;
	        	boolean result = false;
	        	Admin admin = (Admin)session.getAttribute("loginuser");
	    		if(admin!=null){
	    			String num = admin.getA_num();
	    			result = userService.editCourseImg(num,coursenum,path);
	    			url = "redirect:/course-list.jsp";
	    		}else{
	    			result = userService.editCourseImgTeacher(coursenum,path);
	    			url = "redirect:/course-list-teacher.jsp";
	    		}
	 			if(result){
	 				session.setAttribute("addmsg", Contant.ADDCOURSE_SUCESS);
	 			}
	 			else{
	 				session.setAttribute("addmsg", Contant.ADDCOURSE_FAILD);
	 			}
	        }else{
	        	session.setAttribute("addmsg", Contant.ADDCOURSE_WRONGTYPE);
	        }
	       
		}else{
			session.setAttribute("addmsg", Contant.ADDCOURSE_FILENULL);
		}
		
		return url;
	}
	@RequestMapping(value={"/addCourseVideo.action"},method={RequestMethod.POST})
	public String addCourseVideo(HttpServletRequest request,MultipartFile file) throws Exception{
		HttpSession session=request.getSession();
		Course course = (Course)session.getAttribute("updateCourse");
		String coursenum = course.getC_num();
		String coursetnum = course.getT_num();
		String videoname = request.getParameter("videoname");
		String videomessage = request.getParameter("videomessage");
		String path = "/yxhStudyfile/course/video/";
		String url = "";
		/**
		 * 上传图片操作
		 */
		//图片上传成功后，将图片的地址写到数据库
		if(file !=null){
			String filePath = "D:\\workspase\\bishefile\\course\\video\\";//保存图片的路径,tomcat中有配置
			//获取原始图片的名称
	        String originalFilename = file.getOriginalFilename();
	        //获取图片的类型
	        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
	        if(fileType.equals(".mp4")){
	        	//新图片的名称
	        	String newFileName = UUID.randomUUID() + fileType;
	        	//新图片
	        	File newFile = new File(filePath+newFileName);
	        	//将内存中的数据写入磁盘
	        	file.transferTo(newFile);
	        	path = path+newFileName;
	        	boolean result = false;
	        	Admin admin = (Admin)session.getAttribute("loginuser");
	        	if(admin!=null){
	        		String num = admin.getA_num();
		 			result = userService.addCourseVideo(num,coursenum,coursetnum,videoname,videomessage,path);
		 			url = "redirect:/course-list.jsp";
	        	}else{
	        		result = userService.addCourseVideoTeacher(coursenum,coursetnum,videoname,videomessage,path);
	        		url = "redirect:/course-list-teacher.jsp";
	        	}
	    		
	 			if(result){
	 				session.setAttribute("addmsg", Contant.ADDVIDEO_SUCESS);
	 			}
	 			else{
	 				session.setAttribute("addmsg", Contant.ADDVIDEO_FAILD);
	 			}
	        }else{
	        	session.setAttribute("addmsg", Contant.ADDVIDEO_WRONGTYPE);
	        }
	       
		}else{
			session.setAttribute("addmsg", Contant.ADDVIDEO_FILENULL);
		}
		
		return url;
	}
	@RequestMapping(value={"/addCourseBook.action"},method={RequestMethod.POST})
	public String addCourseBook(HttpServletRequest request,MultipartFile file) throws Exception{
		HttpSession session=request.getSession();
		Course course = (Course)session.getAttribute("updateCourse");
		String coursenum = course.getC_num();
		String coursetnum = course.getT_num();
		String videoname = request.getParameter("bookname");
		String path = "/yxhStudyfile/course/book/";
		String url = "";
		/**
		 * 上传图片操作
		 */
		//图片上传成功后，将图片的地址写到数据库
		if(file !=null){
			String filePath = "D:\\workspase\\bishefile\\course\\book\\";//保存图片的路径,tomcat中有配置
			//获取原始图片的名称
	        String originalFilename = file.getOriginalFilename();
	        //获取图片的类型
	        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        	//新图片的名称
        	String newFileName = UUID.randomUUID() + fileType;
        	//新图片
        	File newFile = new File(filePath+newFileName);
        	//将内存中的数据写入磁盘
        	file.transferTo(newFile);
        	path = path+newFileName;
        	boolean result = false;
        	Admin admin = (Admin)session.getAttribute("loginuser");
        	if(admin!=null){
        		String num = admin.getA_num();
	 			result = userService.addCourseBook(num,coursenum,coursetnum,videoname,path);
	 			url = "redirect:/course-list.jsp";
        	}else{
        		result = userService.addCourseBookTeacher(coursenum,coursetnum,videoname,path);
        		url = "redirect:/course-list-teacher.jsp";
        	}
    		
 			if(result){
 				session.setAttribute("addmsg", Contant.ADDBOOK_SUCESS);
 			}
 			else{
 				session.setAttribute("addmsg", Contant.ADDBOOK_FAILD);
 			}
	       
		}else{
			session.setAttribute("addmsg", Contant.ADDBOOK_FILENULL);
		}
		
		return url;
	}
	@RequestMapping(value={"/getVideoList.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getVideoList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Video> AllCourselist=userService.getAllVideo();
		DataTablePageUtil<Video> data = new DataTablePageUtil<Video>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
	@RequestMapping(value={"/getBookList.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getBookList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Book> AllCourselist=userService.getAllBook();
		DataTablePageUtil<Book> data = new DataTablePageUtil<Book>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
	@RequestMapping(value={"/getVideoListTeacher.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getVideoListTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("loginuser");
		String num = teacher.getT_num();
		List<Video> AllCourselist=userService.getAllVideoTeacher(num);
		DataTablePageUtil<Video> data = new DataTablePageUtil<Video>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
	@RequestMapping(value={"/getBookListTeacher.action"},method={RequestMethod.POST})
	@ResponseBody
	public void getBookListTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("loginuser");
		String num = teacher.getT_num();
		List<Book> AllCourselist=userService.getAllBookTeacher(num);
		DataTablePageUtil<Book> data = new DataTablePageUtil<Book>();
		data.setData(AllCourselist);
		ObjectMapper mapper = new ObjectMapper();
		String driverListString = null;
		driverListString = mapper.writeValueAsString(data);
		response.getWriter().write(driverListString); 
	}
}
