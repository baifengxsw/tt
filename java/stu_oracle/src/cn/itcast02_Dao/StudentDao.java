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
	/**
	 * 插入一条消息
	 * @param student
	 * @return
	 * @throws SQLException
	 */
    int insert(Student student) throws SQLException;
    /**
     * 依据sid删除一条记录
     * @param sid
     * @return
     * @throws SQLException
     */
    int delete(int sid) throws SQLException;
    
    /**
     * 根据sid查询一条记录
     * @param sid
     * @return
     * @throws SQLException
     */
    Student findDataBySid(int sid) throws SQLException;
    
    /**
     * 根据stu更新数据
     * @param stu
     * @return
     * @throws SQLException
     */
    int update(Student stu) throws SQLException;
    
    /**
     * 通过得到的sname 和sgender 来查询数据
     *
     * @param sname
     * @param sgender
     * @return
     * @throws SQLException
     */
    List<Student> findDataByTerm(String sname,String sgender) throws SQLException;
}
