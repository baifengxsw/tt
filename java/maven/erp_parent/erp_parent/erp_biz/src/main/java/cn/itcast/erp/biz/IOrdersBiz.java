package cn.itcast.erp.biz;
import cn.itcast.erp.entity.Orders;
/**
 * 订单业务逻辑层接口
 * @author Administrator
 *
 */
public interface IOrdersBiz extends IBaseBiz<Orders>{
	/**
	 * 进行订单的审核 do * 设计数据库的更新动作
	 * @param uuid 订单编号
	 * @param empUuid 审核员
	 */
	void doCheck(Long uuid,Long empUuid);
	
	/**
	 * 进行订单的确认 
	 * @param uuid 订单编号 
	 * @param empUuid 审核员
	 */
	void doStart(Long uuid,Long empUuid);
}

