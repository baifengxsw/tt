package cn.itcast00_ceshi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * @author baifeng
 *
 */
public class AddToArrayForm {
	public static List<Integer> addToArrayForm(int[] A,int k){
		List<Integer > list = new LinkedList<>();
		int m = A.length-1;
		int p,q,sum = 0,carry =0;
		while(m>=0||k>0) {
			p = m>=0 ? A[m--]:0;
			q = k>0 ? k%10:0;
			sum = p+q+carry;
			list.add(0,(sum%10));
			//这里也可以最后再进行逆转
			k= k/10;
			carry = sum/10;
		}
		
		if(carry!=0)
			list.add(0,carry);
		return list;
			
		}
	
		public static void main(String[] args) {
			int A[] = {2,1,5};
			int k = 806;
			List<Integer> list = addToArrayForm(A, k);
			for(Integer in:list) {
				System.out.println(in);
			}
		}
	}

