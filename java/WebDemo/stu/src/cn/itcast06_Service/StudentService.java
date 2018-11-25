package cn.itcast06_Service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast03_bin.Student;

/**
 * ������һ��dao��Ӧһ��service ��Ӧҵ����淶
 * @author baifeng
 *
 */
public interface StudentService {
	/**
	 * ����ȫ��ѧ����ѯ
	 */
	List<Student> findAll() throws SQLException;
	/**
	 * ����һ����Ϣ
	 * @param student
	 * @return
	 * @throws SQLException
	 */
    int insert(Student student) throws SQLException;
    
    int delete(int sid) throws SQLException;
    
    /**
     * ����sid��ѯһ����¼
     * @param sid
     * @return
     * @throws SQLException
     */
    Student findDataBySid(int sid) throws SQLException;
    
    /**
     * ����stu��������
     * @param stu
     * @return
     * @throws SQLException
     */
    int update(Student stu) throws SQLException;
    /**
     * ͨ���õ���sname ��sgender ����ѯ����
     *
     * @param sname
     * @param sgender
     * @return
     * @throws SQLException
     */
    List<Student> findDataByTerm(String sname,String sgender) throws SQLException;
}
