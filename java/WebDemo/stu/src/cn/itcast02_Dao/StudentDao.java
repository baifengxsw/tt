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
}
