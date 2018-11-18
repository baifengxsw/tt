package cn.itcast01_goods;

import javax.servlet.http.Cookie;

public class CookieUtil {
	//这是作为工具类
	/**
	 * 从一个Cookie数组中找到一个具体我们想要的Cookie对象
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
