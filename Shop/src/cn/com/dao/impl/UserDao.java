package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import cn.com.bean.User;
import cn.com.dao.IUserDao;
import cn.com.util.DbUtil;
import cn.com.util.myDbutil;

public class UserDao implements IUserDao {

	public boolean addUserDao(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUserDao(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUserDao(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserDao(User user) {
		User user1 = null;
		// 条件<=>参数
		List<Object> params = new ArrayList<Object>();
		//动态sql语句拼接
		String sql = "select * from userinfo where 1=1";
		if (user.getId() != 0) {
			sql += " and userid=? ";
			params.add(user.getId());
		}
		if (user.getName() != null) {
			sql += " and username=? ";
			params.add(user.getName());
		}
		if (user.getPwd() != null) {
			sql += " and userpwd=? ";
			params.add(user.getPwd());
		}
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				user1 = new User();
				user1.setId(rs.getInt("userid"));
				user1.setName(rs.getString("username"));
				user1.setPwd(rs.getString("userpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}

	public List<User> getAllUserDao() {
		List<User> userinfos = new ArrayList<User>();
		String sql = "select userid,username,userpwd from userinfo";
		ResultSet rs = DbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				User userinfo = new User();
				userinfo.setId(rs.getInt(1));
				userinfo.setName(rs.getString(2));
				userinfo.setPwd(rs.getString(3));
				userinfos.add(userinfo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userinfos;
	}

}
