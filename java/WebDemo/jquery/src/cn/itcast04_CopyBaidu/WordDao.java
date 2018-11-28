package cn.itcast04_CopyBaidu;

import java.sql.SQLException;
import java.util.List;

public interface WordDao {
	/**
	 * 依据检索返回对应的数据
	 * @param username
	 * @return
	 */
	List<Word> findWords(String word) throws SQLException;
}
