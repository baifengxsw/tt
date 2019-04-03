package cn.itcast00_ceshi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * ����һ���ƣ�ÿ�����϶�д��һ��������

��ʱ������Ҫѡ��һ������ X��ʹ���ǿ��Խ������ư���������ֳ� 1 �������飺

ÿ�鶼�� X ���ơ�
�������е����϶�д����ͬ��������
�������ѡ�� X >= 2 ʱ���� true��

 

ʾ�� 1��

���룺[1,2,3,4,4,3,2,1]
�����true
���ͣ����еķ����� [1,1]��[2,2]��[3,3]��[4,4]
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
