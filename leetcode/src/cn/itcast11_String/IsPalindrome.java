package cn.itcast11_String;

import java.util.Arrays;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 * @author baifeng
 *
 */
public class IsPalindrome {
	 public static boolean isPalindrome(String s) {
		 	char [] arr = s.toCharArray();
		 	StringBuffer sb1 = new StringBuffer();
	
		 	for(int i = 0;i<arr.length;i++) {
		 		if(arr[i]<='Z'&&arr[i]>='A') {
		 			sb1.append((char)(arr[i]+32));
		 	
		 		}
		 		if((arr[i]<='z'&&arr[i]>='a')||(arr[i]<='9'&&arr[i]>='0')){
		 			sb1.append(arr[i]);
		 		}
		 	
		 	}
		 	System.out.println(sb1.toString());
		 	System.out.println(sb1.reverse().toString());
		 	return sb1.toString().equals(sb1.reverse().toString());
	}
	 public static void main(String[] args) {
		String ss = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(ss));
	}
}
