package cn.com.server;

import java.util.List;

import cn.com.bean.User;

public interface IUserServer {

	
		 /**
		  * Server ����Ñ�
		  * @param user
		  * @return boolean
		  */
		public boolean addUserServer(User user);
		/**
		 * Server �h���Ñ�
		 * @param user
		 * @return boolean
		 */
		public boolean deleteUserServer(User user);
		/**
		 * Server �����Ñ�
		 * @param user
		 * @return boolean
		 */
		public boolean updateUserServer(User user);
		/**
		 * Server ����ĳ���Ñ��Ƿ����
		 * @param user
		 * @return
		 */
		public User getUserServer(User user);
		/**
		 * Server ��ԃ���е��Ñ�	
		 * @return
		 */
		public List<User> getAllUserServer();
		
		public List<User> getAllUserDao();

		/**
		 * Server��ѯ�û���¼����
		 * @return
		 */
		public int getAllCountServer();
		
		/**
		 * Server �����û���Ϣ
		 * @param currentpage ��ǰҳ��
		 * @param num ��ǰҳ��¼����
		 * @return
		 */
		public List<User> queryUserServer(int currentpage,int num);
}
