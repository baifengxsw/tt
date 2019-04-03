package cn.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.SQLError;

import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.Product;

public interface ProductService {

	List<Product> findHots() throws SQLException;

	List<Product> findNews() throws SQLException;

	Product findProductByPid(String pid) throws SQLException;

	PageBean<Product> findByCid(String cid, int pageNumber, int pageSize)throws SQLException;

	PageBean<Product> findAllProduct(int curNum)throws SQLException;

	void addProduct(Product product)throws SQLException;

}
