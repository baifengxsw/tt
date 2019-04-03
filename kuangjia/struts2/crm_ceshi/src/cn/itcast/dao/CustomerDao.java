package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerDao {
	 List<Customer> find();

	void save(Customer customer);
}
