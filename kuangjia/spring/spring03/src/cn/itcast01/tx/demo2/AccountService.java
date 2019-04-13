package cn.itcast01.tx.demo2;
/**
 * 转账的业务层接口
 * @author baifeng
 *
 */
public interface AccountService {
	
	public void transfer(String from,String to ,Double money);
}
