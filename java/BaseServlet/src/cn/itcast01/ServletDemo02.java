package cn.itcast01;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo02
 */
public class ServletDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String md = request.getParameter("method");
		String retAddress = null;
		//��߲���ͨ������������ ����if else  ����е�ǰ���ֽ��� ����ֱ���õ�class �ļ� ��ֱ�ӵ���һ�¾ͺ� ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	public String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ѧ��");
		return "text.html";
	}
	public String checkStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ѧ��");
		return null;
	}
	public String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ɾ��ѧ��");
		return "text.html";
	}
		
}
