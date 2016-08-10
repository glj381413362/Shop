package cn.com.util;


import java.util.*;
import java.util.Date;
import java.sql.*;


public class myDbutil {
	private static Connection con = null;// 连接对象
	private static PreparedStatement pmst = null;// 预编译对象
	private static ResultSet res = null;// 结果集


	/**
	 * 获取联接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql:///shop?characterEncoding=utf-8", "root",
					"950618");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 返回受影响的行数
	 * 
	 * @param pmst
	 * @return int
	 */
	public static int executeUpdate(String sql, Object[] parameters) {
		int count = 0;
		try {
			con = getConnection();
			pmst = con.prepareStatement(sql);
			bindParameters(pmst, parameters);
			count = pmst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Dbutil.closeAll();
		}
		return count;
	}

	/**
	 * 返回结果集
	 * 
	 * @param pmst
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, Object[] parameters) {
		try {
			con = getConnection();
			pmst = con.prepareStatement(sql);
			bindParameters(pmst, parameters);
			res = pmst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// closeAll();
		}
		return res;
	}

	/*
	 * 关闭资源
	 */
	public static void closeAll() {

		try {
			if (con != null) {
				con.close();
			}
			if (pmst != null) {
				pmst.close();
			}
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 绑定参数
	 * 
	 * @param pmst
	 *            预编译对象
	 * @param parameters
	 *            参数数组
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void bindParameters(PreparedStatement pmst,
			Object[] parameters) throws NumberFormatException, SQLException {
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				if (parameters[i].getClass().equals(Integer.class)) {
					pmst.setInt(i + 1,
							Integer.parseInt(parameters[i].toString()));
				}
				if (parameters[i].getClass().equals(String.class)) {
					pmst.setString(i + 1, parameters[i].toString());
				}
				if (parameters[i].getClass().equals(Double.class)) {
					pmst.setDouble(i + 1,
							Double.parseDouble(parameters[i].toString()));
				}
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(con);
	}
}
