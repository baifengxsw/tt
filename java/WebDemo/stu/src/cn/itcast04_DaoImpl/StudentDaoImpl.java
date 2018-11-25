package cn.itcast04_DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.PreparedStatement;

import cn.itcast02_Dao.StudentDao;
import cn.itcast03_bin.Student;
import cn.itcast05_Utils.C3P0Utils;

public class StudentDaoImpl implements StudentDao {
	/**
	 * 查询所有学生
	 * @return 返回list<student>
	 */
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from stu";
		list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	public int insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		int ret = runner.update("insert into stu values(null,?,?,?,?,?,?)",student.getSname(),
				student.getGender(),student.getPhone(),student.getBirthday(),student.getHobby(),student.getInfo());
		return ret;
	}

	public int delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		int ret = runner.update("delete from stu where sid = ?",sid);
		return  ret;
	}

	public Student findDataBySid(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		Student stu = new Student();
		stu = runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class),sid);
		return stu;
	}

	public int update(Student stu) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		int ret = runner.update("update stu set sname=?, gender=?,phone=?,birthday =?,hobby=?,info = ? where sid = ?",stu.getSname(),stu.getGender(),stu.getPhone()
				,stu.getBirthday(),stu.getHobby(),stu.getInfo(),stu.getSid());
			return ret;
	}

	public List<Student> findDataByTerm(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//应该是这样的 如果same 和 sgender 都不为空   都进行查询
		// 如果有一个为空 ,那么仅仅查询一个
		//如果都没有则查询所有
		List<String> list = new ArrayList<String>() ;
		String sql = "select * from stu where 1=1 ";
		if(!C3P0Utils.isEmpty(sname)){
			sql += "and sname like ? ";
			list.add("%"+sname+"%");
		}
		if(!C3P0Utils.isEmpty(sgender)){
			sql += "and gender = ?";
			list.add(sgender);
		}
	
		return runner.query(sql, new BeanListHandler<Student>(Student.class) ,list.toArray());
	}
	
	
	

}
