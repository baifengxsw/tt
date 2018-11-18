package cn.itcast01_goods;

import javax.servlet.http.Cookie;

public class CookieUtil {
	//������Ϊ������
	/**
	 * ��һ��Cookie�������ҵ�һ������������Ҫ��Cookie����
	 * 
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static Cookie findCookie(Cookie [] cookies,String name){
		if(cookies !=null){
			for(Cookie c:cookies){
				if(c.getName().equals(name)){
					return c;
				}
			}
		}
		return null;
	}
}
