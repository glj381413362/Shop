package cn.com.server;

import java.util.List;

import cn.com.bean.BuyCard;


public interface IBuyCardService {
	public List<BuyCard> getAllBuyCard();

	public BuyCard getBuyCard(int bid);

	public boolean addBuyCard(BuyCard buyCard);

	public boolean deleteBuyCard(BuyCard buyCard);

	public boolean updateBuyCard(BuyCard buyCard);

}
