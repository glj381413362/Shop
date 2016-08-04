package cn.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.BuyCard;
import cn.com.bean.User;
import cn.com.server.IBuyCardService;
import cn.com.server.IUserServer;
import cn.com.server.impl.BuyCardService;
import cn.com.server.impl.UserServer;

public class UserServlet extends HttpServlet{

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
		IUserServer user_server = new UserServer();
		IBuyCardService prduct_server = new BuyCardService();
		//安全  "" null
		if(op!=null){
			//流程
			if(op.equals("login")){
				//登录功能
				//获取数据
				String name = req.getParameter("name");
				String pwd = req.getParameter("pwd");
				
				User user = new User();
				user.setName(name);
				user.setPwd(pwd);
				//调用模块
				user=user_server.getUserServer(user);
				//流程
				if(user!=null){
					//合法
					//跳转 不带数据
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					List<BuyCard> product = prduct_server.getAllBuyCard();
					req.setAttribute("product", product);
					req.getRequestDispatcher("Product.jsp").forward(req, resp);
//					resp.sendRedirect("Product.jsp");
				}
				else{
					//不合法
					//跳转
					resp.sendRedirect("index.jsp");
				}
			}
			if(op.equals("add")){
				//添加功能
				String userName = req.getParameter("userName");
				String userPwd = req.getParameter("passWord");
				
				User user = new User();
				user.setName(userName);
				user.setPwd(userPwd);
				
				//调用模块
				boolean result = user_server.addUserServer(user);
				if(result)
				{
					//添加成功
					User user1=user_server.getUserServer(user);
					
					
				}else{
					//添加失败
				}
				
			}
			if(op.equals("update")){
				//修改功能
			}
			if(op.equals("delete")){
				//删除功能
			}
		
		}
	}

}
