package cn.itcast01.tx.demo2;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * ת�˵�ʵ����
 * @author baifeng
 *
 */
public class AccountServiceImpl implements AccountService {
	//���ﲻ�ǲ����� ���ܿ���resource
	
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	//ע����������ģ��
/*	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}*/




	@Override
	public void transfer(final String from, final String to, final Double money) {
	
				
				accountDao.outMoney(from, money);
//				int a =10/0;
				accountDao.inMoney(to, money);
			
	}

}
