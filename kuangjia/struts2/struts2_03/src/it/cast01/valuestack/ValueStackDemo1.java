package it.cast01.valuestack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * valueStack的内部结构
 * @author baifeng
 *
 */
public class ValueStackDemo1 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		
		
		ValueStack valueStack  = ActionContext.getContext().getValueStack();
		
		
		return NONE;
	}
}
