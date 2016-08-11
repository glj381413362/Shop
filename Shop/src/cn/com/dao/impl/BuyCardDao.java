package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.bean.BuyCard;
import cn.com.bean.User;
import cn.com.dao.IBuyCardDao;
import cn.com.util.DbUtil;

public class BuyCardDao implements IBuyCardDao {

	/**
	 * 获得所有商品信息
	 * 
	 */
	public List<BuyCard> getAllBuyCard() {
		// TODO Auto-generated method stub
		List<BuyCard> buycardList = new ArrayList<BuyCard>();
		String sql = "select * from buycard";
		ResultSet rs = DbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				BuyCard buycard = new BuyCard();
				buycard.setBid(rs.getInt("bid"));
				buycard.setBname(rs.getString("bname"));
				buycard.setBprice(rs.getDouble("bprice"));
				buycard.setBinfo(rs.getString("binfo"));
				buycard.setBface(rs.getString("bface"));
				buycard.setBnumber(rs.getInt("bnumber"));
				buycardList.add(buycard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buycardList;
	}

	/**
	 * 根据bid查询商品
	 * @param bid
	 * @return BuyCard
	 */
	public BuyCard getUserInfo(int bid) {
		// TODO Auto-generated method stub
		BuyCard _buycard = null;
		String sql = "select * from buycard where bid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(bid);
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				_buycard = new BuyCard();
				_buycard.setBid(rs.getInt("bid"));
				_buycard.setBname(rs.getString("bname"));
				_buycard.setBprice(rs.getDouble("bprice"));
				_buycard.setBinfo(rs.getString("binfo"));
				_buycard.setBface(rs.getString("bface"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _buycard;
	}

	public int addBuyCard(BuyCard buyCard) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除商品
	 * @param buyCard
	 * @return BuyCard
	 */
	public boolean deleteBuyCard(BuyCard buyCard) {
		// TODO Auto-generated method stub
		String sql = "delete from buycard where bid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(buyCard.getBid());
		int count = DbUtil.executeUpdate(sql, params);
		boolean result = false;
		if(count>0)
		{
			result = true;
		}
		return result;
	}

	public boolean updateBuyCard(BuyCard buyCard) {
		// TODO Auto-generated method stub
		String sql = "UPDATE  buycard SET bname=?, bprice=? , binfo=? , bface=? , bnumber=? WHERE bid=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(buyCard.getBname());
		params.add(buyCard.getBprice());
		params.add(buyCard.getBinfo());
		params.add(buyCard.getBface());
		params.add(buyCard.getBnumber());
		params.add(buyCard.getBid());
		
		boolean result =false;
		int count = DbUtil.executeUpdate(sql, params);
		if(count>0)
		{
			result = true;
		}
		return result;
	}

	/**
	 * 获得所有商品总记录数
	 * @param buyCard
	 * @return BuyCard
	 */
	public int getBuyCardCountDao() {
		// TODO Auto-generated method stub
		String sql = "select count(*) as num from buycard";
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

	/**
	 * 分页查询商品信息
	 * @param currentpage 当前页码
	 * @param num 每页显示条数
	 * @return List<BuyCard>
	 */
	public List<BuyCard> queryBuyCardDao(int currentpage, int num) {
		List<BuyCard> buycards = new ArrayList<BuyCard>();
		String sql = "select * from buycard limit ?,?";
		List<Object> params = new ArrayList<Object>();
		params.add((currentpage-1)*num);
		params.add(num);
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				BuyCard buycard = new BuyCard();
				buycard.setBid(rs.getInt("bid"));
				buycard.setBname(rs.getString("bname"));
				buycard.setBprice(Double.parseDouble(rs.getString("bprice")));
				buycard.setBface(rs.getString("bface"));
				buycard.setBinfo(rs.getString("binfo"));
				buycard.setBnumber(rs.getShort("bnumber"));
				buycards.add(buycard);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buycards;
	}

}
