package cn.com.server;

import java.util.List;

import cn.com.bean.BuyCard;


public interface IBuyCardService {
	public List<BuyCard> getAllBuyCard();

	public BuyCard getBuyCard(int bid);

	public boolean addBuyCard(BuyCard buyCard);

	public boolean deleteBuyCard(BuyCard buyCard);

	public boolean updateBuyCard(BuyCard buyCard);
	/**
	 * Service 返回所有商品记录总数
	 * @return
	 */
    public int getBuyCardCountService();
	
	/**
	 * Service 返回商品记录信息
	 * @param currentpage 当前页码
	 * @param num 当前页记录条数
	 * @return
	 */
	public List<BuyCard> queryBuyCardService(int currentpage,int num);

}
