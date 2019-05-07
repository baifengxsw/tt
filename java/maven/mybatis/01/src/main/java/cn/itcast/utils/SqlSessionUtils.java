package cn.itcast.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {
	private static SqlSessionFactory factory;
	
	static {
   	 //创建sqlsessionFactoryBuilder对象
   	 SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
   	 //创建核心配置的输入流
   	 InputStream is = null;
	try {
		is = Resources.getResourceAsStream("cn/itcast/SqlMapConfig.xml");
		factory = ssfb.build(is);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	}
   	 //创建对象
   	 //创建唯一的工厂
	/**
	 * 返回session对象
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
			return factory;
	}
   
	
	
}
