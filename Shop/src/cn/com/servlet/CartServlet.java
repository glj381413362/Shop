package cn.com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.BuyCard;
import cn.com.server.IBuyCardService;
import cn.com.server.impl.BuyCardService;

public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//ͳһ����
		String op = req.getParameter("op");
		
		//ͳһ��Դ
		IBuyCardService buyCardService = new BuyCardService();
		HttpSession session = req.getSession();
		if(op.equals("add"))
		{
			Map<Integer,BuyCard> cart = null;
			Object obj = session.getAttribute("cart");
			if(obj == null)
			{
				cart = new HashMap<Integer, BuyCard>();
			}else{
				cart=(Map<Integer, BuyCard>) obj;
			}
			//�����Ʒ������
			//ϸ��  �������Ѿ����ڵ���Ʒ ֻ��Ҫ�ۼ�����
			int id = Integer.parseInt(req.getParameter("id"));
			if(cart.containsKey(id))
			{
				int num = cart.get(id).getCartnum();
				cart.get(id).setCartnum(num+1);
			}else{
				cart.put(id, buyCardService.getBuyCard(id));
			}
			
			//��������
			session.setAttribute("cart", cart);
			//����
			//ת�����ݵ�   ��ʾ���ﳵҳ�� showCards.jsp
			Map<Integer, BuyCard> carts = (Map<Integer, BuyCard>)session.getAttribute("cart");
			req.setAttribute("carts", carts);
			req.getRequestDispatcher("ShowCart.jsp").forward(req, resp);
			
		}
		if(op.equals("delete"))
		{
			
		}
		if(op.equals("update"))
		{
			
		}
		if(op.equals("select"))
		{
			String id = req.getParameter("id");
//			if(cart)
		}
		
		
		//
	}

}
