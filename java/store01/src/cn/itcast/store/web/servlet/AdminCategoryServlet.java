package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.serviceImpl.CategoryServiceImpl;
import cn.itcast.store.utils.UUIDUtils;

public class AdminCategoryServlet extends BaseServlet {
	
//findAllCats
	public String findAllCats(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡȫ���������Ϣ
		//ȫ��������Ϣ����request
		//ת����/admin/category/list.jsp
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = null;
		try {
			list = categoryService.getAllCats();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		request.setAttribute("allCats", list);
		return "/admin/category/list.jsp";
		
	}
	public String addCategoryUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/admin/category/add.jsp";
		
	}
	public String addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡȫ���������Ϣ
		//ȫ��������Ϣ����request
		//ת����/admin/category/list.jsp
		String cname = request.getParameter("cname");
		CategoryService categoryService = new CategoryServiceImpl();
		String cid = UUIDUtils.getCode();
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		try {
			categoryService.addCategory(category);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		response.sendRedirect("/store01/AdminCategoryServlet?method=findAllCats");
		return null;
		
	}

}
