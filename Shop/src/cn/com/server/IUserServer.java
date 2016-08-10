package cn.com.server;

import java.util.List;

import cn.com.bean.User;

public interface IUserServer {

	
		 /**
		  * Server 添加用戶
		  * @param user
		  * @return boolean
		  */
		public boolean addUserServer(User user);
		/**
		 * Server 刪除用戶
		 * @param user
		 * @return boolean
		 */
		public boolean deleteUserServer(User user);
		/**
		 * Server 更新用戶
		 * @param user
		 * @return boolean
		 */
		public boolean updateUserServer(User user);
		/**
		 * Server 查找某個用戶是否存在
		 * @param user
		 * @return
		 */
		public User getUserServer(User user);
		/**
		 * Server 查詢所有的用戶	
		 * @return
		 */
		public List<User> getAllUserServer();
		
		public List<User> getAllUserDao();

		/**
		 * Server查询用户记录条数
		 * @return
		 */
		public int getAllCountServer();
		
		/**
		 * Server 返回用户信息
		 * @param currentpage 当前页码
		 * @param num 当前页记录条数
		 * @return
		 */
		public List<User> queryUserServer(int currentpage,int num);
}
