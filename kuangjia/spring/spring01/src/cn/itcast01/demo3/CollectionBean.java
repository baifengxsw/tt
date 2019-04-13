package cn.itcast01.demo3;

import java.util.Arrays;

public class CollectionBean {
	//集合属性的注入
	private String[] arr;

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "CollectionBean [arr=" + Arrays.toString(arr) + "]";
	}
	
}
