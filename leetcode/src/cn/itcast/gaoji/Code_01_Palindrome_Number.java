package cn.itcast.gaoji;



public class Code_01_Palindrome_Number {

	public static boolean isPalindrome(int n) {
		if (n < 0) {
			return false;
		}
		int help = 1;
		while (n / help >= 10) {
			help *= 10;
		}
		while (n != 0) {
			if (n / help != n % 10) {
				return false;
			}
			n = (n % help) / 10;
			help /= 100;
		}
		return true;
	}

}
