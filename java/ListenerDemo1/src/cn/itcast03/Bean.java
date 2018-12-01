package cn.itcast03;


import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean  implements HttpSessionBindingListener{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("绑定成功");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("绑定失败");
	}
	
}
