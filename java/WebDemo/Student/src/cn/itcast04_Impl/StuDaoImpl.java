package cn.itcast04_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast02_dao.JDBCUtils;
import cn.itcast02_dao.StuDao;
import cn.itcast03_bin.Student;

public class StuDaoImpl implements StuDao {

	public List<Student> findAll() {
		List <Student> list = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConn();
			String sql = "select * from m_stu";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getString("gender"));
				stu.setAddress(rs.getString("address"));
				
				list.add(stu);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(con);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		return list;
	}

}
