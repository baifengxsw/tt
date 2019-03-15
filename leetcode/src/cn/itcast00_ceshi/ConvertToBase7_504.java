package cn.itcast00_ceshi;
/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。

示例 1:

输入: 100
输出: "202"
示例 2:

输入: -7
输出: "-10"
 * @author baifeng
 *
 */
public class ConvertToBase7_504 {
	public String convertToBase7(int num1) {
	        int num = num1>0?num1:-num1;
	        if(num ==0) {
	        	return "0";
	        }
	        String res = "";
	        while(num >0) {
	        	res = (num%7)+res;
	        	num /= 7;
	        }
	        if(num1<0)
	        	res = "-"+res;
	        return res;
	    }
}
