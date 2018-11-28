package cn.itcast05_ShengShi_xml;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast04_CopyBaidu.C3P0Utils;

public class CityDaoImpl implements CityDao {

	public List<Citys> queryCity(int pid) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		List<Citys> list = runner.query("select * from citys where pid = ?",new BeanListHandler<Citys>(Citys.class), pid);
		return list;
	}

}
