package cn.itcast00_ceshi;
/**
 * ����һ������������ת��Ϊ7���ƣ������ַ�����ʽ�����

ʾ�� 1:

����: 100
���: "202"
ʾ�� 2:

����: -7
���: "-10"
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
