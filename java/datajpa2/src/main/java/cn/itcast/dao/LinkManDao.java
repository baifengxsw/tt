package cn.itcast.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;


public interface LinkManDao extends JpaRepository<LinkMan, Long>,JpaSpecificationExecutor<Customer> {
		@Query(value="from LinkMan")
	public List<LinkMan> findAll();
}
