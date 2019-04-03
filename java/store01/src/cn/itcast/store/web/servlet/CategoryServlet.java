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
import cn.itcast.store.utils.JedisUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {
	
	public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��redis �л�ȡȫ���ķ���
		Jedis jedis=JedisUtils.getJedis();
		String jsonStr = jedis.get("allCats");
		if(null == jsonStr||"".equals(jsonStr)) {
			CategoryService categoryService = new CategoryServiceImpl();
			try {
				System.out.println("������");
				List<Category> list = categoryService.getAllCats();
				
				//��ȫ������ת��Ϊjson��ʽ������
				jsonStr = JSONArray.fromObject(list).toString();
				//����ȡ����json�ַ�����ӵ�redis��
				jedis.set("allCats", jsonStr);
				resp.setContentType("application/json;charset=utf-8");
				resp.getWriter().print(jsonStr);
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else {
			//redis ������
			System.out.println("������");
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print(jsonStr);
		}
		JedisUtils.closeJedis(jedis);
		return null;
		
		
	}

}
