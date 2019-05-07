package cn.itcast.erp.biz.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import cn.itcast.erp.biz.IStoredetailBiz;
import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.dao.IStoreDao;
import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storealert;
import cn.itcast.erp.entity.Storedetail;
import cn.itcast.erp.exception.ErpException;
import cn.itcast.erp.util.MailUtil;
/**
 * 仓库库存业务逻辑类
 * @author Administrator
 *
 */
public class StoredetailBiz extends BaseBiz<Storedetail> implements IStoredetailBiz {

	private IStoredetailDao storedetailDao;
	private IGoodsDao goodsDao;
	private IStoreDao storeDao;
	private MailUtil mailUtil;
	/**邮件接收者*/
	private String to;
	/**邮件的主题*/
	private String subject;
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setText(String text) {
		this.text = text;
	}
	/**邮件正文*/
	private String text;
	
	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public void setStoreDao(IStoreDao storeDao) {
		this.storeDao = storeDao;
	}
	public void setStoredetailDao(IStoredetailDao storedetailDao) {
		this.storedetailDao = storedetailDao;
		super.setBaseDao(this.storedetailDao);
	}
	/**
	 * 重写分页
	 */
	@Override
	public List<Storedetail> getListByPage(Storedetail t1, Storedetail t2, Object param, int firstResult,
			int maxResults) {
		List<Storedetail> list =  super.getListByPage(t1, t2, param, firstResult, maxResults);
		Map<Long,String> goodsNameMap  = new HashMap<>();
		Map<Long,String> storeNameMap = new HashMap<>();
		for(Storedetail storedetail:list) {
			storedetail.setGoodName(getGoodsName(storedetail.getGoodsuuid(), goodsNameMap,goodsDao));
			storedetail.setStoreName(getStoreName(storedetail.getStoreuuid(), storeNameMap,storeDao));
		}
		
		return list;
		
	}
	@Override
	public List<Storealert> getStorealertList() {
		return storedetailDao.getStorealertList();
	}
	@Override
	public void sendStoreAlertMail() throws MessagingException {
		//查看是否有存在需要预警的商品
		List<Storealert> sList = storedetailDao.getStorealertList();
		int size = sList ==null? 0:sList.size();
		if(size >0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			mailUtil.sendMail(to, subject.replace("[time]", sdf.format(new Date())), text.replace("[count]", size+""));
			
		}else {
			throw new ErpException("没有需要预警的商品");
		}
		
	}
	
	
	
	
	
}
