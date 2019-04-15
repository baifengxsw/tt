package cn.itcast.crm.web.action;
/**
 * �ͻ�action��
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
	 * �г������û�����Ϣ �����ظ�list.jsp
	 */
	public String list() {
		//������еĿͻ���Ϣ
		List<Customer> customerList = customerService.findAll();
		//servlet ��������
		ActionContext.getContext().put("list", customerList);
		return SUCCESS;
	}
}
