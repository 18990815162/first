package com.lovo.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lovo.pojo.PageBean;
import com.lovo.pojo.UserBean;
import com.lovo.service.impl.UserServiceImpl;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
           UserServiceImpl service = (UserServiceImpl) act.getBean("userServiceImpl");
           List<UserBean> list = service.findAllUser();
           System.out.println(list.get(0).getUserName());
         /* PageBean pageBean= new PageBean(); 
          pageBean.setCurrentPage(1);
          pageBean.setPageSize(3);
          String userName = "long";
      List<UserBean> list = service.fenye(pageBean, userName);*/
	}

}
