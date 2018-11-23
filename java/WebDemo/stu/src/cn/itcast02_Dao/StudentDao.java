package cn.itcast02_Dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast03_bin.Student;

/**
 * 这里定义了针对表的数据库操作
 * @author baifeng
 *在这里子类抛出了异常 ,父类也必须抛出异常
 */
public interface StudentDao {
	/**
	 * 查询所有的用户信息
	 */
	List<Student> findAll() throws SQLException;
}
