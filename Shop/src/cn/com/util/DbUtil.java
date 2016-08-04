package cn.com.util;

import java.sql.*;
import java.util.*;

/**
 * ���ݿ����������
 * 
 * @author Administrator
 * 
 */
public class DbUtil {
	private static Connection con = null;// ���Ӷ���
	private static PreparedStatement psmt = null;// Ԥ�������
	private static ResultSet rs = null;// ���������


	public static Connection getConnetion() {
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

	public static PreparedStatement getPreparedStatement(String sql) {
		con = getConnetion();
		try {
			psmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psmt;
	}

	public static ResultSet getResultSet(String sql) {
		psmt = getPreparedStatement(sql);
		try {
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static int executeUpdate(String sql, List<Object> params) {
		int count = 0;
		psmt = getPreparedStatement(sql);
		bindPramas(psmt, params);
		try {
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseAll();
		}

		return count;
	}

	public static ResultSet executeQuery(String sql, List<Object> params) {
		psmt = getPreparedStatement(sql);
		if (params != null) {
			bindPramas(psmt, params);
		}
		try {
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	

	public static void bindPramas(PreparedStatement psmt, List<Object> params) {
		int index = 0;
		if (params != null) {
			for (Object p : params) {
				try {
					psmt.setObject(index + 1, p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index++;

			}

		}
	}

	public static void CloseAll() {
		try {
			if (con != null) {

				con.close();

			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}