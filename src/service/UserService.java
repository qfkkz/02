package service;

import pojo.User;

public interface UserService {
	// 登陆用户
	public User login(User user);

	// 注册用户
	public int regist(User user);
}
