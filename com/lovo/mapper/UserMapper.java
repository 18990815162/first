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
	  * @return ��ѯ�����е��û�����������ʾ�ڱ����
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
	  * @param userNameģ����ѯ�Ĳ���
	  * @return ���ݲ�������ѯ�����Ľ��
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
	  * @param user Ҫ��ӵ��û���������Ϣ ��װ�����ʵ��bean����
	  */
	 @Insert("insert into t_user values (null,#{userName},#{userPwd},#{userEmail},#{userPhone})")
	 public void addUser(UserBean user);
	 /**
	  * 
	  * @param userName�û�������˻���
	  * @param userPwd�û����������
	  * @return �������ƥ��Ķ���
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
	  * @param userId����id����ʾ�޸�ҳ��ͻ���ԭ����
	  * @return �õ�����һ���������û�����
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
	  * @param userEmail�޸ĺ�������ֵ
	  * @param userPhone�޸ĺ�ĵ绰��ֵ
	  * @param userNameҪ�޸ĵĶ��������
	  */
	 @Update("update t_user set user_email = #{userEmail},user_phone = #{userPhone} where user_name = #{userName}")
	 public void updateUser(@Param("userEmail")String userEmail,@Param("userPhone")String userPhone,@Param("userName")String userName);
	 /**
	  * 
	  * @param userId���ݴ��ݹ�����userId��ɾ��ָ���Ķ���
	  */
	 @Delete("delete from t_user where user_id = #{userId}")
	 public void delete(@Param("userId")int userId);
	 /**
	  * 
	  * @param pageBean��ҳ��ʵ��������������ҳ����Ҫ����������
	  * @param userNameģ����ѯ��ҳ������
	  * @return ���ص���ָ��������ģ����ѯ�Ľ��
	  */
	 public List<UserBean> findAllUserByPage(@Param("pageBean")PageBean pageBean,@Param("userName")String userName);
	 
	 public int findUserNumsByPage(@Param("userName")String userName);
	
}
