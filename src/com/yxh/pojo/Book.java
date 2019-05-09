package com.yxh.pojo;

import java.util.Date;

public class Book {
	
	private String c_num;
	private String b_num;
	private String t_num;
	private String b_name;
	private String c_name;
	private String t_name;
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	private String b_loc;
	private String b_state;
	private Date b_crdate;
	private Date b_update;
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getB_num() {
		return b_num;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public String getT_num() {
		return t_num;
	}
	public void setT_num(String t_num) {
		this.t_num = t_num;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_loc() {
		return b_loc;
	}
	public void setB_loc(String b_loc) {
		this.b_loc = b_loc;
	}
	public String getB_state() {
		return b_state;
	}
	public void setB_state(String b_state) {
		this.b_state = b_state;
	}
	public Date getB_crdate() {
		return b_crdate;
	}
	public void setB_crdate(Date b_crdate) {
		this.b_crdate = b_crdate;
	}
	public Date getB_update() {
		return b_update;
	}
	public void setB_update(Date b_update) {
		this.b_update = b_update;
	}

}
