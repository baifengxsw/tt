package cn.itcast01.tx.demo3;
/**
 * ת�˵�Dao�ӿ�
 * @author baifeng
 *
 */
public interface AccountDao {
	public void outMoney(String from ,Double money);
	public void inMoney(String in,Double money);
}
