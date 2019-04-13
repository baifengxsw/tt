package cn.itcast01.dao;

import java.util.List;

import cn.itcast01.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Customer customer);
	
	Customer findById(Long cust_id);
	
	List<Customer> findAllByHQL();
	List<Customer> findAllByQBC();

}
