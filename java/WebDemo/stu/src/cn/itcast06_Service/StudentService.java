package cn.itcast06_Service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast03_bin.Student;

/**
 * 在这里一个dao对应一个service 对应业务处理规范
 * @author baifeng
 *
 */
public interface StudentService {
	/**
	 * 处理全部学生查询
	 */
	List<Student> findAll() throws SQLException;
	/**
	 * 插入一条消息
	 * @param student
	 * @return
	 * @throws SQLException
	 */
    int insert(Student student) throws SQLException;
    
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
