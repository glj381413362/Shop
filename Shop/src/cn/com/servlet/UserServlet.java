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
		
		//ͳһ����  op  login,add,delete,select
		//����������ҳ���ȡop����������
		String op=req.getParameter("op");
		//ͳһ��Դ
		IUserServer user_server = new UserServer();
		IBuyCardService prduct_server = new BuyCardService();
		//��ȫ  "" null
		if(op!=null){
			//����
			if(op.equals("login")){
				//��¼����
				//��ȡ����
				String name = req.getParameter("name");
				String pwd = req.getParameter("pwd");
				
				User user = new User();
				user.setName(name);
				user.setPwd(pwd);
				//����ģ��
				user=user_server.getUserServer(user);
				//����
				if(user!=null){
					//�Ϸ�
					//��ת ��������
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					List<BuyCard> product = prduct_server.getAllBuyCard();
					req.setAttribute("product", product);
					req.getRequestDispatcher("Product.jsp").forward(req, resp);
//					resp.sendRedirect("Product.jsp");
				}
				else{
					//���Ϸ�
					//��ת
					resp.sendRedirect("index.jsp");
				}
			}
			if(op.equals("add")){
				//��ӹ���
				String userName = req.getParameter("userName");
				String userPwd = req.getParameter("passWord");
				
				User user = new User();
				user.setName(userName);
				user.setPwd(userPwd);
				
				//����ģ��
				boolean result = user_server.addUserServer(user);
				if(result)
				{
					//��ӳɹ�
					User user1=user_server.getUserServer(user);
					
					
				}else{
					//���ʧ��
				}
				
			}
			if(op.equals("update")){
				//�޸Ĺ���
			}
			if(op.equals("delete")){
				//ɾ������
			}
		
		}
	}

}
