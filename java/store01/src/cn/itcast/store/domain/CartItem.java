package cn.itcast.store.domain;

public class CartItem {
	private Product product ;//Ŀ��Я��������3�ֲ�����ͼƬ·������Ʒ����,��Ʒjiage)
	private int num ;//��ǰ��������
	private double subTotal;//С��
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getSubTotal() {
		return product.getShop_price()*num;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
}