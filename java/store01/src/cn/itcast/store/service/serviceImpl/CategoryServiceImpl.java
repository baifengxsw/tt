package cn.itcast.store.service.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.dao.CategoryDao;
import cn.itcast.store.dao.DaoImpl.CategoryDaoImpl;
import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.utils.BeanFactory;
import cn.itcast.store.utils.JedisUtils;
import redis.clients.jedis.Jedis;

public class CategoryServiceImpl implements CategoryService{
	CategoryDao categoryDao = (CategoryDao) BeanFactory.createObject("CategoryDao");

	public List<Category> getAllCats() throws SQLException {
		return categoryDao.getAllCats();
	}

	public void addCategory(Category category) throws SQLException {
		
		categoryDao.addCategory(category);
		//开始向redis中进行数据的更新
		Jedis jedis  = JedisUtils.getJedis();
		jedis.del("allCat");
		JedisUtils.closeJedis(jedis);
		
		
	}
	
}
