package cn.itcast.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

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
		
		session.close();
		
	}

}
