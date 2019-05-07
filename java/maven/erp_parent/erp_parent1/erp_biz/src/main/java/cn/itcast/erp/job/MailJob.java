package cn.itcast.erp.job;
/**
 * 后台定时检测库存报警
 * 如果存在库存预警 ，则发预警邮件给相关的工作人员
 * @author baifeng
 *
 */



import java.util.List;

import javax.mail.MessagingException;

import cn.itcast.erp.biz.IStoredetailBiz;
import cn.itcast.erp.entity.Storealert;

public class MailJob {
	/**
	 * 商品库存业务
	 */
	private IStoredetailBiz storedetailBiz;
	
	public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
		this.storedetailBiz = storedetailBiz;
	}

	public void sendStorealertMail() {
		//查询是否存在库存预警
		List<Storealert> storealertList = storedetailBiz.getStorealertList();
		if(storealertList.size()>0) {
			try {
				//调用 业务发送预警邮件
				storedetailBiz.sendStoreAlertMail();
				System.out.println("已经发送");
				
			}catch(MessagingException e) {
				e.printStackTrace();
			}
		}
		
	}
}
