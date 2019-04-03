package cn.itcast11_String;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。
 * @author baifeng
 *
 */
public class IsAnagram {
	  public static boolean isAnagram(String s, String t) {
		  	if(s.length()!=t.length())
		  		return false;
	        int[] arr = new int [26] ;//一共26个字符
	        char [] sArr = s.toCharArray();
	        char [] tArr = t.toCharArray();
	        for(int i = 0;i<s.length();i++) {
	        	arr[sArr[i]-'a'] ++;
	        }
	        for(int i = 0;i<t.length();i++) {
	        	if(--(arr[tArr[i]-'a'])<0)
	        		return false;
	        }
	      
	        return true;
	  }
	  public static void main(String[] args) {
		String s = "a";
		String t = "b";
		System.out.println(isAnagram(s, t));
		
	}
}
