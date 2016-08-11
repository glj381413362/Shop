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
		//ͳһ����  op  login,add,delete,select
	    //����������ҳ���ȡop����������
	    String op=req.getParameter("op");
	  //ͳһ��Դ
	    IBuyCardService buyCardService = new BuyCardService();
		IBuyCardService prduct_server = new BuyCardService();
	  //��ȫ  "" null
	    if(op != null)
	    {
	    	//����
	    	if(op.equals("show"))
			{
				//����ܼ�¼����
				int count = buyCardService.getBuyCardCountService();
				//���÷��๤����
				PageUtil pageUtil = new PageUtil(5, count);
				int jumpPage=Integer.parseInt(req.getParameter("jumpPage"));
				// ����ҳ���߼�
				if (jumpPage <= 1) 
				{

					pageUtil.setCurPage(1);
				} else if (jumpPage >= pageUtil.getMaxPage()) {

					pageUtil.setCurPage(pageUtil.getMaxPage());
				} else {
					pageUtil.setCurPage(jumpPage);
				}
				//������ȡ����
				List<BuyCard> product=buyCardService.queryBuyCardService(jumpPage, 5);
				//����ҳ�潻���߼�
				req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
				req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
				req.setAttribute("maxPage", pageUtil.getMaxPage());
				req.setAttribute("jumpPage", jumpPage);
				req.setAttribute("curPage", pageUtil.getCurPage());
				
				
				//ת������
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
