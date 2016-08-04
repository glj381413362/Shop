package cn.com.dao;

import java.util.List;

import cn.com.bean.User;

public interface IUserDao {
 /**
  * Dao ����Ñ�
  * @param user
  * @return boolean
  */
public boolean addUserDao(User user);
/**
 * Dao �h���Ñ�
 * @param user
 * @return boolean
 */
public boolean deleteUserDao(User user);
/**
 * Dao �����Ñ�
 * @param user
 * @return boolean
 */
public boolean updateUserDao(User user);
/**
 * Dao ����ĳ���Ñ��Ƿ����
 * @param user
 * @return
 */
public User getUserDao(User user);
/**
 * Dao ��ԃ���е��Ñ�	
 * @return
 */
public List<User> getAllUserDao();
	
}
