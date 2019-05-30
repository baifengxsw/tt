package cn.itcast.demo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Demo2 {
	@Autowired
	private CustomerDao customerDao;
	@Test
	public void test() {
		Specification<Customer>spec = new Specification<Customer>() {

			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO 自动生成的方法存根
				return cb.equal(root.get("custName"), "xia1");
			}
			
		};
		Sort sort = new Sort(Direction.ASC,"custAddress");
		List<Customer> list = customerDao.findAll(spec,sort);
		for(Customer cust :list) {
			System.out.println(cust);
		}
		
	}
	//实现复杂的分页查询
	@Test
	public void test1() {
		Specification<Customer>spec = new Specification<Customer>() {
			
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate ee = cb.equal(root.get("custName"), "xia1");
				Predicate ee1 = cb.like(root.get("custAddress").as(String.class), "%d%");
				
				
				return  cb.and(ee,ee1) ;
			}
			
		};
		Pageable page = new PageRequest(0,1);
	
		Page<Customer> pages = customerDao.findAll(spec, page);
		List<Customer> list = pages.getContent();
		for(Customer cust:list) {
			System.out.println(cust);
			
		}
	
		System.out.println(pages.getNumber());
		
		//获得总页数
		System.out.println(pages.getTotalPages());
		//获得总记录数
		System.out.println(pages.getTotalElements());
	}
}
