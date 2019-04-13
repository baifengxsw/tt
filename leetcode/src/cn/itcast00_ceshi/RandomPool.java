package cn.itcast00_ceshi;

import java.util.HashMap;
/**
 * insert(key)将某个key加入到该结构，做不到不重复加入
 * delete(key) 将原本在结构中的某个key进行移除
 * getRandom()等概率随机返回结构中的任意一个key
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
