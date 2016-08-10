package cn.com.dao;

import java.util.List;

import cn.com.bean.User;

public interface IUserDao {
	/**
	 * Dao 添加用戶
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean addUserDao(User user);

	/**
	 * Dao 刪除用戶
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean deleteUserDao(User user);

	/**
	 * Dao 更新用戶
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean updateUserDao(User user);

	/**
	 * Dao 查找某個用戶是否存在
	 * 
	 * @param user
	 * @return
	 */
	public User getUserDao(User user);

	/**
	 * Dao 查詢所有的用戶
	 * 
	 * @return
	 */
	public List<User> getAllUserDao();

	/**
	 * Dao查询用户记录条数
	 * @return
	 */
	public int getAllCountDao();
	
	/**
	 * Dao 返回用户信息
	 * @param currentpage 当前页码
	 * @param num 当前页记录条数
	 * @return
	 */
	public List<User> queryUserDao(int currentpage,int num);
}
