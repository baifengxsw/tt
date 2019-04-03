package cn.itcast.store.service.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.mchange.v2.codegen.bean.BeangenUtils;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.dao.DaoImpl.ProductDaoImpl;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.utils.BeanFactory;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao = (ProductDao) BeanFactory.createObject("ProductDao");
	

	public List<Product> findHots() throws SQLException {
		// TODO �Զ����ɵķ������
		return productDao.findHots();
	}

	public List<Product> findNews() throws SQLException {
		// TODO �Զ����ɵķ������
		return productDao.findNews();
	}

	public Product findProductByPid(String pid)throws SQLException {
		
		return productDao.findProductByPid(pid);
	}

	public PageBean<Product> findByCid(String cid, int pageNumber, int pageSize) throws SQLException {
		int totalRecord = productDao.findTotalRecordByCid(cid);
		//2��װ����
		PageBean<Product> pageBean = new PageBean<Product>(pageNumber, totalRecord, pageSize);
		//��ҳ����
		List<Product> data = productDao.findAllByCid(cid,pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		pageBean.setUrl("ProductServlet?method=findByCid&cid="+cid);
		return pageBean;
	}

	public PageBean<Product> findAllProduct(int curNum) throws SQLException {
		int totalRecords = productDao.findTotalProduct();
		PageBean<Product> pb = new PageBean<Product>(curNum, totalRecords, 6);
		//��ʵ��߿��Է���һ��list
		productDao.findAllProduct(pb);
		//����url
		pb.setUrl("AdminProductServlet?method=findAllProductsWithPage");
		
		
		return pb;
	}

	public void addProduct(Product product) throws SQLException {
		productDao.addProduct(product);
		return ;
	}

}
