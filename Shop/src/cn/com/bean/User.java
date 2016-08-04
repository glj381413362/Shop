package cn.com.bean;

public class User {
 
	private int userid;
	private String username;
	private String userpwd;
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPwd() {
		return userpwd;
	}
	public void setPwd(String pwd) {
		this.userpwd = pwd;
	}
	public int getId() {
		return userid;
	}
	public void setId(int id) {
		this.userid = id;
	}
	
}
