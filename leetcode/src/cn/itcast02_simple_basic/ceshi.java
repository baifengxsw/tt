package cn.itcast02_simple_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ceshi {
/**
 * ²âÊÔ
 */
	public static List<String> ret1(){
		List<String> ret = new ArrayList<>();
		ret.add("xia");
		return ret;
	}
	public static List<String> ret2(){
		List<String> ret = new ArrayList<>();
		ret.add("shuang");
		return ret;
	}
	public static void main(String[] args) {
		HashMap<String,List<String>> map  = new HashMap<>();
		map.put("1", ret1());
		map.put("2",ret2());
		
		System.out.println(map.get("1"));
		System.out.println(map.get("2"));
	}
}
