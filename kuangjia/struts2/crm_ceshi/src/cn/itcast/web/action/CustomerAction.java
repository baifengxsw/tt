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
		//ҳ�����ת
		ActionContext.getContext().getValueStack().set("list",list);;
		return "findsuccess";
	}
	/**
	 * ��ת�����ҳ��ķ���
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * �����û�
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
		// TODO �Զ����ɵķ������
		return customer;
	}
}
