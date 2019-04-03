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
		//在redis 中获取全部的分类
		Jedis jedis=JedisUtils.getJedis();
		String jsonStr = jedis.get("allCats");
		if(null == jsonStr||"".equals(jsonStr)) {
			CategoryService categoryService = new CategoryServiceImpl();
			try {
				System.out.println("无数据");
				List<Category> list = categoryService.getAllCats();
				
				//将全部分类转换为json格式的数据
				jsonStr = JSONArray.fromObject(list).toString();
				//将获取到的json字符串添加到redis中
				jedis.set("allCats", jsonStr);
				resp.setContentType("application/json;charset=utf-8");
				resp.getWriter().print(jsonStr);
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			//redis 有数据
			System.out.println("有数据");
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print(jsonStr);
		}
		JedisUtils.closeJedis(jedis);
		return null;
		
		
	}

}
