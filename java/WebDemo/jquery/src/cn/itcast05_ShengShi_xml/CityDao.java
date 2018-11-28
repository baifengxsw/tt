package cn.itcast05_ShengShi_xml;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
	/**
	 * 查询相应pid的省份所对应的城市
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
		
	List<Citys> queryCity(int pid) throws SQLException;
}
