package cn.itcast02_dao;

import java.util.List;

import cn.itcast03_bin.Student;
/**
 * 查询所有的学生列子集合
 * @author baifeng
 * @return list<Student>
 */
public interface StuDao {
	List<Student>  findAll();
}
