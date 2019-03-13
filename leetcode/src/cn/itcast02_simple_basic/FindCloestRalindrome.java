 package cn.itcast02_simple_basic;
/**
 * 找到一个数的最相近回文数
 * @author baifeng
 *
 */



public class FindCloestRalindrome {
    public static String nearestPalindromic(String num) {
		long n = Long.parseLong(num);
		long result = getRawPalindrome(n);
		long big = result > n ? result :getBigPalindRome(n);
		long small = result<n ? result :getSmallPalindrome(n);
		return String.valueOf(big - n >=n - small? small:big);
	}

	private static long getBigPalindRome(long n) {
		char [] chs = String.valueOf(n).toCharArray();
		//预留一位作为高位匹配
		char [] res = new char[chs.length+1];
		int len = chs.length;
		res[0] = '0';
		for(int i = 1 ;i<res.length;i++) {
			res[i]= chs[i-1];
		}
		for(int i = (len -1)/2+1;i>=0;i--) {
			if(++res[i]>'9') {
				res[i] = '0';
			}else {
				break;
			}
		}
		len = res.length;
		int offset = res[0]== '1' ? 1:0;
		for(int i=len-1;i>(len-offset)/2 ;i--) {
			res[i] = res[len -i-offset];
		}
		return Long.valueOf(String.valueOf(res));
	}

	private static long getRawPalindrome(long n) {
		char [] chs = String.valueOf(n).toCharArray();
		int len = chs.length;
		for(int i = len-1;i>(len-1)/2;i--) {
			chs[i] = chs[chs.length-i-1];
		}
		return Long.valueOf(String.valueOf(chs));
	}
	public static Long getSmallPalindrome(Long raw) {
		char[] chs = String.valueOf(raw).toCharArray();
		char[] res = new char[chs.length];
		int size = res.length;
		for (int i = 0; i < size; i++) {
			res[i] = chs[i];
		}
		for (int j = (size - 1) / 2; j >= 0; j--) {
			if (--res[j] < '0') {
				res[j] = '9';
			} else {
				break;
			}
		}
		if (res[0] == '0') {
			res = new char[size - 1];
			for (int i = 0; i < res.length; i++) {
				res[i] = '9';
			}
			return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
		}
		for (int k = 0; k < size / 2; k++) {
			res[size - 1 - k] = res[k];
		}
		
		return Long.valueOf(String.valueOf(res));
	}
	
}
