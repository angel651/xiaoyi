package service.imp;
/*
 * 
 */

import dao.UserDao;
import dao.bean.User;
import dao.imp.UserDaoImp;
import service.UserService;

import java.util.List;

public class UserServiceImp  implements UserService {
	
	@Override
	public boolean isMember(String un,String pwd) {
		UserDao userDaoImp = new UserDaoImp();
		return userDaoImp.isMember(un, pwd);
	}
	
	@Override
	public User queryUserByUsername(String username) {
		return null;
	}

	@Override
	public User queryUserByUsernameAndPassword(String un, String pwd) {
		UserDao userDaoImp = new UserDaoImp();
		return userDaoImp.queryUserByUsernameAndPassword(un, pwd);
	}

	@Override
	public void updateUser(User user) {
		//this.update(user);
	}

	@Override
	public void saveUser(User user) {
		//this.add(user);
	}

	@Override
	public List<User> queryAll() {
		return null;
	}

	@Override
	public void deleteUser(User user) {
		//this.delete(user);
	}


}
