package cn.itcast.crm.web.action;
/**
 * 客户action类
 * @author baifeng
 *
 */

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;

public class CustomerAction extends ActionSupport {
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * 列出所有用户的信息 ，返回给list.jsp
	 */
	public String list() {
		//查出所有的客户信息
		List<Customer> customerList = customerService.findAll();
		//servlet 的上下文
		ActionContext.getContext().put("list", customerList);
		return SUCCESS;
	}
}
