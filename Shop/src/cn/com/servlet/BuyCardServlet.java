package cn.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.bean.BuyCard;
import cn.com.server.IBuyCardService;
import cn.com.server.IUserServer;
import cn.com.server.impl.BuyCardService;
import cn.com.server.impl.UserServer;

public class BuyCardServlet extends HttpServlet{

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
		//统一流程  op  login,add,delete,select
	    //向调用引擎的页面获取op操作符参数
	    String op=req.getParameter("op");
	  //统一资源
	    IBuyCardService buyCardService = new BuyCardService();
		IBuyCardService prduct_server = new BuyCardService();
	  //安全  "" null
	    if(op != null)
	    {
	    	//流程
			if(op.equals("add")){
	    		
	    	}
			if(op.equals("delete")){
				int i = Integer.parseInt(req.getParameter("id"));
				BuyCard buyCard = buyCardService.getBuyCard(i);
				boolean result = buyCardService.deleteBuyCard(buyCard);
				if(result)
                {
                	List<BuyCard> product = prduct_server.getAllBuyCard();
    				req.setAttribute("product", product);
    				req.getRequestDispatcher("Product.jsp").forward(req, resp);
                }
				    	}
			if(op.equals("update")){
				System.out.println("dd");
				int i = Integer.parseInt(req.getParameter("id"));
				BuyCard buyCard = buyCardService.getBuyCard(i);
				
                String productName = req.getParameter("productName");
                String photo = req.getParameter("photo");
                String info = req.getParameter("binfo");
                int number = Integer.parseInt(req.getParameter("productNumber"));
                double bprice = Double.parseDouble(req.getParameter("productPrice"));
                
                buyCard.setBid(i);
                buyCard.setBface("images/"+photo);
                buyCard.setBinfo(info);
                buyCard.setBname(productName);
                buyCard.setBnumber(number);
                buyCard.setBprice(bprice);
                
                boolean result = buyCardService.updateBuyCard(buyCard);
                
                if(result)
                {
                	List<BuyCard> product = prduct_server.getAllBuyCard();
    				req.setAttribute("product", product);
    				req.getRequestDispatcher("Product.jsp").forward(req, resp);
                }
			}
			if(op.equals("slecte")){
				
			}
	    }
	}
   
}
