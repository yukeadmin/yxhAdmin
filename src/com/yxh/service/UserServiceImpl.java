package com.yxh.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxh.Mapper.UserMapper;
import com.yxh.pojo.Admin;
import com.yxh.pojo.Book;
import com.yxh.pojo.Course;
import com.yxh.pojo.Student;
import com.yxh.pojo.Suggestion;
import com.yxh.pojo.Teacher;
import com.yxh.pojo.Video;
import com.yxh.util.MD5Util;
import com.yxh.util.UUIDTool;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper = null;

	@Override
	public Admin checkAdminLogin(String mobile, String password) throws Exception {
		// TODO Auto-generated method stub
		Map <String,String> map = new HashMap<>();
		String md5password = MD5Util.makePassword(password);
		map.put("mobile",mobile);
		map.put("password", md5password);
		return userMapper.checkAdminLogin(map);
	}
	@Override
	public Teacher checkTeacherLogin(String mobile, String password) throws Exception {
		// TODO Auto-generated method stub
		Map <String,String> map = new HashMap<>();
		String md5password = MD5Util.makePassword(password);
		map.put("mobile",mobile);
		map.put("password", md5password);
		return userMapper.checkTeacherLogin(map);
	}
	@Override
	public List<Student> getStudentList() throws Exception {
		// TODO Auto-generated method stub
		List<Student> studentList = userMapper.getStudentList();
		return studentList;
	}
	@Override
	public List<Teacher> getTeacherList() throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = userMapper.getTeacherList();
		return teacherList;
	}
	@Override
	public List<Admin> getAdminList() throws Exception {
		// TODO Auto-generated method stub
		List<Admin> adminList = userMapper.getAdminList();
		return adminList;
	}
	@Override
	public boolean checkStudentMobile(String mobile) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		boolean result = true;
		count = userMapper.checkStudentMobile(mobile);
		if(count>0){
			result = false;
		}
		return result;
	}
	@Override
	public boolean checkStudentEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		boolean result = true;
		count = userMapper.checkStudentEmail(email);
		if(count>0){
			result = false;
		}
		return result;
	}
	@Override
	public boolean studentAdd(String username,String username2, String sex, String mobile, String email, String school, String subject,String qnum)
			throws Exception {
		// TODO Auto-generated method stub
		String password = MD5Util.makePassword("abc123");
		Student student = new Student();
		student.setS_num(UUIDTool.getUUID());
		student.setS_Fname(username);
		student.setS_name(username2);
		student.setS_sex(sex);
		student.setS_mobile(mobile);
		student.setS_pwd(password);
		student.setS_email(email);
		student.setS_qnum(qnum);
		student.setS_col(school);
		student.setS_sub(subject);
		int Num=new Random().nextInt(10)+1;//获取0-10随机数
		student.setS_img("/yxhStudyfile/personal/img/"+Num+".jpg");
		student.setS_create(new Timestamp (new Date().getTime()));
		student.setS_update(new Timestamp (new Date().getTime()));
		student.setS_state("1");
		int count = 0;
		try {
			count = userMapper.studentAdd(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public Student getStudentById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getStudentById(id);
	}
	@Override
	public Teacher getTeacherById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getTeacherById(id);
	}
	@Override
	public Admin getAdminById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getAdminById(id);
	}
	@Override
	public boolean studentUpdate(String s_num,String username,String username2, String sex, String mobile, String email, String school,
			String subject, String qnum) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setS_num(s_num);
		student.setS_Fname(username);
		student.setS_name(username2);
		student.setS_sex(sex);
		student.setS_mobile(mobile);
		student.setS_email(email);
		student.setS_qnum(qnum);
		student.setS_col(school);
		student.setS_sub(subject);
		student.setS_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.studentUpdate(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean teacherUpdate(String t_num,String username, String username2, String sex, String mobile, String email, String school,
			String subject, String qnum) throws Exception {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setT_num(t_num);
		teacher.setT_Fname(username);
		teacher.setT_name(username2);
		teacher.setT_sex(sex);
		teacher.setT_mobile(mobile);
		teacher.setT_email(email);
		teacher.setT_qnum(qnum);
		teacher.setT_col(school);
		teacher.setT_sub(subject);
		teacher.setT_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.teacherUpdate(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean checkTeacherEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		boolean result = true;
		count = userMapper.checkTeacherEmail(email);
		if(count>0){
			result = false;
		}
		return result;
	}
	@Override
	public boolean checkTeacherMobile(String mobile) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		boolean result = true;
		count = userMapper.checkTeacherMobile(mobile);
		if(count>0){
			result = false;
		}
		return result;
	}
	@Override
	public boolean resetStudentPwd(String id) throws Exception {
		// TODO Auto-generated method stub
		String password = MD5Util.makePassword("abc123");
		Student student = new Student();
		student.setS_num(id);
		student.setS_pwd(password);
		int count = 0;
		boolean result = false;
		count = userMapper.resetStudentPwd(student);
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean resetTeacherPwd(String id) throws Exception {
		// TODO Auto-generated method stub
		String password = MD5Util.makePassword("abc123");
		Teacher teacher = new Teacher();
		teacher.setT_num(id);
		teacher.setT_pwd(password);
		int count = 0;
		boolean result = false;
		count = userMapper.resetTeacherPwd(teacher);
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean resetAdminPwd(String id) throws Exception {
		// TODO Auto-generated method stub
		String password = MD5Util.makePassword("abc123");
		Admin admin = new Admin();
		admin.setA_num(id);
		admin.setA_pwd(password);
		int count = 0;
		boolean result = false;
		count = userMapper.resetAdminPwd(admin);
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean adminUpdate(String a_num,String username, String username2,String sex, String mobile, String email, String school, String subject,
			String qnum) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setA_num(a_num);
		admin.setA_Fname(username);
		admin.setA_name(username2);
		admin.setA_sex(sex);
		admin.setA_mobile(mobile);
		admin.setA_email(email);
		admin.setA_qnum(qnum);
		admin.setA_col(school);
		admin.setA_sub(subject);
		admin.setA_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.adminUpdate(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean checkAdminEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		boolean result = true;
		count = userMapper.checkAdminEmail(email);
		if(count>0){
			result = false;
		}
		return result;
	}
	@Override
	public boolean checkAdminMobile(String mobile) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		boolean result = true;
		count = userMapper.checkAdminMobile(mobile);
		if(count>0){
			result = false;
		}
		return result;
	}
	@Override
	public boolean statusStudent(String id, String state) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setS_num(id);
		student.setS_state(state);
		int count = 0;
		try {
			count = userMapper.statusStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean statusTeacher(String id, String state) throws Exception {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setT_num(id);
		teacher.setT_state(state);
		int count = 0;
		try {
			count = userMapper.statusTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean statusAdmin(String id, String state) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setA_num(id);
		admin.setA_state(state);
		int count = 0;
		try {
			count = userMapper.statusAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean adminAdd(String username, String username2,String sex, String mobile, String email, String school, String subject,
			String qnum) throws Exception {
		// TODO Auto-generated method stub
		String password = MD5Util.makePassword("abc123");
		Admin admin = new Admin();
		admin.setA_num(UUIDTool.getUUID());
		admin.setA_Fname(username);
		admin.setA_name(username2);
		admin.setA_sex(sex);
		admin.setA_mobile(mobile);
		admin.setA_pwd(password);
		admin.setA_email(email);
		admin.setA_qnum(qnum);
		admin.setA_col(school);
		admin.setA_sub(subject);
		int Num=new Random().nextInt(10)+1;//获取0-10随机数
		admin.setA_img("/yxhStudyfile/personal/img/"+Num+".jpg");
		admin.setA_create(new Timestamp (new Date().getTime()));
		admin.setA_update(new Timestamp (new Date().getTime()));
		admin.setA_state("1");
		int count = 0;
		try {
			count = userMapper.adminAdd(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean teacherAdd(String username, String username2, String sex, String mobile, String email, String school, String subject,
			String qnum) {
		// TODO Auto-generated method stub
		String password = MD5Util.makePassword("abc123");
		Teacher teacher = new Teacher();
		teacher.setT_num(UUIDTool.getUUID());
		teacher.setT_Fname(username);
		teacher.setT_name(username2);
		teacher.setT_sex(sex);
		teacher.setT_mobile(mobile);
		teacher.setT_pwd(password);
		teacher.setT_email(email);
		teacher.setT_qnum(qnum);
		teacher.setT_col(school);
		teacher.setT_sub(subject);
		int Num=new Random().nextInt(10)+1;//获取0-10随机数
		teacher.setT_img("/yxhStudyfile/personal/img/"+Num+".jpg");
		teacher.setT_create(new Timestamp (new Date().getTime()));
		teacher.setT_update(new Timestamp (new Date().getTime()));
		teacher.setT_state("1");
		int count = 0;
		try {
			count = userMapper.teacherAdd(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public List<Course> getAllCourse() throws Exception {
		// TODO Auto-generated method stub
		List<Course> courseList = userMapper.getAllCourse();
		return courseList;
	}
	@Override
	public List<Course> getAllCourseTeacher(String t_num) throws Exception {
		// TODO Auto-generated method stub
		List<Course> courseList = userMapper.getAllCourseTeacher(t_num);
		return courseList;
	}
	@Override
	public List<Teacher> getAllTeacher() throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = userMapper.getAllTeacher();
		return teacherList;
	}
	@Override
	public Map<String, Integer> getCountofStudent() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> userMap = new HashMap<>();
		userMap.put("studentcount", userMapper.getCountofStudent());
		userMap.put("daystudentcount", userMapper.getDayCountofStudent());
		return userMap; 
	}
	@Override
	public Map<String, Integer> getCountofTeacher() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> userMap = new HashMap<>();
		userMap.put("teachercount", userMapper.getCountofTeacher());
		userMap.put("dayteachercount", userMapper.getDayCountofTeacher());
		return userMap; 
	}
	@Override
	public Map<String, Integer> getCountofCourse() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> userMap = new HashMap<>();
		userMap.put("coursecount", userMapper.getCountofCourse());
		userMap.put("daycoursecount", userMapper.getDayCountofCourse());
		return userMap; 
	}
	@Override
	public Map<String, Integer> getCountofBook() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> userMap = new HashMap<>();
		userMap.put("bookcount", userMapper.getCountofBook());
		userMap.put("daybookcount", userMapper.getDayCountofBook());
		return userMap; 
	}
	@Override
	public boolean courseAdd(String coursename, String courseind, String coursestate, String courseteacher,
			String courseopri, String coursenpri, String courseplan, String path, String num) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(UUIDTool.getUUID());
		course.setC_name(coursename);
		course.setC_ind(courseind);
		course.setC_state(coursestate);
		course.setT_num(courseteacher);
		course.setC_opri(Double.parseDouble(courseopri));
		course.setC_npri(Double.parseDouble(coursenpri));
		course.setC_plan(courseplan);
		course.setC_img(path);
		course.setC_cadmin(num);
		course.setC_create(new Timestamp (new Date().getTime()));
		course.setC_update(new Timestamp (new Date().getTime()));
		course.setState("1");
		int count = 0;
		try {
			count = userMapper.courseAdd(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean courseAddTeacher(String coursename, String courseind, String coursestate, String courseteacher,
			String courseopri, String coursenpri, String courseplan, String path) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(UUIDTool.getUUID());
		course.setC_name(coursename);
		course.setC_ind(courseind);
		course.setC_state(coursestate);
		course.setT_num(courseteacher);
		course.setC_opri(Double.parseDouble(courseopri));
		course.setC_npri(Double.parseDouble(coursenpri));
		course.setC_plan(courseplan);
		course.setC_img(path);
		course.setC_create(new Timestamp (new Date().getTime()));
		course.setC_update(new Timestamp (new Date().getTime()));
		course.setState("1");
		int count = 0;
		try {
			count = userMapper.courseAddTeacher(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public List<Suggestion> getSuggestionList() throws Exception {
		// TODO Auto-generated method stub
		List<Suggestion> studentList = userMapper.getSuggestionList();
		return studentList;
	}
	@Override
	public boolean statusCourse(String id, String state) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(id);
		course.setState(state);
		int count = 0;
		try {
			count = userMapper.statusCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public Course getCourseById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getCourseById(id);
	}
	@Override
	public boolean courseUpdate(String coursenum,String coursename, String courseind, String coursestate, 
			String courseopri, String coursenpri, String courseplan, String num) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(coursenum);
		course.setC_name(coursename);
		course.setC_ind(courseind);
		course.setC_state(coursestate);
		course.setC_opri(Double.parseDouble(courseopri));
		course.setC_npri(Double.parseDouble(coursenpri));
		course.setC_plan(courseplan);
		course.setC_uadmin(num);
		course.setC_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.courseUpdate(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean editCourseImg(String num, String coursenum, String path) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(coursenum);
		course.setC_img(path);
		course.setC_uadmin(num);
		course.setC_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.editCourseImg(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean addCourseVideo(String num, String coursenum, String coursetnum, String videoname,
			String videomessage, String path) throws Exception {
		// TODO Auto-generated method stub
		Video video = new Video();
		video.setV_num(UUIDTool.getUUID());
		video.setC_num(coursenum);
		video.setT_num(coursetnum);
		video.setV_name(videoname);
		video.setV_img(path);
		video.setV_messag(videoname);
		video.setV_create(new Timestamp (new Date().getTime()));
		video.setV_update(new Timestamp (new Date().getTime()));
		video.setV_type("1");
		int count = 0;
		try {
			count = userMapper.addCourseVideo(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public List<Video> getAllVideo() throws Exception {
		// TODO Auto-generated method stub
		List<Video> courseList = userMapper.getAllVideo();
		return courseList;
	}
	@Override
	public List<Video> getAllVideoTeacher(String num) throws Exception {
		// TODO Auto-generated method stub
		List<Video> courseList = userMapper.getAllVideoTeacher(num);
		return courseList;
	}
	@Override
	public boolean courseUpdateTeacher(String coursenum, String coursename, String courseind, String coursestate,
			String courseopri, String coursenpri, String courseplan) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(coursenum);
		course.setC_name(coursename);
		course.setC_ind(courseind);
		course.setC_state(coursestate);
		course.setC_opri(Double.parseDouble(courseopri));
		course.setC_npri(Double.parseDouble(coursenpri));
		course.setC_plan(courseplan);
		course.setC_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.courseUpdateTeacher(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean editCourseImgTeacher(String coursenum, String path) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setC_num(coursenum);
		course.setC_img(path);
		course.setC_update(new Timestamp (new Date().getTime()));
		int count = 0;
		try {
			count = userMapper.editCourseImgTeacher(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean addCourseVideoTeacher(String coursenum, String coursetnum, String videoname, String videomessage,
			String path) throws Exception {
		// TODO Auto-generated method stub
		Video video = new Video();
		video.setV_num(UUIDTool.getUUID());
		video.setC_num(coursenum);
		video.setT_num(coursetnum);
		video.setV_name(videoname);
		video.setV_img(path);
		video.setV_messag(videoname);
		video.setV_create(new Timestamp (new Date().getTime()));
		video.setV_update(new Timestamp (new Date().getTime()));
		video.setV_type("1");
		int count = 0;
		try {
			count = userMapper.addCourseVideoTeacher(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean statusVideo(String id, String state) throws Exception {
		// TODO Auto-generated method stub
		Video video = new Video();
		video.setV_num(id);
		video.setV_type(state);
		int count = 0;
		try {
			count = userMapper.statusVideo(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean addCourseBook(String num, String coursenum, String coursetnum, String videoname, String path)
			throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setB_num(UUIDTool.getUUID());
		book.setC_num(coursenum);
		book.setT_num(coursetnum);
		book.setB_name(videoname);
		book.setB_loc(path);
		book.setB_crdate(new Timestamp (new Date().getTime()));
		book.setB_update(new Timestamp (new Date().getTime()));
		book.setB_state("1");
		int count = 0;
		try {
			count = userMapper.addCourseBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean addCourseBookTeacher(String coursenum, String coursetnum, String videoname, String path)
			throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setB_num(UUIDTool.getUUID());
		book.setC_num(coursenum);
		book.setT_num(coursetnum);
		book.setB_name(videoname);
		book.setB_loc(path);
		book.setB_crdate(new Timestamp (new Date().getTime()));
		book.setB_update(new Timestamp (new Date().getTime()));
		book.setB_state("1");
		int count = 0;
		try {
			count = userMapper.addCourseBookeacher(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	@Override
	public List<Book> getAllBook() throws Exception {
		// TODO Auto-generated method stub
		List<Book> courseList = userMapper.getAllBook();
		return courseList;
	}
	@Override
	public List<Book> getAllBookTeacher(String num) throws Exception {
		// TODO Auto-generated method stub
		List<Book> courseList = userMapper.getAllBookTeacher(num);
		return courseList;
	}
	@Override
	public boolean statusBook(String id, String state) throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setB_num(id);
		book.setB_state(state);
		int count = 0;
		try {
			count = userMapper.statusBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean result = false;
		if(count>0){
			result = true;
		}
		return result;
	}
	

}
