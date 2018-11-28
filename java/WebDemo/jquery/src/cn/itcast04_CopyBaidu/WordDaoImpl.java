package cn.itcast04_CopyBaidu;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class WordDaoImpl implements WordDao{



	public List<Word> findWords(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		List<Word>list =runner.query("select * from words where word like ? limit ?", new BeanListHandler<Word>(Word.class),word+"%",4);
		return list;
	}

}
