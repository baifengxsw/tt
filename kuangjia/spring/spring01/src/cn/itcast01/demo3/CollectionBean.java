package cn.itcast01.demo3;

import java.util.Arrays;

public class CollectionBean {
	//�������Ե�ע��
	private String[] arr;

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "CollectionBean [arr=" + Arrays.toString(arr) + "]";
	}
	
}
