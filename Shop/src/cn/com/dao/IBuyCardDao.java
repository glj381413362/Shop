package cn.com.dao;

import java.util.List;

import cn.com.bean.BuyCard;
import cn.com.bean.User;


public interface IBuyCardDao {

	public List<BuyCard> getAllBuyCard();

	public BuyCard getUserInfo(int bid);

	public int addBuyCard(BuyCard buyCard);

	public boolean deleteBuyCard(BuyCard buyCard);

	public boolean updateBuyCard(BuyCard buyCard);

	/**
	 * Dao 返回所有商品记录总数
	 * @return
	 */
    public int getBuyCardCountDao();
	
	/**
	 * Dao 返回商品记录信息
	 * @param currentpage 当前页码
	 * @param num 当前页记录条数
	 * @return
	 */
	public List<BuyCard> queryBuyCardDao(int currentpage,int num);
}
