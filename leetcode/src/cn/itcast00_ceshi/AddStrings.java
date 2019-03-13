package cn.itcast00_ceshi;

/**
 * ���������ַ�����ʽ�ķǸ����� num1 ��num2 ���������ǵĺ͡�

ע�⣺

num1 ��num2 �ĳ��ȶ�С�� 5100.
num1 ��num2 ��ֻ�������� 0-9.
num1 ��num2 ���������κ�ǰ���㡣
�㲻��ʹ���κ΃Ƚ� BigInteger �⣬ Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ��
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
