package com.lovo.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
  private String userName;
  private String userPwd;
  private int userAge;
  private boolean marry;
  private String[] loves;
  private Date birthday;
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
public int getUserAge() {
	return userAge;
}
public void setUserAge(int userAge) {
	this.userAge = userAge;
}
public boolean isMarry() {
	return marry;
}
public void setMarry(boolean marry) {
	this.marry = marry;
}
public String[] getLoves() {
	return loves;
}
public void setLoves(String[] loves) {
	this.loves = loves;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
  
}
