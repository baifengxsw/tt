package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.Product;

public interface ProductDao {

	List<Product> findHots() throws SQLException ;

	List<Product> findNews() throws SQLException;

	Product findProductByPid(String pid) throws SQLException;

	int findTotalRecordByCid(String cid) throws SQLException;

	List<Product> findAllByCid(String cid, int startIndex, int pageSize) throws SQLException;

	int findTotalProduct() throws SQLException;

	void findAllProduct(PageBean<Product> pb) throws SQLException;

	void addProduct(Product product) throws SQLException;

	



}
