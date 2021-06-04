package dao.mapper;

import dao.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
	
	//查找所有用户，无参
	@Select("select * from user order by password") 
	public List<User> getAllUsers();


	//根据用户名查找 （只有一个参数），应用于用户注册时的用户名查重
	@Select("select * from user where username=#{un}") 
	public User getUserById(String un);
	
	//根据用户名及密码查找（包含多个参数的查询，必须使用@param注解参数）,应用于用户根据用户名及密码的登录
	@Select("select * from user where username=#{un} and password=#{pwd}") 
	public User getUserByUsernameAndPassword(@Param("un") String un, @Param("pwd") String pwd);

	//根据用户名查找
	@Select("select * from user where username=#{un}")
	public User getUserByUsername(String un);

	//下面的增加——删除——修改，均不需要注解参数
	@Insert("insert ignore into user(username,password,realname,age,mobile) values(#{username},#{password},#{realname},#{age},#{mobile})")
	//关键字ignore：忽略主键重复
	public int addUser(User user);

	@Delete("delete from user where username=#{un}")
	public int deleteUser(String username);

	@Update("update user set password=#{password},realname=#{realname},mobile=#{mobile} where username=#{username}")
	public int updateUser(User user);

}

