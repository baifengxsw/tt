package cn.itcast06_Service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast02_Dao.StudentDao;
import cn.itcast03_bin.Student;
import cn.itcast04_DaoImpl.StudentDaoImpl;

/**
 * 这是学生业务实现 对应业务逻辑层
 * @author baifeng
 *
 */
public class StudentServiceImpl implements StudentService {

	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	public int insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.insert(student);
	}

	public int delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.delete(sid);
	}

	public Student findDataBySid(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findDataBySid(sid);
	}

	public int update(Student stu) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.update(stu);
	}

	public List<Student> findDataByTerm(String sname, String sgender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		
		return dao.findDataByTerm(sname, sgender);
	}

}
