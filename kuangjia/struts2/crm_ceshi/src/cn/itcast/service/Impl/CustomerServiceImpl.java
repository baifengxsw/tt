package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.Impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerdao =  new CustomerDaoImpl();
	
	public List<Customer> find() {
		
		return customerdao.find();
	}
	
	public void save(Customer customer) {
		customerdao.save(customer);
	}

}
