package com.yxh.pojo;

import java.util.Date;

public class Suggestion {
	private String su_num;
	private String su_name;
	private String su_email;
	private String su_occupation;
	private String su_message;
	private Date su_create;
	public String getSu_num() {
		return su_num;
	}
	public void setSu_num(String su_num) {
		this.su_num = su_num;
	}
	public String getSu_name() {
		return su_name;
	}
	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}
	public String getSu_email() {
		return su_email;
	}
	public void setSu_email(String su_email) {
		this.su_email = su_email;
	}
	public String getSu_occupation() {
		return su_occupation;
	}
	public void setSu_occupation(String su_occupation) {
		this.su_occupation = su_occupation;
	}
	public String getSu_message() {
		return su_message;
	}
	public void setSu_message(String su_message) {
		this.su_message = su_message;
	}
	public Date getSu_create() {
		return su_create;
	}
	public void setSu_create(Date su_create) {
		this.su_create = su_create;
	}

}
