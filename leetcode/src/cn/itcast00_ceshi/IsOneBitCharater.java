package cn.itcast00_ceshi;

import java.util.HashMap;

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。

	现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * @author baifeng
 *
 */
public class IsOneBitCharater {
	/**
	 * 自己的
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
