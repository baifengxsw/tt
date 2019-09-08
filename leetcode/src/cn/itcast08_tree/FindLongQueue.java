package cn.itcast08_tree;
/**
 * 查找一个数组的最长递增子序列 
 * @author baifeng
 *
 */
public class FindLongQueue {
     public int getLength(int [] arr) {
    	 if(arr==null) 
    		 return 0;
    	 int []  dp = new int [arr.length];
    	 for( int i = 0 ;i<arr.length;i++) {
    		 dp[i] = 1;
    		 for(int j = 0 ;j <i ;j++) {
    			 if(arr[j]<arr[i])
    				 dp[i] = Math.max(dp[i],dp[j]+1);
    		 }
    	 }
    	 int max = 0;
    	 for(int i = 0; i<dp.length ;i++) {
    		 if(max <dp[i]) {
    			 max = dp[i];
    		 }
    	 }
    	 return max;
     }
}
