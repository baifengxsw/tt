package cn.itcast07_matrix;

public class IsLand {
	
	public static int isLand (int [][]matrix) {
		if(matrix == null ||matrix[0]==null) {
			return 0;
	}

	int lr = matrix.length;
	int lc = matrix[0].length;
	int res = 0;
	for(int i = 0;i<lr;i++) {
		for(int j = 0; j<lc ;j++) {
			if(matrix[i][j]==1) {
				res++;
			process(matrix,i,j,lr,lc);
			}
		}
	}
	return res ;
	}
//�����ﲻ��ʹ��i++  ��Ϊ �ĸ��ӵݹ��Ӧ���ǵ�ǰλ��
	public static void process(int[][] matrix, int i, int j, int lr, int lc) {
		if(i<0||j<0||i>=lr||j>=lc||matrix[i][j]!=1)
			return ;
		matrix[i][j]=2;
		process(matrix,i+1,j,lr,lc);
		process(matrix,i,j+1,lr,lc);
		process(matrix,i-1,j,lr,lc);
		process(matrix,i,j-1,lr,lc);
		
	}
	public static void main(String[] args) {
		int [][] matrix = {{1,1,1,1,0,0,0},{1,0,0,0,1,1,0},{1,1,0,0,0,0,1}};
		int res = isLand(matrix);
		System.out.println("res:"+res);
	}
}
	
