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
		if (user.getUserid() != 0) {
			sql += " and userid=? ";
			params.add(user.getUserid());
		}
		if (user.getUsername() != null) {
			sql += " and username=? ";
			params.add(user.getUsername());
		}
		if (user.getUserpwd() != null) {
			sql += " and userpwd=? ";
			params.add(user.getUserpwd());
		}
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				user1 = new User();
				user1.setUserid(rs.getInt("userid"));
				user1.setUsername(rs.getString("username"));
				user1.setUserpwd(rs.getString("userpwd"));
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
				userinfo.setUserid(rs.getInt(1));
				userinfo.setUsername(rs.getString(2));
				userinfo.setUserpwd(rs.getString(3));
				userinfos.add(userinfo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userinfos;
	}

	public int getAllCountDao() {
		// TODO Auto-generated method stub
		String sql = "select count(*) as num from userinfo";
		ResultSet rs = DbUtil.executeQuery(sql, null);
		int nums=0;
		try {
			while(rs.next())
			{
				nums = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nums;
	}

	public List<User> queryUserDao(int currentpage, int num) {
		// TODO Auto-generated method stub
		List<User> userinfos = new ArrayList<User>();
		String sql = "select * from userinfo limit ?,?";
		List<Object> params = new ArrayList<Object>();
		params.add((currentpage-1)*num);
		params.add(num);
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				User userinfo = new User();
				userinfo.setUserid(rs.getInt(1));
				userinfo.setUsername(rs.getString(2));
				userinfo.setUserpwd(rs.getString(3));
				userinfos.add(userinfo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userinfos;
	}

}
