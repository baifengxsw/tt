package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;
import cn.itcast.store.service.serviceImpl.UserServiceImpl;
import cn.itcast.store.utils.MailUtils;
import cn.itcast.store.utils.MyBeanUtils;
import cn.itcast.store.utils.UUIDUtils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/register.jsp";
	}
		public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//���ܱ�����
			Map<String,String[]> map = request.getParameterMap();
			User user = new User();
			MyBeanUtils.populate(user, map);
			//Ϊ�û����������Ը�ֵ 
			user.setUid(UUIDUtils.getId());
			user.setState(0);
			user.setCode(UUIDUtils.getCode());
			//����ҵ���ע����Ϣ 
			UserService us = new UserServiceImpl();
			try {
				us.userRegist(user);
				//ע��ɹ������û����䷢����Ϣ
				MailUtils.sendMail("aaa@store.com", user.getCode());
				request.setAttribute("msg", "ע��ɹ����뼤��");
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				//ע��ʧ�ܣ���ת����ʾҳ��
				request.setAttribute("msg", "�û�ע��ʧ�ܣ�������ע��");
				e.printStackTrace();
			}
			return "/jsp/info.jsp";
			//ע��ɹ������û����䷢����Ϣ����ת����ʾҳ��
			//ע��ʧ�ܣ���ת����ʾҳ��
			
			
			
	}

	

}
