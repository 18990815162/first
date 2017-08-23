package com.lovo.pojo;

import java.io.Serializable;

public class UserBean implements Serializable{
 private Integer userId;
 private String userName;
 private String userPwd;
 private String userEmail;
 private String userPhone;
public UserBean() {
	super();
}
public UserBean(Integer userId, String userName, String userPwd,
		String userEmail, String userPhone) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userPwd = userPwd;
	this.userEmail = userEmail;
	this.userPhone = userPhone;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPwd() {
	return userPwd;
}
public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
}
