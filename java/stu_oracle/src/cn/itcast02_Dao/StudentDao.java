package cn.itcast02_Dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast03_bin.Student;

/**
 * ���ﶨ������Ա�����ݿ����
 * @author baifeng
 *�����������׳����쳣 ,����Ҳ�����׳��쳣
 */
public interface StudentDao {
	/**
	 * ��ѯ���е��û���Ϣ
	 */
	List<Student> findAll() throws SQLException;
	/**
	 * ����һ����Ϣ
	 * @param student
	 * @return
	 * @throws SQLException
	 */
    int insert(Student student) throws SQLException;
    /**
     * ����sidɾ��һ����¼
     * @param sid
     * @return
     * @throws SQLException
     */
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
