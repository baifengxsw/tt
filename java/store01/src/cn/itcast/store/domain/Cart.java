package cn.itcast.store.domain;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

//2������ 3 ������
//������ȷ���Ĺ�����ܼƣ�����
//��ӹ�������ﳵ  �Ƴ����ﳵ  ��չ��ﳵ
public class Cart {
	private double total=0;
	Map<String ,CartItem> map = new HashedMap();
	
	//��ӹ�������ﳵ ������Ʒid  �õ�product  ����Ʒ���� ��������Ҳ��֪����  ��Ҫ�ж��Ƿ����ظ����߼�
	public void addCartItem(CartItem item) {
		String pid = item.getProduct().getPid();
		if(!map.containsKey(pid)) {
			map.put(pid, item);
		}else {
			map.get(pid).setNum(map.get(pid).getNum()+item.getNum());
			//����Ͳ���������� ��������ĵ�ַ����
		}
	} 
	//����Ƴ� ����ǰ��Ʒid ���͵������
	public void removeCartItem(String pid) {
		map.remove(pid);
	}
	//��չ��ﳵ
	public void clearCart() {
		map.clear();
	}
	public double getTotal() {
		total = 0;
		Collection<CartItem> values = map.values();
		for(CartItem item2:values) {
			total += item2.getSubTotal();
		}
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	
}
