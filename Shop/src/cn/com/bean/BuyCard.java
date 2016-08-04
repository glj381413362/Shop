package cn.com.bean;

import java.io.Serializable;

/**
 * 商品信息表BuyCard实体类
 * 
 * @author Administrator
 * 
 */
public class BuyCard implements Serializable {
	private int bid; // 商品编号
	private String bname;// 商品名称
	private double bprice;// 商品单价
	private String binfo;// 商品描述信息
	private String bface;// 商品图片路径
	private int bnumber;// 商品数量 1
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
