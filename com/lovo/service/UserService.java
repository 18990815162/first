package com.lovo.service;

import java.util.List;

import com.lovo.pojo.PageBean;
import com.lovo.pojo.UserBean;

public interface UserService {
    public List<UserBean> findAllUser();
    public void addUser(UserBean user);
    public UserBean login(String userName,String userPwd);
    public List<UserBean> findUserByName(String userName);
    public UserBean update(int userId);
    public void updateUser(String userEmail,String userPhone,String userName);
    public void deleteUser(int userId);
    public List<UserBean> fenye(PageBean pageBean,String userName);
    public int findUserNumsByPage(String userName);
}
