package cn.com.bean;

import java.io.Serializable;

/**
 * ��Ʒ��Ϣ��BuyCardʵ����
 * 
 * @author Administrator
 * 
 */
public class BuyCard implements Serializable {
	private int bid; // ��Ʒ���
	private String bname;// ��Ʒ����
	private double bprice;// ��Ʒ����
	private String binfo;// ��Ʒ������Ϣ
	private String bface;// ��ƷͼƬ·��
	private int bnumber;// ��Ʒ���� 1
	private int cartnum=0;

	public int getCartnum() {
		return cartnum;
	}

	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public double getBprice() {
		return bprice;
	}

	public void setBprice(double bprice) {
		this.bprice = bprice;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	public String getBface() {
		return bface;
	}

	public void setBface(String bface) {
		this.bface = bface;
	}

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

}
