package cn.itcast02_Dao;

import java.sql.SQLException;

import cn.itcast03_bin.User;

public interface UserDao {
  /**
   * ����򵥷���boolean���� ,�ɹ�����ʧ�� ����,������¼�ɹ��ͷ����û�������Ϣ 
   *@return �û���Ϣ ��¼�ɹ�  false ��¼ʧ��
 * @throws SQLException 
   */
		User login(String username, String password) throws SQLException;
	/**
	 * ���ڼ���û����Ƿ����
	 * @param username
	 * @return
	 */
	boolean checkUserName(String username) throws SQLException;
	/**
	 * ����һ������Ա�û�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int insert(User user) throws SQLException;
}
