package com.yxh.Mapper;

import java.util.List;
import java.util.Map;

import com.yxh.pojo.Admin;
import com.yxh.pojo.Book;
import com.yxh.pojo.Course;
import com.yxh.pojo.Student;
import com.yxh.pojo.Suggestion;
import com.yxh.pojo.Teacher;
import com.yxh.pojo.Video;

public interface UserMapper {

	Admin checkAdminLogin(Map<String, String> map) throws Exception;


	Teacher checkTeacherLogin(Map<String, String> map) throws Exception;


	List<Student> getStudentList() throws Exception;


	List<Teacher> getTeacherList() throws Exception;


	List<Admin> getAdminList() throws Exception;


	int checkStudentMobile(String mobile) throws Exception;


	int checkStudentEmail(String email) throws Exception;


	int studentAdd(Student student) throws Exception;


	Student getStudentById(String id) throws Exception;


	Teacher getTeacherById(String id) throws Exception;


	Admin getAdminById(String id) throws Exception;


	int studentUpdate(Student student) throws Exception;


	int teacherUpdate(Teacher teacher) throws Exception;


	int adminUpdate(Admin admin) throws Exception;


	int checkTeacherMobile(String mobile) throws Exception;


	int checkAdminMobile(String mobile) throws Exception;


	int checkTeacherEmail(String email) throws Exception;


	int checkAdminEmail(String email) throws Exception;


	int resetStudentPwd(Student student) throws Exception;


	int resetTeacherPwd(Teacher teacher) throws Exception;


	int resetAdminPwd(Admin admin) throws Exception;


	int statusStudent(Student student) throws Exception;


	int statusTeacher(Teacher teacher) throws Exception;


	int statusAdmin(Admin admin) throws Exception;


	int adminAdd(Admin admin) throws Exception;


	int teacherAdd(Teacher teacher) throws Exception;


	List<Course> getAllCourse() throws Exception;


	List<Course> getAllCourseTeacher(String t_num) throws Exception;


	List<Teacher> getAllTeacher() throws Exception;


	Integer getCountofStudent() throws Exception;


	Integer getDayCountofStudent() throws Exception;


	Integer getCountofTeacher() throws Exception;


	Integer getDayCountofTeacher() throws Exception;


	Integer getCountofCourse() throws Exception;


	Integer getDayCountofCourse() throws Exception;


	Integer getCountofBook() throws Exception;


	Integer getDayCountofBook() throws Exception;


	int courseAdd(Course course) throws Exception;


	int courseAddTeacher(Course course) throws Exception;


	List<Suggestion> getSuggestionList() throws Exception;


	int statusCourse(Course course) throws Exception;


	Course getCourseById(String id) throws Exception;


	int courseUpdate(Course course) throws Exception;


	int editCourseImg(Course course) throws Exception;


	int addCourseVideo(Video video) throws Exception;


	List<Video> getAllVideo() throws Exception;


	List<Video> getAllVideoTeacher(String num) throws Exception;


	int courseUpdateTeacher(Course course) throws Exception;


	int editCourseImgTeacher(Course course) throws Exception;


	int addCourseVideoTeacher(Video video) throws Exception;


	int statusVideo(Video video) throws Exception;


	int addCourseBook(Book book)  throws Exception;


	int addCourseBookeacher(Book book) throws Exception;


	List<Book> getAllBook() throws Exception;


	List<Book> getAllBookTeacher(String num) throws Exception;


	int statusBook(Book book) throws Exception;



}
