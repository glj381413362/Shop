package cn.com.dao;

import java.util.List;

import cn.com.bean.BuyCard;


public interface IBuyCardDao {

	public List<BuyCard> getAllBuyCard();

	public BuyCard getUserInfo(int bid);

	public int addBuyCard(BuyCard buyCard);

	public boolean deleteBuyCard(BuyCard buyCard);

	public boolean updateBuyCard(BuyCard buyCard);

}
