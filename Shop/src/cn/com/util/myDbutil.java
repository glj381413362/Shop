package cn.com.util;


import java.util.*;
import java.util.Date;
import java.sql.*;


public class myDbutil {
	private static Connection con = null;// ���Ӷ���
	private static PreparedStatement pmst = null;// Ԥ�������
	private static ResultSet res = null;// �����


	/**
	 * ��ȡ����
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
	 * ������Ӱ�������
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
	 * ���ؽ����
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
	 * �ر���Դ
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
	 * �󶨲���
	 * 
	 * @param pmst
	 *            Ԥ�������
	 * @param parameters
	 *            ��������
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
