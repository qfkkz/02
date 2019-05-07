package dao;

import pojo.User;

public interface UserDao {
	// 获得用户
	public User getUserByAccountAndPassword(User user);

	// 添加用户
	public int addUser(User user);
}
