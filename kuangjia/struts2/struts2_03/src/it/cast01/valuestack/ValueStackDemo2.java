package it.cast01.valuestack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import it.cast01.domain.User;

/**
 * 操作值栈中的数据
 * @author baifeng
 *
 */
public class ValueStackDemo2 extends ActionSupport{
	private User user;
	
	public User getUser() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		
		user = new User ("xia","123");
		ValueStack valueStack  = ActionContext.getContext().getValueStack();
		
		
		return SUCCESS;
	}
}
