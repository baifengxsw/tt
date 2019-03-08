package cn.itcast04_dongtaiguihua;

/**
 * Ѱ�ҴӾ������Ϸ� ���������·������·�� 
 * @author baifeng
 *
 */
public class MinPath {
	public static int minPath(int [][] m) {
		return process(m,m.length-1,m[0].length-1);
	}
//*�������������·����ѡ�� ������Ҫ ��ƽʱ�������浱ǰֵ 
	private static int process(int[][] m,int i,int j) {
		if(i==0&&j == 0) 
			return m[i][j];
		if(i==0&&j!=0)
			return m[i][j]+ process(m,i,j-1);
		if(i!=0&&j==0)
			return m[i][j] +process(m,i-1,j);
		return Math.min(m[i][j] + process(m,i-1,j),m[i][j] + process(m ,i,j-1));
	}
	//�����ö�̬�滮ȥ��� 
	public static int minPath2(int [][]m) {
		if(m==null||m.length==0||m[0]==null||m[0].length==0)
			return 0;
		int row = m.length;
		int col = m[0].length;
		int [][] dp = new int[row][col];
		//��֪�ĳ�ʼ���� 
		dp[0][0] = m[0][0];
		for(int i = 1;i<row;i++) {
			dp[i][0] = dp[i-1][0]+m[i][0];
			
		}
		for(int i=1;i<col;i++) {
			dp[0][i] = dp[0][i-1] +m[0][i];
		}
		for(int i = 1;i<row;i++) {
			for(int j = 1;j<col;j++) {
				dp[i][j] = Math.min(dp[i-1][j]+m[i][j], dp[i][j-1]+m[i][j]);
			}
		}
		
		return dp[row-1][col-1];
		//��ʼ�����
		
	}
	
	  public static void main(String[] args) {
	      int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
	      System.out.println(minPath(m));
	      System.out.println(minPath2(m));

	   }
	}

