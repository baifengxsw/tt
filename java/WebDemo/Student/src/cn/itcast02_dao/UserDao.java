package cn.itcast02_dao;
/**
 * �������ݿ��¼��صĲ����ӿ�
 * @author baifeng
 *
 */
public interface UserDao {
  /**
   * ����򵥷���boolean���� ,�ɹ�����ʧ�� ����,������¼�ɹ��ͷ����û�������Ϣ 
   *@return true ��¼�ɹ�  false ��¼ʧ��
   */
	boolean login(String username, String password);
	
}
