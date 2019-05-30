package cn.itcast.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Long>,JpaSpecificationExecutor<Customer> {
		@Query(value="from Customer")
	public List<Customer> findAll();
}
