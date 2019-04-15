package cn.itcast.crm.service.Impl;

import java.util.List;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao ;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
