package cn.itcast.erp.entity;

/**
 * 用于库存报警
 */

public class Storealert {
	private Long uuid ; //商品编号
	private String name ; //商品名称
	private Long storenum ;//库存数
	private Long outnum ; //待发货数目
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getStorenum() {
		return storenum;
	}
	public void setStorenum(Long storenum) {
		this.storenum = storenum;
	}
	public Long getOutnum() {
		return outnum;
	}
	public void setOutnum(Long outnum) {
		this.outnum = outnum;
	}
	
}
