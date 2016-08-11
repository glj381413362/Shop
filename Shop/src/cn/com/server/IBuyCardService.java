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
	 * Service ����������Ʒ��¼����
	 * @return
	 */
    public int getBuyCardCountService();
	
	/**
	 * Service ������Ʒ��¼��Ϣ
	 * @param currentpage ��ǰҳ��
	 * @param num ��ǰҳ��¼����
	 * @return
	 */
	public List<BuyCard> queryBuyCardService(int currentpage,int num);

}
