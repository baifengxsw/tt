package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerService {
	public List<Customer> find();

	public void save(Customer customer);
}
