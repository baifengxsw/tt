package cn.itcast00_ceshi;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * @author baifeng
 *
 */
public class AddStrings {
	public static String addStrings(String num1,String num2) {
		char [] arr1 = num1.toCharArray();
		char [] arr2 = num2.toCharArray();
		int m = arr1.length-1,n=arr2.length-1,carry = 0;
		int p,q,sum=0;
		String res = "";
		while(m>=0||n>=0) {
			p = m>=0? arr1[m--]-'0':0;
			q = n>=0? arr2[n--]-'0':0;
			sum = p+q+carry;
			res = (sum%10)+res;
			carry = sum / 10;
		}
		return carry==0? res:carry+res;
	}
	
	public static void main(String[] args) {
		String r1 = "123";
		String r2 = "999";
		String res = addStrings(r1,r2);
		System.out.println(res);
	}


}
