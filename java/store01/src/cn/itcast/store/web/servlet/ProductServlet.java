package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	
	public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取商品pid
		String pid = request.getParameter("pid");
		//根据商品pid查询相关商品的信息
		ProductService productService = new ProductServiceImpl();
		try {
			Product product = productService.findProductByPid(pid);
			request.setAttribute("product", product);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//将获取到的商品放入 request
		//转发到/jsp/product_info.jsp
		return "/jsp/product_info.jsp";
	}
	public String findByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1接受参数
		String cid = request.getParameter("cid");
		int pageNumber = 1;
		try {
			//如果没有传递参数，或者是参数错误，使用默认值1
			pageNumber = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			
		}
		//1.3每页显示的个数
		int pageSize = 12 ; //固定值，可以通过请求参数来获得
		//2 调用业务层
		ProductService productService = new ProductServiceImpl();
		PageBean<Product> pageBean = null;
		try {
			pageBean = productService.findByCid(cid,pageNumber,pageSize);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//将数据存放request 作用域，并将请求转发到指定页面
		request.setAttribute("cid", cid);
		request.setAttribute("page",pageBean);
		return "/jsp/product_list.jsp";
		
		
	}
	}


