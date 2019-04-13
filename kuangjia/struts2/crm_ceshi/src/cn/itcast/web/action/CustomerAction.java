package cn.itcast.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.Impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer();
	public String find() {
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> list = customerService.find();
		//页面的跳转
		ActionContext.getContext().getValueStack().set("list",list);;
		return "findsuccess";
	}
	/**
	 * 跳转到添加页面的方法
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * 保存用户
	 * 
	 * 
	 */
	public String save() {
		CustomerService customerService = new CustomerServiceImpl();
		customerService.save(customer);
		return "savesuccess";
	}
	@Override
	public Customer getModel() {
		// TODO 自动生成的方法存根
		return customer;
	}
}
