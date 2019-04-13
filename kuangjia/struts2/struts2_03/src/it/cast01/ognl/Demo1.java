package it.cast01.ognl;

import org.junit.Test;

import it.cast01.domain.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * OGNL在java环境下的使用
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//OGNL调用对象的方法  
	public void demo1() throws OgnlException{
		//获得Context
		OgnlContext context= new OgnlContext();
		//获得相应的根对象
		Object root = context.getRoot();
		Object obj = Ognl.getValue("'hello'.length()", context, root);//5
		System.out.println(obj);
	}
	@Test
	//OGNL调用对象的静态方法  @类名@方法名 
	public void demo2() throws OgnlException{
		//获得Context
		OgnlContext context= new OgnlContext();
		//获得相应的根对象
		Object root = context.getRoot();
		Object obj = Ognl.getValue("@java.lang.Math@random()", context, root);//5
		System.out.println(obj);
	}
	@Test
	//OGNL访问root中的数据 
	public void demo3() throws OgnlException{
		//获得Context
		OgnlContext context= new OgnlContext();
		//获得相应的根对象
		context.setRoot(new User("xia","1213"));
		Object root = context.getRoot();
		Object username = Ognl.getValue("username", context, root);//5
		Object password = Ognl.getValue("password", context, root);//5
		System.out.println("username"+username);
		System.out.println("password"+password);
	}
	@Test
	//OGNL访问context中的数据 
	public void demo4() throws OgnlException{
		//获得Context
		OgnlContext context= new OgnlContext();
		//获得相应的根对象
		context.put("user", new User("xia","123321"));
		Object root = context.getRoot();
		Object user= Ognl.getValue("#user", context, root);//5
		
		System.out.println(user);
	}
}
