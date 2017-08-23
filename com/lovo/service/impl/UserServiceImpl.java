package com.lovo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lovo.mapper.UserMapper;
import com.lovo.pojo.PageBean;
import com.lovo.pojo.UserBean;
import com.lovo.service.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	  @Resource
     private UserMapper mapper; 
	@Override
	public List<UserBean> findAllUser() {
		// TODO Auto-generated method stub
		return mapper.findAllUser();
	}
	@Override
	public void addUser(UserBean user) {
		mapper.addUser(user);
		
	}
	@Override
	public UserBean login(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return mapper.findUserByNameAndPwd(userName, userPwd);
	}
	@Override
	public List<UserBean> findUserByName(String userName) {
		// TODO Auto-generated method stub
		return mapper.findUserByName(userName);
	}
	@Override
	public UserBean update(int userId) {
		// TODO Auto-generated method stub
		return mapper.findUserById(userId);
	}
	@Override
	public void updateUser(String userEmail, String userPhone, String userName) {
		// TODO Auto-generated method stub
		mapper.updateUser(userEmail, userPhone, userName);
	}
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		mapper.delete(userId);
	}
	@Override
	public List<UserBean> fenye(PageBean pageBean, String userName) {
		// TODO Auto-generated method stub
		return mapper.findAllUserByPage(pageBean, userName);
	}
	@Override
	public int findUserNumsByPage(String userName) {
		// TODO Auto-generated method stub
		return mapper.findUserNumsByPage(userName);
	}

}
