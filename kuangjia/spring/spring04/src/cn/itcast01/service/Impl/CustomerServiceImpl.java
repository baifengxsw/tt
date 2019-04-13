package cn.itcast01.service.Impl;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast01.dao.CustomerDao;
import cn.itcast01.domain.Customer;
import cn.itcast01.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//ע��dao
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("customerService ����ִ����");
		customerDao.save(customer);
	}

}
