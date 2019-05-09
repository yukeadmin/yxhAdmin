package com.yxh.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Course {
	private String c_num;
	private String t_num;
	private String t_name;
	private String c_name;
	private String c_ind;//课程简介
	private String c_plan;
	private String c_img;
	private MultipartFile file;  
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date c_create;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date c_update;
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	private int page2;
	public int getPage2() {
		return page2;
	}
	public void setPage2(int page2) {
		this.page2 = page2;
	}
	private double c_opri;//原价
	private double c_npri;//现价
	private String c_state;
	private String c_cadmin;//创建人
	private String c_uadmin;//修改人
	private double c_occupied;
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getT_num() {
		return t_num;
	}
	public void setT_num(String t_num) {
		this.t_num = t_num;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_ind() {
		return c_ind;
	}
	public void setC_ind(String c_ind) {
		this.c_ind = c_ind;
	}
	public String getC_plan() {
		return c_plan;
	}
	public void setC_plan(String c_plan) {
		this.c_plan = c_plan;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public Date getC_create() {
		return c_create;
	}
	public void setC_create(Date c_create) {
		this.c_create = c_create;
	}
	public Date getC_update() {
		return c_update;
	}
	public void setC_update(Date c_update) {
		this.c_update = c_update;
	}
	public double getC_opri() {
		return c_opri;
	}
	public void setC_opri(double c_opri) {
		this.c_opri = c_opri;
	}
	public double getC_npri() {
		return c_npri;
	}
	public void setC_npri(double c_npri) {
		this.c_npri = c_npri;
	}
	public String getC_state() {
		return c_state;
	}
	public void setC_state(String c_state) {
		this.c_state = c_state;
	}
	public String getC_cadmin() {
		return c_cadmin;
	}
	public void setC_cadmin(String c_cadmin) {
		this.c_cadmin = c_cadmin;
	}
	public String getC_uadmin() {
		return c_uadmin;
	}
	public void setC_uadmin(String c_uadmin) {
		this.c_uadmin = c_uadmin;
	}
	public double getC_occupied() {
		return c_occupied;
	}
	public void setC_occupied(double c_occupied) {
		this.c_occupied = c_occupied;
	} 
	
	
}
