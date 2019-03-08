package cn.itcast07_matrix;

/**
 * 用于矩形的顺时针打印
 * @author baifeng
 *
 */
public class SpiralOrderMatrixPrint {
	public static void  sprialOrderPrint(int [][]matrix) {
		int row1 = 0;
		int col1 = 0;
		int row2 = matrix.length-1;
		int col2 = matrix[0].length-1;
		while(row1<=row2&&col1<=col2) {
			printEdge(matrix,row1++,col1++,row2--,col2--);
		}
	}


	public static void printEdge(int[][] matrix, int row1, int col1, int row2, int col2) {
		// TODO 自动生成的方法存根
		if(row1 == row2) {
			for(int i = col1;i<=col2;i++) {
				System.out.println(matrix[row1][i]);
			}
		}else if( col1 == col2) {
			for(int j = row1;j<=row2;j++) {
				System.out.println(matrix[j][col1]);
			}
		}else {
			int i = col1;
			int j = row1;
			while(i!=col2) {
			System.out.println(matrix[row1][i++]);	
			}
			while(j!=row2) {
				System.out.println(matrix[j++][col2]);
			}
			while(i!=col1) {
				System.out.println(matrix[row2][i--]);
				
			}
			while(j!=row1) {
				System.out.println(matrix[j--][row1]);
			}
		}
		
	}	
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		sprialOrderPrint(matrix);
		
	}

}

