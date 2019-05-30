package cn.itcast.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity//标注是实体类
@Table(name = "cst_customer")//与实体数据库进行连接
public class Customer implements Serializable {
    @Id//声明为主键
    @GeneratedValue(strategy=GenerationType.IDENTITY) //配置主键生成策略
    @Column(name="cust_id") //指定和表中cust_id的字段映射
	private Long custId;
    @Column(name="cust_name")
	private String custName;
    @Column(name="cust_source")
	private String custSource;
    @Column(name="cust_industry")
	private String custIndustry;
    @Column(name="cust_level")
	private String custLevel;
    @Column(name="cust_address")
	private String custAddress;
    @Column(name="cust_phone")
	private String custPhone;
    /*@OneToMany(targetEntity=LinkMan.class)
    @JoinColumn(name="lkm_cust_id",referencedColumnName="cust_id")*/
    @OneToMany(mappedBy="customer" ,cascade=CascadeType.REMOVE)
    private Set<LinkMan>linkMans = new HashSet<>();
	
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
				+ ", custPhone=" + custPhone + "]";
	}
	
}
