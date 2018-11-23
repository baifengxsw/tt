package cn.itcast04_DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.PreparedStatement;

import cn.itcast02_Dao.StudentDao;
import cn.itcast03_bin.Student;
import cn.itcast05_Utils.C3P0Utils;

public class StudentDaoImpl implements StudentDao {

	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from stu";
		list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

}
