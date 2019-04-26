package cn.itcast.erp.action;
import cn.itcast.erp.biz.ISupplierBiz;
import cn.itcast.erp.entity.Supplier;

/**
 * 供应商Action 
 * @author Administrator
 *
 */
public class SupplierAction extends BaseAction<Supplier> {

	private ISupplierBiz supplierBiz;
	
	//接受变动参数
	private String q;
	
	public void setQ(String q) {
		this.q = q;
	}

	public String getQ() {
		return q;
	}

	public void setSupplierBiz(ISupplierBiz supplierBiz) {
		this.supplierBiz = supplierBiz;
		super.setBaseBiz(this.supplierBiz);
	}
	
	public void list() {
		//判断查询条件是否为空
		if(null==getT1()) {
			//构建查询条件
		}
		getT1().setName(q);
		super.list();
	}

}
