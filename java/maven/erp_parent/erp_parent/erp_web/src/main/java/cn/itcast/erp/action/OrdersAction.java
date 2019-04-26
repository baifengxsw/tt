package cn.itcast.erp.action;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.IOrdersBiz;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.exception.ErpException;

/**
 * 订单Action 
 * @author Administrator
 *
 */
public class OrdersAction extends BaseAction<Orders> {

	private IOrdersBiz ordersBiz;

	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
		super.setBaseBiz(this.ordersBiz);
	}
	/**
	 * 用于接受订单明细的json格式的字符串,数组形式,每一个订单明细
	 */
	private String json;

	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	//返回格式 success:true,message:''
	public void add() {
		try {
			System.out.println(json);
			Emp loginUser = getLoginUser();
			if(loginUser==null) {
				//用户没有登录
				ajaxReturn(false, "亲，你还没有登录");
				return ;
			}
			Orders orders = getT();
			orders.setCreater(loginUser.getUuid());
			
			List<Orderdetail> detailList = JSON.parseArray(json, Orderdetail.class);
			orders.setOrderDetails(detailList);
			ordersBiz.add(orders);
			ajaxReturn(true, "添加订单成功");
		} catch (Exception e) {
			ajaxReturn(false, "添加失败");
		}
	}
	/**
	 * 进行采购订单审核
	 */
	public void doCheck() {
		//得到当前登录用户的 
		Emp loginUser = getLoginUser();
		if(null == loginUser) {
			//用户没有登录 session 失效
			ajaxReturn(false, "亲，请你先登录啊");
			return ;
		}
		try {
			ordersBiz.doCheck(getId(), loginUser.getUuid());
			ajaxReturn(true, "审核成功");;
			
		} catch (ErpException e) {
			ajaxReturn(false,e.getMessage());
			
		}catch (Exception e) {
			ajaxReturn(false, "审核失败");
		}
	}
	
	/**
	 * 进行采购订单确认
	 */
	public void doStart() {
		//得到当前登录用户的
		Emp loginUser = getLoginUser();
		if(null == loginUser) {
			//用户没有登录 session 失效
			ajaxReturn(false, "亲，请你先登录啊");
			return ;
		}
		try {
			ordersBiz.doStart(getId(), loginUser.getUuid());
			ajaxReturn(true, "确认成功");;
			
		} catch (ErpException e) {
			ajaxReturn(false,e.getMessage());
			
		}catch (Exception e) {
			ajaxReturn(false, "确认失败");
		}
	}
	
	/**
	 * 只显示自身的创建订单订单
	 */
	public void myListByPage() {
		//如果前端没有传过来查询条件
		if(null == getT1()) {
			setT1(new Orders());
		}
		//进行查询条件的设置 
		Emp loginUser = getLoginUser();
		if(loginUser==null) {
			ajaxReturn(false,"亲，请重新登录啊");
			return ;
		}
		
		getT1().setCreater(loginUser.getUuid());
		super.listByPage();
	}
	
	

}
