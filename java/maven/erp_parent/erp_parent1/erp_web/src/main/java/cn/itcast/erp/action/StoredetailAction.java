package cn.itcast.erp.action;
import java.util.List;

import javax.mail.MessagingException;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.IStoredetailBiz;
import cn.itcast.erp.entity.Storealert;
import cn.itcast.erp.entity.Storedetail;
import cn.itcast.erp.exception.ErpException;

/**
 * 仓库库存Action 
 * @author Administrator
 *
 */
public class StoredetailAction extends BaseAction<Storedetail> {

	private IStoredetailBiz storedetailBiz;

	public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
		this.storedetailBiz = storedetailBiz;
		super.setBaseBiz(this.storedetailBiz);
	}
	
	/**
	 * 实现库存预警列表
	 * 
	 */
	public void storealertList() {
		List<Storealert> sList = storedetailBiz.getStorealertList();
		write(JSON.toJSONString(sList));
	}
	
	/**
	 * 发送预警邮件
	 */
	public void sendStorealertMail() {
		
		//调用预警业务发送邮件
		try {
			storedetailBiz.sendStoreAlertMail();
			ajaxReturn(true, "发送预警邮件成功");
		} catch (MessagingException e) {
			ajaxReturn(false,"构建预警邮件失败");
		}catch(ErpException e) {
			ajaxReturn(false, e.getMessage());
		}catch(Exception e) {
			ajaxReturn(false, "发送邮件失败");
			
		}
	}
}
