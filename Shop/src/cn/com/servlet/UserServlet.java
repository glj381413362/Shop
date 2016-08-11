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
import cn.com.util.PageUtil;

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
		System.out.println("dd");
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
				user.setUsername(name);
				user.setUserpwd(pwd);
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
					req.getRequestDispatcher("buyCardServlet.action?op=show&jumpPage=1").forward(req, resp);
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
				user.setUsername(userName);
				user.setUserpwd(userPwd);
				
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
				System.out.println("jingt");
			}
			if(op.equals("delete")){
				//ɾ������
			}
			if(op.equals("select"))
			{
				//��ȡ�ܼ�¼��
				int count=user_server.getAllCountServer();
				//���÷�ҳ������<=>�߼�����
				PageUtil pageUtil=new PageUtil(2, count);
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
				List<User> listuser=user_server.queryUserServer(jumpPage, 2);
				//����ҳ�潻���߼�
				req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
				req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
				req.setAttribute("maxPage", pageUtil.getMaxPage());
				req.setAttribute("jumpPage", jumpPage);
				req.setAttribute("curPage", pageUtil.getCurPage());
				
				
				//ת������
				req.setAttribute("listuser", listuser);
				req.getRequestDispatcher("User.jsp").forward(req, resp);
				
			}
		}
	}
}
