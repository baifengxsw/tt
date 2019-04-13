package it.cast01.ognl;

import org.junit.Test;

import it.cast01.domain.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * OGNL��java�����µ�ʹ��
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//OGNL���ö���ķ���  
	public void demo1() throws OgnlException{
		//���Context
		OgnlContext context= new OgnlContext();
		//�����Ӧ�ĸ�����
		Object root = context.getRoot();
		Object obj = Ognl.getValue("'hello'.length()", context, root);//5
		System.out.println(obj);
	}
	@Test
	//OGNL���ö���ľ�̬����  @����@������ 
	public void demo2() throws OgnlException{
		//���Context
		OgnlContext context= new OgnlContext();
		//�����Ӧ�ĸ�����
		Object root = context.getRoot();
		Object obj = Ognl.getValue("@java.lang.Math@random()", context, root);//5
		System.out.println(obj);
	}
	@Test
	//OGNL����root�е����� 
	public void demo3() throws OgnlException{
		//���Context
		OgnlContext context= new OgnlContext();
		//�����Ӧ�ĸ�����
		context.setRoot(new User("xia","1213"));
		Object root = context.getRoot();
		Object username = Ognl.getValue("username", context, root);//5
		Object password = Ognl.getValue("password", context, root);//5
		System.out.println("username"+username);
		System.out.println("password"+password);
	}
	@Test
	//OGNL����context�е����� 
	public void demo4() throws OgnlException{
		//���Context
		OgnlContext context= new OgnlContext();
		//�����Ӧ�ĸ�����
		context.put("user", new User("xia","123321"));
		Object root = context.getRoot();
		Object user= Ognl.getValue("#user", context, root);//5
		
		System.out.println(user);
	}
}
