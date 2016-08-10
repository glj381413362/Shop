package cn.com.server.impl;

import java.util.List;

import cn.com.bean.User;
import cn.com.dao.IUserDao;
import cn.com.dao.impl.UserDao;
import cn.com.server.IUserServer;

public class UserServer implements IUserServer {

	private IUserDao userDao = new UserDao();
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

	public List<User> getAllUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAllCountServer() {
		// TODO Auto-generated method stub
		return userDao.getAllCountDao();
	}

	public List<User> queryUserServer(int currentpage, int num) {
		// TODO Auto-generated method stub
		return userDao.queryUserDao(currentpage, num);
	}

}
