package cn.itcast01.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory ;
	static {
		factory = Persistence.createEntityManagerFactory("myJpa");
	}
	
	//获取相应的对象
	public static EntityManager getFactory() {
		return factory.createEntityManager();
	}

}
