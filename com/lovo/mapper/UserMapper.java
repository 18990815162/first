package com.lovo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lovo.pojo.PageBean;
import com.lovo.pojo.UserBean;
  
 public interface UserMapper {
	 /**
	  * 
	  * @return 查询出所有的用户对象，用于显示在表格中
	  */
	 @Select("select * from t_user")
	 @Results({
		 @Result(id = true,property = "userId",column = "user_id",javaType = Integer.class),
		   @Result(property = "userName",column = "user_name",javaType = String.class),
		   @Result(property = "userPwd",column = "user_pwd",javaType = String.class),
		   @Result(property = "userEmail",column = "user_email",javaType = String.class),
		   @Result(property = "userPhone",column = "user_phone",javaType = String.class)
	 })
    public List<UserBean> findAllUser();
	 /**
	  * 
	  * @param userName模糊查询的参数
	  * @return 根据参数，查询出来的结果
	  */
	 @Select("select * from t_user where user_name like '%${userName}%'")
	 @Results({
		 @Result(id = true,property = "userId",column = "user_id",javaType = Integer.class),
		   @Result(property = "userName",column = "user_name",javaType = String.class),
		   @Result(property = "userPwd",column = "user_pwd",javaType = String.class),
		   @Result(property = "userEmail",column = "user_email",javaType = String.class),
		   @Result(property = "userPhone",column = "user_phone",javaType = String.class)
	 })
	 public List<UserBean> findUserByName(@Param("userName")String userName);
	 /**
	  * 
	  * @param user 要添加的用户的完整信息 封装在这个实体bean里面
	  */
	 @Insert("insert into t_user values (null,#{userName},#{userPwd},#{userEmail},#{userPhone})")
	 public void addUser(UserBean user);
	 /**
	  * 
	  * @param userName用户输入的账户名
	  * @param userPwd用户输入的密码
	  * @return 返回这个匹配的对象
	  */
	 @Select("select * from t_user where user_name = #{userName} and user_pwd = #{userPwd}")
	  @Results({
		 @Result(id = true,property = "userId",column = "user_id",javaType = Integer.class),
		   @Result(property = "userName",column = "user_name",javaType = String.class),
		   @Result(property = "userPwd",column = "user_pwd",javaType = String.class),
		   @Result(property = "userEmail",column = "user_email",javaType = String.class),
		   @Result(property = "userPhone",column = "user_phone",javaType = String.class)
	 })
	 public UserBean findUserByNameAndPwd(@Param("userName")String userName,@Param("userPwd")String userPwd);
	 /**
	  * 
	  * @param userId根据id来显示修改页面客户的原数据
	  * @return 得到的是一个完整的用户对象
	  */
	 @Select("select * from t_user where user_id = #{userId}")
	 @Results({
		 @Result(id = true,property = "userId",column = "user_id",javaType = Integer.class),
		   @Result(property = "userName",column = "user_name",javaType = String.class),
		   @Result(property = "userPwd",column = "user_pwd",javaType = String.class),
		   @Result(property = "userEmail",column = "user_email",javaType = String.class),
		   @Result(property = "userPhone",column = "user_phone",javaType = String.class)
	 })
	 public UserBean findUserById(@Param("userId")int userId);
	 /**
	  * 
	  * @param userEmail修改后的邮箱的值
	  * @param userPhone修改后的电话的值
	  * @param userName要修改的对象的姓名
	  */
	 @Update("update t_user set user_email = #{userEmail},user_phone = #{userPhone} where user_name = #{userName}")
	 public void updateUser(@Param("userEmail")String userEmail,@Param("userPhone")String userPhone,@Param("userName")String userName);
	 /**
	  * 
	  * @param userId根据传递过来的userId来删除指定的对象
	  */
	 @Delete("delete from t_user where user_id = #{userId}")
	 public void delete(@Param("userId")int userId);
	 /**
	  * 
	  * @param pageBean分页的实体对象，里面包含分页所需要的所有属性
	  * @param userName模糊查询分页的条件
	  * @return 返回的是指定条数的模糊查询的结果
	  */
	 public List<UserBean> findAllUserByPage(@Param("pageBean")PageBean pageBean,@Param("userName")String userName);
	 
	 public int findUserNumsByPage(@Param("userName")String userName);
	
}
