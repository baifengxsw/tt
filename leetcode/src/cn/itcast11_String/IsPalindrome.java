package cn.itcast11_String;

import java.util.Arrays;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:

����: "A man, a plan, a canal: Panama"
���: true
ʾ�� 2:

����: "race a car"
���: false
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
