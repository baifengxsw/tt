package cn.itcast11_String;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 * @author baifeng
 *
 */
public class LongestCommonPrefix {
	 public static String longestCommonPrefix1(String[] strs) {
		 if(strs==null||strs.length==0)
			 return "";
		 if(strs.length==1) {
			 return strs[0];
		 }
		 String res = "";
		 for(int i = 0;i<strs[0].length();i++) {
			 char ch = strs[0].charAt(i);
			 for(int j = 1;j<strs.length;j++) {
				 if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
					 return res;
			 }
			 res += String.valueOf(ch);
		 }
		 return res;
	 }
	 /**
	  * 我们可以对上面的方法进行适当精简，如果我们发现当前某个字符和
	  * 第一个字符串对应位置的字符不相等，说明不会再有更长的共同前缀了，我们直接通过用substr的方法直接取出共同前缀的子字符串。如果遍历结束前没有返回结果的话，说明第一个单词就是公共前缀，返回为结果即可。代码如下
	  * @param strs
	  * @return
	  */
	 public static String longestCommonPrefix(String[] strs) {
		 if(strs==null||strs.length==0)
			 return "";
		 if(strs.length==1) {
			 return strs[0];
		 }
		 for(int i = 0;i<strs[0].length();i++) {
			 char ch = strs[0].charAt(i);
			 for(int j = 1;j<strs.length;j++) {
				 if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
					 return strs[j].substring(0, i);
			 }
		 }
		 return strs[0];
	 }
	 
	 
	 public static void main(String[] args) {
		String [] strs = {"c","c"};
		String ret = longestCommonPrefix(strs);
		System.out.println(ret);
	}
}
