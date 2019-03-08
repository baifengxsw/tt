package cn.itcast01;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String md = request.getParameter("method");
		String retAddress = null;
		//这边部分通过反射来处理 减少if else  如果有当前的字节码 ，我直接拿到class 文件 ，直接调用一下就好 了
		Class clazz = this.getClass();
		System.out.println("md:"+md);
		Method method;
		try {
			method = clazz.getMethod(md, HttpServletRequest.class,HttpServletResponse.class);
			if(method!=null) {
				retAddress = (String)method.invoke(this, request,response);
			}
			if(retAddress!=null) {
				request.getRequestDispatcher(retAddress);
			}
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
       
  

}
