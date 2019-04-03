package cn.itcast09_arr;

import java.util.Arrays;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		if(digits ==null ||digits.length==0)
			return null;
		int carry = 1;
		for(int i = digits.length-1;i>=0;i--) {
			int sum = digits[i] + carry;
			digits[i] = sum%10;
			carry = sum/10;
		}
		if(carry ==1) {
			int arr [] = new int [digits.length+1];
			arr[0] = 1;
			return arr;
		}else {
			return digits;
		}
    }
	
	public static void main(String[] args) {
		int [] arr = {1,2,3};
		plusOne(arr);
		System.out.println(Arrays.toString(arr));
	}
}
