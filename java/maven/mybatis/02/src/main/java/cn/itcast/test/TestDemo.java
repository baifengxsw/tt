package cn.itcast.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.User;
import cn.itcast.utils.SqlSessionUtils;

public class TestDemo {
	//根据相应的id 进行查询
	     @Test
		public void demo1() throws IOException {
			
	
		//创建sqlsessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建核心配置的输入流
		InputStream is = Resources.getResourceAsStream("cn/itcast/SqlMapConfig.xml");
		//创建对象
		SqlSessionFactory factory = ssfb.build(is);
		//创建session方向
		SqlSession session = factory.openSession();
		User user = session.selectOne("user.getUserById",1);
		System.out.println(user);
		session.close();
	}
	     //模糊搜索姓名
	     @Test
	     public void demo2() throws IOException {
	    	 //创建session方向
	    	 SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession();
	    	 List<User> list = session.selectList("user.getUserByName","张");
	    	 for(User user: list) {
	    	 System.out.println(user);
	    	 }
	    	 session.close();
	     }
	     //插入数据
	     @Test
	     public void demo3() throws IOException {
	    	 //创建session方向
	    	 SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession();
	    	 User user = new User();
	    	 user.setUsername("xia");
	    	 user.setBirthday(new Date());
	    	 user.setSex("1");
	    	 user.setAddress("南京");
	    	 session.insert("user.insertUser",user);
	    	 System.out.println(user.getId());
	    	 //设置事务的提交
	    	 session.commit();
	    	 session.close();
	     }
	     //更新数据
	     @Test
	     public void demo4() throws IOException {
	    	 //创建session方向
	    	 SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession();
	    	 User user = new User();
	    	 user.setId(34);
	    	 user.setUsername("王五");
	    	 user.setBirthday(new Date());
	    	 user.setSex("2");
	    	 user.setAddress("南京");
	    	 session.update("user.updateUser",user);
	    	 System.out.println(user.getId());
	    	 //设置事务的提交
	    	 session.commit();
	    	 session.close();
	     }
	     //插入数据
	     @Test
	     public void demo5() throws IOException {
	    	 //创建session方向
	    	 SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession();
	    	 session.delete("user.deleteUser",33);
	    
	    	 //设置事务的提交
	    	 session.commit();
	    	 session.close();
	     }
}
