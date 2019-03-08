package cn.itcast06_stack_queue_arr;
/**
 * ����һ��int ֵ ����ж��Ƿ��ǻ�����  ��Ҫ�����������
 * @author baifeng
 *
 */
public class IsPalindromeInt {
	public static boolean isPalindromeInt(int n) {
		if(n <0) 
		return false;
		int help = 1;
		while(n/help>=10) {
			help*=10;
		}
		while(n>0) {
			if(n/help != n%10) {
				return false;
			}
			n = (n%help)/10;
			help /=100;
		}
		return true;
		
	}
	public static void main(String[] args) {
		int n = 12321;
		System.out.println("res:"+isPalindromeInt(n));
		
	}
}
