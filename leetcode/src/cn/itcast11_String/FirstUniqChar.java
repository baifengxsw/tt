package cn.itcast11_String;
/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。
 * @author baifeng
 *
 */
public class FirstUniqChar {
	public static int firstUniqChar(String s) {
        char [] arr = new char [26];//一共26个小写字符
        char [] sArray = s.toCharArray();
        for(int i = 0;i<s.length();i++) {
        	arr[sArray[i]-'a']++;
        }
        for(int i = 0;i<s.length();i++) {
        	if(arr[sArray[i]-'a']==1)
        		return i;
        }
        return -1;
    }
 public static void main(String[] args) {
	String s = "loveleetcode";
	int ret = firstUniqChar(s);
	System.out.println(ret);
}
}
