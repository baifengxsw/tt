package cn.itcast01.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * CREATE TABLE `cst_customer` (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '�ͻ����(����)',
  `cust_name` varchar(32) NOT NULL COMMENT '�ͻ�����(��˾����)',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '�ͻ���Ϣ��Դ',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '�ͻ�������ҵ',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '�ͻ�����',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '�̶��绰',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '�ƶ��绰',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 * @author baifeng
 *
 */
public class Customer {
	private Long cust_id;
	private String cust_name;
	private String cust_source;
	private String cust_industry;
	private String cust_level;
	private String cust_phone;
	private String cust_mobile;
	//���ö��һ���ļ��� ���ʹ�õ�list �����һ����������  ����ʹ��set
	private Set<LinkMan> linkMans  = new HashSet<LinkMan>();
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_source=" + cust_source
				+ ", cust_industry=" + cust_industry + ", cust_level=" + cust_level + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + "]";
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
}
