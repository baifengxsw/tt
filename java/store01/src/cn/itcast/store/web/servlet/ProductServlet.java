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
		//��ȡ��Ʒpid
		String pid = request.getParameter("pid");
		//������Ʒpid��ѯ�����Ʒ����Ϣ
		ProductService productService = new ProductServiceImpl();
		try {
			Product product = productService.findProductByPid(pid);
			request.setAttribute("product", product);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//����ȡ������Ʒ���� request
		//ת����/jsp/product_info.jsp
		return "/jsp/product_info.jsp";
	}
	public String findByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1���ܲ���
		String cid = request.getParameter("cid");
		int pageNumber = 1;
		try {
			//���û�д��ݲ����������ǲ�������ʹ��Ĭ��ֵ1
			pageNumber = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			
		}
		//1.3ÿҳ��ʾ�ĸ���
		int pageSize = 12 ; //�̶�ֵ������ͨ��������������
		//2 ����ҵ���
		ProductService productService = new ProductServiceImpl();
		PageBean<Product> pageBean = null;
		try {
			pageBean = productService.findByCid(cid,pageNumber,pageSize);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//�����ݴ��request �����򣬲�������ת����ָ��ҳ��
		request.setAttribute("cid", cid);
		request.setAttribute("page",pageBean);
		return "/jsp/product_list.jsp";
		
		
	}
	}


