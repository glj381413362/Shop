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
import cn.com.util.PageUtil;

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
	    	if(op.equals("show"))
			{
				//获得总记录条数
				int count = buyCardService.getBuyCardCountService();
				//调用分类工具类
				PageUtil pageUtil = new PageUtil(5, count);
				int jumpPage=Integer.parseInt(req.getParameter("jumpPage"));
				// 处理页码逻辑
				if (jumpPage <= 1) 
				{

					pageUtil.setCurPage(1);
				} else if (jumpPage >= pageUtil.getMaxPage()) {

					pageUtil.setCurPage(pageUtil.getMaxPage());
				} else {
					pageUtil.setCurPage(jumpPage);
				}
				//分批获取数据
				List<BuyCard> product=buyCardService.queryBuyCardService(jumpPage, 5);
				//设置页面交互逻辑
				req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
				req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
				req.setAttribute("maxPage", pageUtil.getMaxPage());
				req.setAttribute("jumpPage", jumpPage);
				req.setAttribute("curPage", pageUtil.getCurPage());
				
				
				//转发数据
				req.setAttribute("product", product);
				req.getRequestDispatcher("Product.jsp").forward(req, resp);
				
			}
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
				String opp = req.getParameter("opp");
				int i = Integer.parseInt(req.getParameter("id"));
				BuyCard buyCard = buyCardService.getBuyCard(i);
				if(opp.equals("select"))
				{
					
					req.setAttribute("buyCard", buyCard);
					req.getRequestDispatcher("ProductUpdate.jsp").forward(req, resp);
				}
				if(opp.equals("update"))
				{
					
					
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
			}
	    }
	}
   
}
