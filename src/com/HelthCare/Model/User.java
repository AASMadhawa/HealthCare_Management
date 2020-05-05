package com.HelthCare.Model;

public class User {
	
	public int u_id;
	public String u_fname;
	public String u_lname;
	public int u_age;
	public String u_address;
	public String u_sex;
	public String u_email;
	public String u_username;
	public String u_password;
	public String u_type;
	public int u_contact;
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_fname() {
		return u_fname;
	}
	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}
	public String getU_lname() {
		return u_lname;
	}
	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_type() {
		return u_type;
	}
	public void setU_type(String u_type) {
		this.u_type = u_type;
	}
	public int getU_contact() {
		return u_contact;
	}
	public void setU_contact(int u_contact) {
		this.u_contact = u_contact;
	}
	@Override
	public String toString() {
		return "user [u_id=" + u_id + ", u_fname=" + u_fname + ", u_lname=" + u_lname + ", u_age=" + u_age
				+ ", u_address=" + u_address + ", u_sex=" + u_sex + ", u_email=" + u_email + ", u_username="
				+ u_username + ", u_password=" + u_password + ", u_type=" + u_type + ", u_contact=" + u_contact + "]";
	}
	
	
	

}
