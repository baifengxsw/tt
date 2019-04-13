package cn.itcast01.tx.demo2;
/**
 * 转账的Dao接口
 * @author baifeng
 *
 */
public interface AccountDao {
	public void outMoney(String from ,Double money);
	public void inMoney(String in,Double money);
}
