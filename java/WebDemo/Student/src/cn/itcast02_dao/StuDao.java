package cn.itcast02_dao;

import java.util.List;

import cn.itcast03_bin.Student;
/**
 * ��ѯ���е�ѧ�����Ӽ���
 * @author baifeng
 * @return list<Student>
 */
public interface StuDao {
	List<Student>  findAll();
}
