package it.cast01.valuestack;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 获得valuestack对象
 * @author baifeng
 *
 */
public class ValueDemo2 extends ActionSupport {
		@Override
		public String execute() throws Exception {
			//一种 ：通过ActionContext来获得
			ValueStack stack = ActionContext.getContext().getValueStack();
			//通过request来获得
			ValueStack stack1 =(ValueStack)ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
			System.out.println(stack==stack1);
			return NONE;
		}
}
