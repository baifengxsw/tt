package it.cast01.valuestack;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import it.cast01.domain.User;

/**
 * 操作值栈中的数据 方式二 调用值栈中的方法实现
 * @author baifeng
 *
 */
public class ValueStackDemo3 extends ActionSupport{


	@Override
	public String execute() throws Exception {
		
		
		ValueStack valueStack  = ActionContext.getContext().getValueStack();
		//对象使用push(OBject obj)  集合set(String key ,Object obj);
		User user1 = new User("xia","123");
		User user2 = new User("shuang","321");
		HashMap<String ,User> map = new HashMap<>();
		map.put("one", user1);
		map.put("two", user2);
		valueStack.set("map", map);
		return SUCCESS;
	}
}
