package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用业务层查询最新的商品，查询最热商品，返回两个集合 
		//将两个集合放入request
		//转发真实的首页
		ProductService productService = new ProductServiceImpl();
		List<Product> list01 = null;
		List<Product> list02 = null;
		try {
			list01 = productService.findHots();
			list02 = productService.findNews();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//将两个集合放入到request
		request.setAttribute("hots", list01);
		request.setAttribute("news",list02);
		return "/jsp/index.jsp";
	}

}
