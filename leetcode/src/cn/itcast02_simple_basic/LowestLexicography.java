package cn.itcast02_simple_basic;

import java.util.Comparator;
import java.util.PriorityQueue;

// �õ��ֵ�����С��ƾ���ַ���  
/**
 * ������ص��ǵõ���Ӧ��̰�Ĳ���  �����������໥�Ƚ�
 * @author baifeng
 *
 */
public class LowestLexicography {
	public static class  StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			
			return (o1+o2).compareTo(o2+o1);
		}
	}
	public static String lowestLexicography(String [] arr) {
		if(arr==null||arr.length ==0)
			return "";
		PriorityQueue<String> queue = new PriorityQueue<>(new StringComparator());
		
		for(int i = 0;i<arr.length;i++) {
			queue.add(arr[i]);
			
		}
		String res = "";
		for(String str:queue) {
			res+=str;
		}
		return res;
		
	}
	public static void main(String[] args) {
		String [] arr = {"b","ba","bca"};
		String res = lowestLexicography(arr);
		System.out.println("res:"+res);
	}
		
	}

