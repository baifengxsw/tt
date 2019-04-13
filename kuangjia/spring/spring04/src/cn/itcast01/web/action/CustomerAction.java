package cn.itcast01.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast01.domain.Customer;
import cn.itcast01.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		
		return customer;
	}
	//自动注入
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 保存客户的方法：save
	 */
	public String save() {
		//传统方式获取业务层的类
//		WebApplicationContext applicationContext  = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
//		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.save(customer);
		System.out.println("Action中的save方法执行了");
		return NONE;
	}


}
