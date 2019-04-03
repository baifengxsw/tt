package cn.itcast11_String;

import java.util.LinkedHashMap;

/**
 * ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 ������  "one 1"  ("һ��һ") , �� 11��
11 ������ "two 1s" ("����һ"��, �� 21��
21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��

����һ�������� n��1 �� n �� 30��������������еĵ� n �

ע�⣺����˳�򽫱�ʾΪһ���ַ�����

 
 * @author baifeng
 *
 */
public class CountAndSay {
	 public static String countAndSay(int n) {
	      if(n<=0)
	    	  return "";
	      String start = "1";
	     
	      for(int j = 1;j<n;j++) {
	    	  char [] chs = start.toCharArray();
	  		  StringBuilder sb = new StringBuilder();
		  		for(int i = 0;i<chs.length;i++) {
		  			int count = 1;
		  			while(i+1<chs.length&&chs[i]==chs[i+1]) {
		  				count++;
		  				i++;
		  			}
		  			sb.append(String.valueOf(count)+chs[i]);
		  		}
		  		start = sb.toString();
	      }
	    	 
	    	   
	 return start;
	}

	
	public static void main(String[] args) {
		String ret = countAndSay(3);
		System.out.println(ret);
	}
}
