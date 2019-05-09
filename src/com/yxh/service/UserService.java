package com.yxh.service;

import java.util.List;
import java.util.Map;

import com.yxh.pojo.Admin;
import com.yxh.pojo.Book;
import com.yxh.pojo.Course;
import com.yxh.pojo.Student;
import com.yxh.pojo.Suggestion;
import com.yxh.pojo.Teacher;
import com.yxh.pojo.Video;

public interface UserService {

	Admin checkAdminLogin(String mobile, String password) throws Exception;

	Teacher checkTeacherLogin(String mobile, String password) throws Exception;

	List<Student> getStudentList() throws Exception;

	List<Teacher> getTeacherList() throws Exception;

	List<Admin> getAdminList() throws Exception;

	boolean checkStudentMobile(String mobile) throws Exception;

	boolean checkStudentEmail(String email) throws Exception;

	boolean studentAdd(String username, String username2, String sex, String mobile, String email, String school, String subject, String qnum) throws Exception;

	Student getStudentById(String id) throws Exception;

	Teacher getTeacherById(String id) throws Exception;

	Admin getAdminById(String id) throws Exception;

	boolean studentUpdate(String s_num,String username, String username2, String sex, String mobile, String email, String school, String subject,
			String qnum ) throws Exception;

	boolean teacherUpdate(String t_num,String username, String username2, String sex, String mobile, String email, String school, String subject,
			String qnum) throws Exception;

	boolean checkTeacherEmail(String email) throws Exception;

	boolean checkTeacherMobile(String mobile) throws Exception;

	boolean resetStudentPwd(String id) throws Exception;

	boolean resetTeacherPwd(String id) throws Exception;

	boolean resetAdminPwd(String id) throws Exception;

	boolean adminUpdate(String a_num,String username, String username2, String sex, String mobile, String email, String school, String subject,
			String qnum) throws Exception;

	boolean checkAdminEmail(String email) throws Exception;

	boolean checkAdminMobile(String mobile) throws Exception;

	boolean statusStudent(String id, String state) throws Exception;

	boolean statusTeacher(String id, String state) throws Exception;

	boolean statusAdmin(String id, String state) throws Exception;

	boolean adminAdd(String username, String username2, String sex, String mobile, String email, String school, String subject,
			String qnum) throws Exception;

	boolean teacherAdd(String username, String username2, String sex, String mobile, String email, String school, String subject,
			String qnum);

	List<Course> getAllCourse() throws Exception;

	List<Course> getAllCourseTeacher(String string) throws Exception;

	List<Teacher> getAllTeacher() throws Exception;

	Map<String,Integer> getCountofStudent() throws Exception;

	Map<String,Integer> getCountofTeacher() throws Exception;

	Map<String,Integer> getCountofCourse() throws Exception;

	Map<String,Integer> getCountofBook() throws Exception;

	boolean courseAdd(String coursename, String courseind, String coursestate, String courseteacher, String courseopri,
			String coursenpri, String courseplan, String path,String num)  throws Exception;

	boolean courseAddTeacher(String coursename, String courseind, String coursestate, String courseteacher,
			String courseopri, String coursenpri, String courseplan, String path) throws Exception;

	List<Suggestion> getSuggestionList() throws Exception;

	boolean statusCourse(String id, String state) throws Exception;

	Course getCourseById(String id) throws Exception;

	boolean courseUpdate(String coursenum,String coursename, String courseind, String coursestate, 
			String courseopri, String coursenpri, String courseplan, String num) throws Exception;

	boolean editCourseImg(String num, String coursenum, String path) throws Exception;

	boolean addCourseVideo(String num, String coursenum, String coursetnum, String videoname, String videomessage,
			String path) throws Exception;

	List<Video> getAllVideo() throws Exception;

	List<Video> getAllVideoTeacher(String num) throws Exception;

	boolean courseUpdateTeacher(String coursenum, String coursename, String courseind, String coursestate,
			String courseopri, String coursenpri, String courseplan) throws Exception;

	boolean editCourseImgTeacher(String coursenum, String path) throws Exception;

	boolean addCourseVideoTeacher(String coursenum, String coursetnum, String videoname, String videomessage,
			String path) throws Exception;

	boolean statusVideo(String id, String state) throws Exception;

	boolean addCourseBook(String num, String coursenum, String coursetnum, String videoname, String path) throws Exception;

	boolean addCourseBookTeacher(String coursenum, String coursetnum, String videoname, String path) throws Exception;

	List<Book> getAllBook() throws Exception;

	List<Book> getAllBookTeacher(String num) throws Exception;

	boolean statusBook(String id, String state) throws Exception;


}
