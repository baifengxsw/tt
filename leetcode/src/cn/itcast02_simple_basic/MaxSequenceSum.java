package cn.itcast02_simple_basic;

import java.util.Scanner;
/**
 * 最长连续子序列
 * @author baifeng
 *
 */

public class MaxSequenceSum {

		   public static void main(String[] args) {
			   Scanner sc = new Scanner(System.in);
				  
		        int N = sc.nextInt();
		        int[] nums = new int[N];
		        for (int i = 0; i < N; i++) {
		            nums[i] = sc.nextInt();
		        }
		  
		        int max = nums[0],sum = 0;
		        for(int i = 0;i < nums.length;i++){
		            sum += nums[i];
		            //更新
		            if(sum > max)
		                max = sum;
		            //sum并不是记录最大连续和，只记录大于零的和，只要连续和小于0
		            //则重新开始计算和，因为nums[i]加上一个负数肯定比它本身小
		            if(sum < 0){
		                sum = 0;
		            }
		        }
		        System.out.println(max);
		    
		}
		     
		    
		    
		    
		    
		}


