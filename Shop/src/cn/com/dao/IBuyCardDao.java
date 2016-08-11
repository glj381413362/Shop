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
	 * Dao ����������Ʒ��¼����
	 * @return
	 */
    public int getBuyCardCountDao();
	
	/**
	 * Dao ������Ʒ��¼��Ϣ
	 * @param currentpage ��ǰҳ��
	 * @param num ��ǰҳ��¼����
	 * @return
	 */
	public List<BuyCard> queryBuyCardDao(int currentpage,int num);
}
