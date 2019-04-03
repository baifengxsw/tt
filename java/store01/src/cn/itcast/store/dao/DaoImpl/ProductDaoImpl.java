package cn.itcast.store.dao.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.Product;
import cn.itcast.store.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	public List<Product> findHots() throws SQLException {
		String sql = "select * from product where pflag=0 and is_hot=1 order by pdate desc limit 0,9";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}

	public List<Product> findNews() throws SQLException {
		String sql = "select * from product where pflag=0 order by pdate desc limit 0,9";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
		
	}

	public Product findProductByPid(String pid) throws SQLException {
		String sql = "select * from product where pid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Product>(Product.class),pid);
	}

	public int findTotalRecordByCid(String cid) throws SQLException {
		String sql = "select count(*) from product where cid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long count = (Long)qr.query(sql, new ScalarHandler(),cid);
		return count.intValue();
	}

	public List<Product> findAllByCid(String cid, int startIndex, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from product where cid = ? and pflag =? order by pdate desc limit ?,?";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),cid,0,startIndex,pageSize);
				
		return list;
	}

	public int findTotalProduct() throws SQLException {
		String sql = "select count(*) from product";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long ret = (Long) qr.query(sql, new ScalarHandler());
		return ret.intValue();
	}

	public void findAllProduct(PageBean<Product> pb) throws SQLException {
		String sql = "select * from product order by pdate desc limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),pb.getStartIndex(),pb.getPageSize());
		pb.setData(list);
	}

	public void addProduct(Product product) throws SQLException {
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object [] params = {product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid()};
		qr.update(sql, params);
				
		}
		
	}


