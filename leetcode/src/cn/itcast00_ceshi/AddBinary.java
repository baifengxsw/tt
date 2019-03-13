package cn.itcast00_ceshi;
/**
 * 二进制的求和
 * @author baifeng
 *
 */
public class AddBinary {	
	public static String addBinary1(String a, String b) {
		char [] char1 = a.toCharArray();
		char [] char2 = b.toCharArray();
		int [] num1 = getNum(char1);
		int [] num2 = getNum(char2);
		int len = num1.length>num2.length ?num1.length:num2.length;
		int [] res = new int [len+1];
		int i ;
		for(i = 0;i<num1.length;i++) {
			res[i] +=num1[i];
		}
		for(i = 0 ;i<num2.length;i++) {
			res[i]+= num2[i];
		}
		for(i = 0 ;i<res.length;i++) {
			if(res[i]>=2) {
				res[i+1]++;
				res[i]=res[i]%2;
			}
		}
		int pos =0;
		for(i = res.length-1 ;i>=0;i--) {
			if(res[i]==1) {
				pos = i;
				break;
			}
		}
		String ret = "";
		for(i = pos ;i>=0;i--) {
			ret+=res[i];
		}
		return ret;
	}
	public static String addBinary(String a, String b) {
		char [] char1 = a.toCharArray();
		char [] char2 = b.toCharArray();
		String res = "";
		int m=a.length()-1 ,n = b.length()-1, carry =0;
		int p,q,sum;
		while(m>=0||n>=0) {
			 p = m>=0 ? char1[m--]-'0' :0;
			 q = n>=0 ? char2[n--]-'0' :0;
			 sum = p+q+carry;
			 res = String.valueOf(sum%2)+res;
			 carry = sum /2;
		}
		return carry == 1 ? '1'+res:res;
	}
	public static int [] getNum (char [] char1) {
		int len = char1.length;
		int [] num = new int [len];
		for(int i =0;i<len;i++) {
			num[i] = char1[len-i-1]-'0';
		}
		return num;
	}
	
	
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		String ret = addBinary(a, b);
		System.out.println(ret);
	}
}
