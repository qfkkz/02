package service;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.User;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();

	@Override
	public User login(User user) {
		user = ud.getUserByAccountAndPassword(user);
		return user;
	}

	@Override
	public int regist(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

}
