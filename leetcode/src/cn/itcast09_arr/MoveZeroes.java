package cn.itcast09_arr;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSpinnerUI;

public  class MoveZeroes {
	//基于赋值的方式快两倍
	 public static void moveZeroes1(int[] nums) {
		 if(nums == null||nums.length ==0)
			 return ;
		 int pos = 0;//之前应该填的位置
		 int num = 0 ; //遇到0进行计数
		 int len = nums.length;
		 for(int i=0;i<len;i++) {
			 if(nums[i]==0) {
				num++; 
			 }else {
				 nums[pos++] = nums[i]; 
			 }
		 }
		 for(int i = len-num;i<len;i++) {
			 nums[i] = 0;
		 }
	   
	 }
	 /**
	  * 
	  * @param args
	  */
	 public static void moveZeroes(int [] nums) {
		 for(int i = 0,j = 0;i<nums.length;i++) {
			 if(nums[i]!=0) {
				 swap(nums,i,j++);
			 }
		 }
	 }
	 public static void swap(int []nums ,int i,int j) {
		 nums[j]=(nums[i]+nums[j])-(nums[i]=nums[j]);
	 }
	
	 
	 public static void main(String[] args) {
		int [] nums  = {0,1,0,3,12};
		System.out.println(Arrays.toString(nums));
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}

