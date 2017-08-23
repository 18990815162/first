package com.lovo.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.util.HttpSessionMutexListener;


import com.lovo.pojo.User;
import com.lovo.pojo.UserBean;
import com.lovo.service.UserService;
import com.lovo.service.impl.UserServiceImpl;

@Controller
public class UserController {
	 /*ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
	@Resource(name = "userServiceImpl")
	private UserService service;
	@RequestMapping(path = "/regist",method = RequestMethod.POST)
    public String regist(UserBean user){
		/* ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
		 String userPwd = user.getUserPwd();
		 String s=DigestUtils.md5Hex(userPwd);
		 user.setUserPwd(s);
		 service.addUser(user);
		return "jsp/main";//应该是用重定向，不然的话表单会重复提交
    	
    }
	@RequestMapping(path = "/checkEmail",method = RequestMethod.GET)
	 public @ResponseBody void checkEmail(String userEmail,PrintWriter write){
		/* ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
		List<UserBean> list = service.findAllUser();
		String str = "";
		for (UserBean userBean : list) {
			if(userEmail.equals(userBean.getUserEmail())){
				str = "yiyang";
				break;
			}
		}
		 write.print(str);
   	
   }
	
	@RequestMapping(path = "/checkName",method = RequestMethod.GET)
	 public @ResponseBody void checkName(String userName,PrintWriter write){
		/* ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
		List<UserBean> list = service.findAllUser();
		String str = "";
		for (UserBean userBean : list) {
			if(userName.equals(userBean.getUserName())){
				str = "yiyang";
				break;
			}
		}
		 write.print(str);
  	
  }
	
	@RequestMapping(path = "/login",method = RequestMethod.POST)
	public String login(UserBean user,HttpSession session){
		if(session.getAttribute("userBean")!=null){
			return "jsp/main";
		}
		/* ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
	     String userPwd = user.getUserPwd();
		 String s=DigestUtils.md5Hex(userPwd);
		 user.setUserPwd(s);
		 UserBean userBean = null;
		 userBean = service.login(user.getUserName(), user.getUserPwd());
		 if(userBean!=null){
			session.setAttribute("userBean", userBean);
			 return "jsp/main";
			
		 }
		return "jsp/shibai";
		
		
		
	}
	@RequestMapping(path = "/update",method = RequestMethod.GET)
	public String update(HttpServletRequest request,HttpSession session){
		/*ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserBean user = service.update(userId);
		session.setAttribute("user", user);
		return "jsp/update";
		
	}
	@RequestMapping(path = "/upload",method = RequestMethod.POST)
	public void upload(@RequestParam("myFile") CommonsMultipartFile file,HttpServletRequest req){
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		String path=req.getSession().getServletContext().getRealPath("upload");
		System.out.println(path);
		try {
			file.getFileItem().write(new File(path + File.separator + fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/delete",method = RequestMethod.GET)
	public String delete(HttpServletRequest request){
		int userId = Integer.parseInt(request.getParameter("userId"));
		/*ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
	     service.deleteUser(userId);
		return "jsp/main";
		
	}
	@RequestMapping(path = "/deleteAll",method = RequestMethod.GET)
	public String deleteAll(HttpServletRequest request){
		String numbs = request.getParameter("userId");
		String[] userIds = numbs.split(",");
		for (String string : userIds) {
			int userId = Integer.parseInt(string);
			/*ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
		     service.deleteUser(userId);
		}
		return "jsp/main";
		/*ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");
	     service.deleteUser(userId);
		return "jsp/main";*/
		
	}
	@RequestMapping(path = "/userInfo",method = RequestMethod.GET)
	public @ResponseBody List<UserBean> userInfo(String userName){
		/* ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
	     UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");*/
		List<UserBean> list = service.findUserByName(userName);
		return list;
	}
	@RequestMapping(path = "/updateUser",method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request){
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
	     service.updateUser(userEmail, userPhone, userName);
		return "jsp/main";
		
	}
	@RequestMapping(path = "/register3",method = RequestMethod.POST)
	public void register3(User user){
		System.out.println(user.getBirthday());
		System.out.println(user.isMarry());
		return;
	}
}
