package com.redsum.bos.ws.impl;

import java.util.List;

import com.redsum.bos.biz.IWaybillBiz;
import com.redsum.bos.biz.IWaybilldetailBiz;
import com.redsum.bos.entity.Waybill;
import com.redsum.bos.entity.Waybilldetail;
import com.redsum.bos.ws.IWaybillWs;

public class WaybillWs implements IWaybillWs {
	
	private IWaybillBiz waybillBiz;
	private IWaybilldetailBiz waybilldetailBiz;

	public void setWaybillBiz(IWaybillBiz waybillBiz) {
		this.waybillBiz = waybillBiz;
	}

	public void setWaybilldetailBiz(IWaybilldetailBiz waybilldetailBiz) {
		this.waybilldetailBiz = waybilldetailBiz;
	}

	/**
	 * 查询运单详情
	 * @param id
	 * @return
	 */
	public List<Waybilldetail> waybilldetailList(Long sn) {
		//构建查询条件
		Waybilldetail waybilldetail = new Waybilldetail();
		waybilldetail.setSn(sn);
		return waybilldetailBiz.getList(waybilldetail, null, null);
	}

	@Override
	public Long addWaybill(Long id, String toAddress, String addressee, String tele, String info) {
		Waybill waybill = new Waybill();
		waybill.setToaddress(toAddress);
		waybill.setInfo(info);
		waybill.setState("0");
		waybill.setTele(tele);
		waybill.setAddressee(addressee);
		waybill.setUserid(id);
		waybillBiz.add(waybill);
		return waybill.getSn();
	}

}
