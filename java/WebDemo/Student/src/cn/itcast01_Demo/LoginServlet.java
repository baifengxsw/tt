package cn.itcast01_Demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast02_dao.StuDao;
import cn.itcast02_dao.UserDao;
import cn.itcast03_bin.Student;
import cn.itcast04_Impl.StuDaoImpl;
import cn.itcast04_Impl.UserDaoImpl;

/**
 * 这是用于处理登录的servlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//提交的数据可能会有中文 ,怎么进行处理 下面针对post方法 ,因为 get方法 无请求体
		request.setCharacterEncoding("UTF-8");
		//对于输出的数据可能存在中文 
		response.setContentType("text/html;charset=UTF-8");
		
		//获取提交的信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//数据查询
		UserDao ud = new UserDaoImpl();
		boolean flag = ud.login(username, password);
		if(!flag){
			response.getWriter().write("登录失败,将会重新返回登录页面");
		}else{
			//这里登录成功
			response.getWriter().write("登录成功");
			//1 先进行数据查询 
			StuDao sdao = new StuDaoImpl();
			List <Student>list = sdao.findAll();  //这个数据带走非常麻烦 可以考虑存在作用域上
			//使用session 存储
			request.getSession().setAttribute("list", list);
			//2;进行页面转换
			response.sendRedirect("list.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1123");
		doGet(request, response);
	}

}
