package cn.itcast05_ShengShi_xml;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
	/**
	 * ��ѯ��Ӧpid��ʡ������Ӧ�ĳ���
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
		
	List<Citys> queryCity(int pid) throws SQLException;
}
