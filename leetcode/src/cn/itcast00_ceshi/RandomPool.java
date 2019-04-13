package cn.itcast00_ceshi;

import java.util.HashMap;
/**
 * insert(key)��ĳ��key���뵽�ýṹ�����������ظ�����
 * delete(key) ��ԭ���ڽṹ�е�ĳ��key�����Ƴ�
 * getRandom()�ȸ���������ؽṹ�е�����һ��key
 * @author baifeng
 *
 */
public class RandomPool {
	private HashMap<String, Integer>keyMap;
	private HashMap<Integer,String>indexMap;
	private int size;
	
	public RandomPool() {
		keyMap = new HashMap<>();
		indexMap = new HashMap<>();
		size = 0;
	}
	public void insert(String key) {
		if(!keyMap.containsKey(key)) {
			keyMap.put(key, size);
			indexMap.put(size++, key);
		}
	}
	
	public void delete(String key) {
		if(keyMap.containsKey(key)) {
			Integer deleteIndex = keyMap.get(key);
			int lastIndex = --size;
			String lastKey = indexMap.get(lastIndex);
			keyMap.put(lastKey,deleteIndex);
			indexMap.put(deleteIndex, lastKey);
			keyMap.remove(key);
			indexMap.remove(lastIndex);
		}
	}
	public String getRandom() {
		if(size==0)
			return null;
		int randomIndex = (int)(Math.random()*size);
		return indexMap.get(randomIndex);
	}
}
