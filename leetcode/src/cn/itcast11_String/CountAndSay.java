package cn.itcast11_String;

import java.util.LinkedHashMap;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

 
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
