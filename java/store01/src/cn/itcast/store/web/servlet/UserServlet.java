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
			//接受表单参数
			Map<String,String[]> map = request.getParameterMap();
			User user = new User();
			MyBeanUtils.populate(user, map);
			//为用户的其它属性赋值 
			user.setUid(UUIDUtils.getId());
			user.setState(0);
			user.setCode(UUIDUtils.getCode());
			//调用业务层注册信息 
			UserService us = new UserServiceImpl();
			try {
				us.userRegist(user);
				//注册成功，向用户邮箱发送消息
				MailUtils.sendMail("aaa@store.com", user.getCode());
				request.setAttribute("msg", "注册成功，请激活");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				//注册失败，跳转到提示页面
				request.setAttribute("msg", "用户注册失败，请重新注册");
				e.printStackTrace();
			}
			return "/jsp/info.jsp";
			//注册成功，向用户邮箱发送信息，跳转到提示页面
			//注册失败，跳转到提示页面
			
			
			
	}

	

}
