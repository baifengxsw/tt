package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.Customer;

public interface CustomerDao {
	public List<Customer> findAll();
}
