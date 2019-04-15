package cn.itcast.crm.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	public List<Customer> findAll(){
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}
}
