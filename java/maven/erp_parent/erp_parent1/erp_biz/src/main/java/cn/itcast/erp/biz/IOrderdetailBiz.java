package cn.itcast.erp.biz;
import cn.itcast.erp.entity.Orderdetail;
/**
 * 订单明细业务逻辑层接口
 * @author Administrator
 *
 */
public interface IOrderdetailBiz extends IBaseBiz<Orderdetail>{
	/**
	 * 进行相应的入库操作
	 * @param uuid  订单明细id
	 * @param storeuuid 仓库编号
	 * @param empuuid 操作人
	 */
	public void doInStore(Long uuid,Long storeuuid,Long empuuid) ;
	/**
	 * 进行相应的出库操作
	 * @param uuid  订单明细id
	 * @param storeuuid 仓库编号
	 * @param empuuid 操作人
	 */
	public void doOutStore(Long uuid,Long storeuuid,Long empuuid) ;
	
	
}

