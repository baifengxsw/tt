package cn.itcast04_dongtaiguihua;



/**
 * 数组中能不能找到任意的组合相加 ，得到给的那个数  找到的话返回true
 * @author baifeng
 *
 */
public class IsSum {
	/**
	 * 
	 * @param arr
	 * @param i
	 * @param res 每次递归的累加和
	 * @param num 给出的数
	 * @return
	 */
	public static boolean isSum(int [] arr,int i ,int res,int num) {
		if(i == arr.length)
			return res == num;
		return isSum(arr,i+1,res,num)|| isSum(arr,i+1,res+arr[i],num);
	}
	
	public static boolean isSum2(int[]arr,int num) {
		boolean dp [][]= new boolean[arr.length+1][num+1];
		for(int i = 0;i<arr.length+1;i++) {
			dp[i][num] = true;
		}
		
		for(int i = arr.length-1;i>=0;i--) {
			for(int j = num;j>=0;j--) {
				dp[i][j] = dp[i+1][j];
				if((arr[i]+j)<num+1) {
					dp[i][j]= dp[i+1][j]||dp[i+1][j+arr[i]];
				}
			}
		}
	

		return dp[0][0];
	}
	public static void main(String[] args) {
		int arr[] = {2 ,3,5,14,6};
		boolean flag = isSum(arr, 0, 0, 11);
		boolean flag1 = isSum2(arr,11);
		System.out.println(flag);
		System.out.println(flag1);
	}

}
