package cn.com.server.impl;

import java.util.List;

import cn.com.bean.User;
import cn.com.dao.IUserDao;
import cn.com.dao.impl.UserDao;
import cn.com.server.IUserServer;

public class UserServer implements IUserServer {

	public boolean addUserServer(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUserServer(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUserServer(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserServer(User user) {
		// TODO Auto-generated method stub
          IUserDao userDao = new UserDao();
		return userDao.getUserDao(user);
	}

	public List<User> getAllUserServer() {
		// TODO Auto-generated method stub
		return null;
	}

}
