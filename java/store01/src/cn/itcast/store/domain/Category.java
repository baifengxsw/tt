package cn.itcast.store.domain;

public class Category {
	private String cid;
	private String cname;
	
//这里不需要构造 要不再加个默认构造
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
