package dao.imp;


import dao.UserDao;
import dao.bean.User;
import dao.mapper.UserMapper;
import dao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImp implements UserDao {
	//类属性：数据库会话对象
	SqlSession sqlSession = MyBatisUtil.getSqlSession();
	//类属性：映射器接口对象
	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	
	public User queryUserByUsernameAndPassword(String un, String pwd) {
		return mapper.getUserByUsernameAndPassword(un, pwd);
	}

	@Override
	public User queryUserByUsername(String un) {
		return mapper.getUserByUsername(un);
	}

	public boolean isMember(String un, String pwd) {
		User user = mapper.getUserByUsernameAndPassword(un, pwd);
		System.out.println(user);
		if(user!=null)  return true;
		else return false;
		//return mapper.getUserByUsernameAndPassword(un, pwd)==null?false:true;
	}
	
	public List<User> queryAll() {
		return mapper.getAllUsers();
	}

	public User queryOne(String un) {
		return mapper.getUserById(un);
	}

	public int updateUser(User user) {
		int i = mapper.updateUser(user);
		sqlSession.commit(); //必须
		return i;
	}

	public int addUser(User user) {
		int i = mapper.addUser(user);
		sqlSession.commit();  //必须
		return i;
	}
	
	public void deleteUser(User user) {
		mapper.deleteUser(user.getUsername());
		sqlSession.commit();  //必须
	}

}
