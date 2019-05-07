package cn.itcast.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.itcast.QueryVo;
import cn.itcast.User;
import cn.itcast.utils.SqlSessionUtils;

public class UserMapperImpl  {
	@Test
	public void getUserById() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession(true);
		//获取接口的代理实现类 自动创建一个实现类
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);
		System.out.println(user);
		session.close();
		
	}
	@Test
	
	public void getUserByUserName() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession(true);
		//获取接口的代理实现类 自动创建一个实现类
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> list = userMapper.getUserByName("张");
		for(User user :list) {
			System.out.println(user);
		}
		session.close();
		
	}
	
	@Test
	public void insertUser() {
		

	}
	@Test
	public void getUserByQueryVo() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession(true);
		//获取接口的代理实现类 自动创建一个实现类
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo query = new QueryVo();
		User user = new User();
		user.setId(1);
		query.setUser(user);
		User ret = userMapper.getUserByQueryVo(query);
		System.out.println(ret);
		session.close();
		
	}
	/**
	 * 获取总记录数
	 */
	@Test
	public void getUserCount() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession(true);
		//获取接口的代理实现类 自动创建一个实现类
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int ret = userMapper.getUserCount();
		System.out.println(ret);
		session.close();
		
	}
	/**
	 * 根据多个条件进行查询
	 */
	@Test
	public void getUserByNameSex() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession(true);
		//获取接口的代理实现类 自动创建一个实现类
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张");
		user.setSex("1");
		List <User> list = userMapper.getUserByNameSex(user);
		for(User u: list) {
			System.out.println(u);
			
		}
		session.close();
	}
	/**
	* 根据多个条件进行查询
	*/
	@Test
	public void getUserByMap() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession(true);
		//获取接口的代理实现类 自动创建一个实现类
		UserMapper userMapper = session.getMapper(UserMapper.class);

		List <User> list = userMapper.getUserByMap();
		for(User u: list) {
			System.out.println(u);
			
		}
		session.close();
	}
}
