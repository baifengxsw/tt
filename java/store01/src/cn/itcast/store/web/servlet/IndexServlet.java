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
		//����ҵ����ѯ���µ���Ʒ����ѯ������Ʒ�������������� 
		//���������Ϸ���request
		//ת����ʵ����ҳ
		ProductService productService = new ProductServiceImpl();
		List<Product> list01 = null;
		List<Product> list02 = null;
		try {
			list01 = productService.findHots();
			list02 = productService.findNews();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//���������Ϸ��뵽request
		request.setAttribute("hots", list01);
		request.setAttribute("news",list02);
		return "/jsp/index.jsp";
	}

}
