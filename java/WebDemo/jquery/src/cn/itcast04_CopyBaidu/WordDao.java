package cn.itcast04_CopyBaidu;

import java.sql.SQLException;
import java.util.List;

public interface WordDao {
	/**
	 * ���ݼ������ض�Ӧ������
	 * @param username
	 * @return
	 */
	List<Word> findWords(String word) throws SQLException;
}
