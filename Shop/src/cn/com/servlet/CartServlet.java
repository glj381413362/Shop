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
		//统一操作
		String op = req.getParameter("op");
		
		//统一资源
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
			//添加商品到蓝子
			//细节  蓝子中已经存在的商品 只需要累加数量
			int id = Integer.parseInt(req.getParameter("id"));
			if(cart.containsKey(id))
			{
				int num = cart.get(id).getCartnum();
				cart.get(id).setCartnum(num+1);
			}else{
				cart.put(id, buyCardService.getBuyCard(id));
			}
			
			//更新蓝子
			session.setAttribute("cart", cart);
			//流程
			//转发数据到   显示购物车页面 showCards.jsp
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
