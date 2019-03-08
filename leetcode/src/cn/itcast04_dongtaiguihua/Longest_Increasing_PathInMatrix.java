package cn.itcast04_dongtaiguihua;

public class Longest_Increasing_PathInMatrix {
	//上面这个是递归
	
	public static int getLongestIncreasingPath(int [][]m) {
		if(m==null||m.length==0||m[0].length==0)
			return -1;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ;i<m.length;i++) {
			for(int j = 0;j<m[0].length;j++) {
				max = Math.max(max, process(m,i,j));
			}
		}
		return max;
		
	}
	//四个方向的相互比较  ，上下左右 向右走 每次新进入一个点 默认 为 1  返回的话 ，每前进一格  就进行 path+1；
	private static int process(int[][] m, int i, int j) {
		
		int path = 1;
		if(j>0 &&m[i][j]<m[i][j-1]) {
			path = Math.max(process(m,i,j-1)+1,path);
		}
		if(i>0 &&m[i][j]<m[i-1][j]) {
			path = Math.max(process(m,i-1,j)+1,path);
		}
		
		if(i<m.length-1 &&m[i][j]<m[i+1][j]) {
			path = Math.max(process(m,i+1,j)+1,path);
		}
		if(j<m[0].length-1 &&m[i][j]<m[i][j+1]) {
			path = Math.max(process(m,i,j+1)+1,path);
		}
		return path;
	}
	
	/**
	 * 下面是动态规划版本
	 * @param args
	 */
	public static int getLongestPath(int [][]m) {
		if(m==null||m.length==0||m[0].length==0) 
			return -1;
		int max = Integer.MIN_VALUE;
		int [][] dp = new int  [m.length][m[0].length];
		for(int i =0;i<m.length;i++) {
			for(int j = 0;j<m[0].length;j++) {
				max = Math.max(max, process(m,dp,i,j));

			}
		}
		return max;
	}
	
	private static int process(int[][] m, int[][] dp, int i, int j) {
		if(dp[i][j]==0) {
			dp[i][j] = 1;
		if(j>0 &&m[i][j]<m[i][j-1]) {
			 dp[i][j]= Math.max(process(m,i,j-1)+1,dp[i][j]);
		}
		if(i>0 &&m[i][j]<m[i-1][j]) {
			dp[i][j] = Math.max(process(m,i-1,j)+1,dp[i][j]);
		}
		
		if(i<m.length-1 &&m[i][j]<m[i+1][j]) {
			dp[i][j] = Math.max(process(m,i+1,j)+1,dp[i][j]);
		}
		if(j<m[0].length-1 &&m[i][j]<m[i][j+1]) {
			dp[i][j] = Math.max(process(m,i,j+1)+1,dp[i][j]);
		}
		}
		return dp[i][j];
	}
			
	
	
	/**
	 * 另一个版本
	 * @param args
	 */
	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] h = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, maxIncrease(matrix, h, i + 1, j, matrix[i][j])+1 );
				max = Math.max(max, maxIncrease(matrix, h, i, j + 1, matrix[i][j])+1 );
				max = Math.max(max, maxIncrease(matrix, h, i - 1, j, matrix[i][j])+1 );
				max = Math.max(max, maxIncrease(matrix, h, i, j - 1, matrix[i][j])+1 );
			}
		}
		return max;
	}

	public static int maxIncrease(int[][] m, int[][] h, int i, int j, int p) {
		if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] <=p) {
			return 0;
		}
		if (h[i][j] == 0) {
			h[i][j] =  maxIncrease(m, h, i + 1, j, m[i][j])+1;
			h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i, j + 1, m[i][j])+1);
			h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i - 1, j, m[i][j])+1);
			h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i, j - 1, m[i][j])+1);
		}
		return h[i][j];
	}
	
	public static void main(String[] args) {
		int [][] m = {{9,9,4},{6,6,8},{2,1,1}};
		int res = longestIncreasingPath(m);
		System.out.println("res:"+res);
	}
}
