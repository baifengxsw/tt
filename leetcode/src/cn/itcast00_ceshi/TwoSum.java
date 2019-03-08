package cn.itcast00_ceshi;

import java.util.HashMap;

public class TwoSum {
	 public static int[] twoSum1(int[] nums, int target) {
	        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
	        int[] res = new int[2];
	        for (int i = 0; i < nums.length; ++i) {
	            m.put(nums[i], i);
	        }
	        for (int i = 0; i < nums.length; ++i) {
	            int t = target - nums[i];
	            if (m.containsKey(t) && m.get(t) != i) {
	                res[0] = i;
	                res[1] = m.get(t);
	                break;
	            }
	        }
	        return res;
	    }
	 
	 public static int[] twoSum(int[] nums,int target) {
		 int [] arr = new int[nums.length];
		 for(int i = 0;i<arr.length;i++) {
			 arr[i]= i;
		 }
		 for(int i = 0;i<nums.length;i++) {
			 heapInsert(nums,arr,i);
		 }
		 //大根堆已经建立完毕
		 int len = arr.length;
		 swap(nums,arr,0,--len);
		 while(len >0) {
			 heapify(nums,arr,0,--len);
			 swap(nums,arr,0,len);
	
		 }
		 int less = 0 ;
		 int more = nums.length-1;
		 while(less <more) {
			 if(nums[less]+nums[more]<target) {
				 less++;
			 }else if (nums[less]+nums[more]>target) {
				 more--;
			 }else {
				 return new int[] {arr[less],arr[more]};
			 }
		 }
		 return null;
	 }
	 
	 private static void heapify(int[] nums, int[] arr, int i, int size) {
		  int left = 2*i +1;
		  while(left<=size) {
			  int lagest = left+1<=size &&nums[left]<nums[left+1] ? left+1:left;
			  lagest = nums[lagest]>nums[i] ? lagest:i;
			  if(i==lagest)
				  break;
			  swap(nums,arr,i,lagest);
			  i=lagest;
			  left = i*2+1;
		  }
		
	}

	public static void heapInsert(int[] nums, int[] arr, int i) {
		 while(nums[i]>nums[(i-1)/2]) {
			 swap(nums,arr,i,(i-1)/2);
			
			 i= (i-1)/2;
		 }
		 	
	}

	private static void swap(int[] nums,int [] arr, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int nums[] = {-18,12,3,0};
		int res[] = twoSum(nums,-6);
		System.out.println(res[0]+" "+res[1]);
	}
}
