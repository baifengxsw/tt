package cn.itcast.store.domain;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

//2个属性 3 个方法
//个数不确定的购物项，总计，积分
//添加购物项到购物车  移除购物车  清空购物车
public class Cart {
	private double total=0;
	Map<String ,CartItem> map = new HashedMap();
	
	//添加购物项到购物车 发送商品id  得到product  和商品数量 ，购物项也就知道了  还要判断是否是重复的逻辑
	public void addCartItem(CartItem item) {
		String pid = item.getProduct().getPid();
		if(!map.containsKey(pid)) {
			map.put(pid, item);
		}else {
			map.get(pid).setNum(map.get(pid).getNum()+item.getNum());
			//这里就不用再添加了 反正对象的地址不变
		}
	} 
	//点击移除 将当前商品id 发送到服务端
	public void removeCartItem(String pid) {
		map.remove(pid);
	}
	//清空购物车
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
