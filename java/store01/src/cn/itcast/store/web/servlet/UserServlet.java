package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
				MailUtils.sendMail(user.getEmail(), user.getCode());
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
		public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取激活码
			String code = request.getParameter("code");
			UserService userService = new UserServiceImpl();
			boolean flag = false;
			try {
				flag = userService.userActive(code);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			//进行激活提示
			if(flag == true) {
				//激活成功
				request.setAttribute("msg", "用户激活成功,请登录");
				
			}else {
				request.setAttribute("msg", "用户激活失败,请重新激活");
			}
			return "/jsp/info.jsp";
		}
		
		public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			return "/jsp/login.jsp";
		}
		public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user  = new User();
			MyBeanUtils.populate(user, request.getParameterMap());
		
			//调用业务层登录功能
			UserService userService = new UserServiceImpl();
			User user02 = null;
			try {
				user02 = userService.userLogin(user); //
				if(user02!=null) {
					request.getSession().setAttribute("login", user02);
					response.sendRedirect("/store01/index.jsp");
					
				}
			} catch (Exception e) {
				//登录失败的情形
				String msg = e.getMessage();
				System.out.println(msg);
				request.setAttribute("msg", msg);
				return "/jsp/login.jsp";
			}
			
			return null;
			
			
		}
		
		public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//让会话消息失效
			request.getSession().invalidate();
			response.sendRedirect("/store01/index.jsp");
			return null;
		}

	

}
