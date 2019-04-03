package cn.itcast00_ceshi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * 给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。

 

示例 1：

输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * @author baifeng
 *
 */

public class HasGroupsSizeX_914 {
	
	 public static  boolean hasGroupsSizeX(int[] deck) {
	        if(deck==null||deck.length<2)
	        	return false;
	        HashMap<Integer,Integer> map = new HashMap<>(); // value + num
	        for(int i =0;i<deck.length ;i++) {
	        	if(map.containsKey(deck[i])) {
	        		map.put(deck[i], map.get(deck[i])+1);
	        	}else {
	        		map.put(deck[i],1);
	        	}
	        }
	        Integer [] arr = new Integer [map.size()];
	        map.values().toArray(arr);
	        int pos = arr[0];
	        for(int i = 0;i<arr.length;i++) {
	        	if(arr[i]==1|| pos!=arr[i])
	        		return false;
	        }
	       
		 return true;
	    }
	 
	 public static void main(String[] args) {
		int deck [] = {1,2,3,4,4,3,2,1};
		boolean flag = hasGroupsSizeX(deck);
		System.out.println(flag);
		
	}
}
