package cn.itcast00_ceshi;

import java.util.HashMap;

/**
 * �����������ַ�����һ���ַ�������һ����0����ʾ���ڶ����ַ�������������(10 �� 11)����ʾ��

	�ָ�һ�������ɱ�����ɵ��ַ����������һ���ַ��Ƿ�ض�Ϊһ��һ�����ַ����������ַ���������0������
 * @author baifeng
 *
 */
public class IsOneBitCharater {
	/**
	 * �Լ���
	 * @param bits
	 * @return
	 */
		public static boolean isOneBitCharater(int [] bits) {
		int i = 0;
		while(i<bits.length) {
			if(bits[i]==1&&bits[i+1]==0) {
				bits[i+1]=1;
				i+=2;
			}else if(bits[i]==1&&bits[i+1]==1){
				i+=2;
			}else {
				i++;
			}
			
		}
		return bits[bits.length-1] == 0;
			
		}
		
		public static boolean isOneBitCharater2(int [] bits) {
			int i = 0;
			while(i<bits.length-1) {
				if(bits[i]==1) {
					i+=2;
				}else {
					i++;
				}
			}
			return i == bits.length-1;
		}
		public static void main(String[] args) {
			int [] bits = {1,1,1,0};
			boolean flag = isOneBitCharater(bits);
			System.out.println(flag);
		}
}
