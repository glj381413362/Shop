package cn.com.server.impl;

import java.util.List;

import cn.com.bean.BuyCard;
import cn.com.dao.impl.BuyCardDao;
import cn.com.server.IBuyCardService;

public class BuyCardService implements IBuyCardService {
	private BuyCardDao buyCardDao=new BuyCardDao();
	public List<BuyCard> getAllBuyCard() {
		// TODO Auto-generated method stub
		return buyCardDao.getAllBuyCard();
	}

	public BuyCard getBuyCard(int bid) {
		// TODO Auto-generated method stub
		return buyCardDao.getUserInfo(bid);
	}

	public boolean addBuyCard(BuyCard buyCard) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBuyCard(BuyCard buyCard) {
		// TODO Auto-generated method stub
		return buyCardDao.deleteBuyCard(buyCard);
	}

	public boolean updateBuyCard(BuyCard buyCard) {
		// TODO Auto-generated method stub
		return buyCardDao.updateBuyCard(buyCard);
	}

}
