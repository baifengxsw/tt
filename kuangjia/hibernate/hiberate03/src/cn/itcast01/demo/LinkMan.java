package cn.itcast01.demo;
/**
 * ��ϵ�˵�ʵ��
 * @author baifeng
 *CREATE TABLE `cst_linkman` (
  `lkm_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '��ϵ�˱��(����)',
  `lkm_name` VARCHAR(16) DEFAULT NULL COMMENT '��ϵ������',
  `lkm_cust_id` BIGINT(32) NOT NULL COMMENT '�ͻ�id',
  `lkm_gender` CHAR(1) DEFAULT NULL COMMENT '��ϵ���Ա�',
  `lkm_phone` VARCHAR(16) DEFAULT NULL COMMENT '��ϵ�˰칫�绰',
  `lkm_mobile` VARCHAR(16) DEFAULT NULL COMMENT '��ϵ���ֻ�',
  `lkm_email` VARCHAR(64) DEFAULT NULL COMMENT '��ϵ������',
  `lkm_qq` VARCHAR(16) DEFAULT NULL COMMENT '��ϵ��qq',
  `lkm_position` VARCHAR(16) DEFAULT NULL COMMENT '��ϵ��ְλ',
  `lkm_memo` VARCHAR(512) DEFAULT NULL COMMENT '��ϵ�˱�ע',
  PRIMARY KEY (`lkm_id`),
  KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
  CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */
public class LinkMan {
	private Long lkm_id;
	private String lkm_name;
	private Character lkm_gender;
	private String lkm_phone;
	private String lkm_mobile;
	private String lkm_email;
	private String lkm_qq;
	private String lkm_postion;
	public Long getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Long lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public Character getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(Character lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	public String getLkm_mobile() {
		return lkm_mobile;
	}
	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}
	public String getLkm_email() {
		return lkm_email;
	}
	public void setLkm_email(String lkm_email) {
		this.lkm_email = lkm_email;
	}
	public String getLkm_qq() {
		return lkm_qq;
	}
	public void setLkm_qq(String lkm_qq) {
		this.lkm_qq = lkm_qq;
	}
	public String getLkm_postion() {
		return lkm_postion;
	}
	public void setLkm_postion(String lkm_postion) {
		this.lkm_postion = lkm_postion;
	}

	public String getLkm_memo() {
		return lkm_memo;
	}
	public void setLkm_memo(String lkm_memo) {
		this.lkm_memo = lkm_memo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	private String lkm_memo;
	//����ط����� ����1��һ���Ķ���
	private Customer customer;
	
}
