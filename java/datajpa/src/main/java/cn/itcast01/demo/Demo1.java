package cn.itcast01.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import cn.itcast01.Utils.JpaUtil;

public class Demo1 {
	@Test
	public void test() {
		/**
		 * 创建实体管理类工厂，借助Persistence的静态方法获取
		 * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定 
		 */
		
		//创建实体管理类
		EntityManager em = JpaUtil.getFactory();
		//获取事务对象
		EntityTransaction tx = em.getTransaction();
		//开启事务
		tx.begin();
		Customer c = new Customer();
		c.setCustName("传智播客");
		//保存操作
		em.persist(c);
		//提交事务
		tx.commit();
		//释放资源
		em.close();
		
	}
	@Test
	public void test1() {
		/**
		 * 创建实体管理类工厂，借助Persistence的静态方法获取
		 * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定 
		 */
		
		//创建实体管理类
		EntityManager em = JpaUtil.getFactory();
		//获取事务对象
		EntityTransaction tx = em.getTransaction();
		//开启事务
		tx.begin();
		Customer c = new Customer();
		c.setCustName("传智播客");
		//获取数据
		Customer cus = em.find(Customer.class, 1L);
		//延迟加载
		Customer cus1 = em.getReference(Customer.class,1L);
		System.out.println(cus);
		System.out.println(cus1);
		//提交事务
		tx.commit();
		//释放资源
		em.close();
		
	}
	@Test
	public void test2() {
		/**
		 * 创建实体管理类工厂，借助Persistence的静态方法获取
		 * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定 
		 */
		
		//创建实体管理类
		EntityManager em = JpaUtil.getFactory();
		//获取事务对象
		EntityTransaction tx = em.getTransaction();
		//开启事务
		tx.begin();
		Customer c = new Customer();
		c.setCustName("传智播客");
		//获取数据
		Customer cus = em.find(Customer.class, 1L);
		cus.setCustAddress("dsfdsfds");
	
		//提交事务
		tx.commit();
		//释放资源
		em.close();
		
	}
	//jpql  面向对象的查询方式
	@Test
	public void tes32() {
		/**
		 * 创建实体管理类工厂，借助Persistence的静态方法获取
		 * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定 
		 */
		
		//创建实体管理类
		EntityManager em = JpaUtil.getFactory();
		//获取事务对象
		EntityTransaction tx = em.getTransaction();
		//开启事务
		tx.begin();
		String  sql = "from Customer";
		Query query = em.createQuery(sql);
		
		List<Customer>list = query.getResultList();
		for (Customer customer:list) {
			System.out.println(customer);
		}
		
		//提交事务
		tx.commit();
		//释放资源
		em.close();
		
	}
	//jpql  面向对象的查询方式
	@Test
	public void tes33() {
		/**
		 * 创建实体管理类工厂，借助Persistence的静态方法获取
		 * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定 
		 */
		
		//创建实体管理类
		EntityManager em = JpaUtil.getFactory();
		//获取事务对象
		EntityTransaction tx = em.getTransaction();
		//开启事务
		tx.begin();
		String  sql = "from Customer where custName ='传智播客'";
		Query query = em.createQuery(sql);
	
		
		List<Customer>list = query.getResultList();
		for (Customer customer:list) {
			System.out.println(customer);
		}
		
		//提交事务
		tx.commit();
		//释放资源
		em.close();
		
	}
	//jpql  面向对象的查询方式
	@Test
	public void tes34() {
		/**
		 * 创建实体管理类工厂，借助Persistence的静态方法获取
		 * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定 
		 */
		
		//创建实体管理类
		EntityManager em = JpaUtil.getFactory();
		//获取事务对象
		EntityTransaction tx = em.getTransaction();
		//开启事务
		tx.begin();
		String  sql = "from Customer order by custName";
		Query query = em.createQuery(sql);
		
		
		List<Customer>list = query.getResultList();
		for (Customer customer:list) {
			System.out.println(customer);
		}
		
		//提交事务
		tx.commit();
		//释放资源
		em.close();
		
	}

}
