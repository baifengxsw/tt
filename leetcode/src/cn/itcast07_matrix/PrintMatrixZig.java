package cn.itcast07_matrix;
/**
 * 之字型打印矩阵
 * @author baifeng
 *
 */
public class PrintMatrixZig {
	public static void printMatrixZig(int [][]matrix) {
		int row1 =0;
		int col1 = 0;
		int row2 = 0;
		int col2 = 0;
		int endR = matrix.length-1;
		int endC = matrix[0].length -1;
		boolean flag = false;
//		while(row1 <= endR) {
//			printLevel(matrix,row1,col1,row2,col2,flag);
//			row1 = col1 == endC ? row1+1: row1;
//			col1 = col1 == endC ? col1 :col1+1;
//			col2 = row2 == endR ? col2+1 : col2;
//			row2 = row2 == endR ? row2: row2+1;
//			flag = !flag;
//			
//		}
		for(int i = 0 ;i<=endR+endC;i++) {
			printLevel(matrix,row1,col1,row2,col2,flag);
			if(col1<endC) {
				col1++;
			}else {
				row1++;
			}
			if(row2<endR) {
				row2++;
			}else {
				col2++;
			}
			flag = !flag;
		}
		System.out.println();
	}

	public static void printLevel(int[][] matrix, int row1, int col1, int row2, int col2, boolean flag) {
		// TODO 自动生成的方法存根
		if(flag) {
			while(row1<= row2) {
				System.out.println(matrix[row1++][col1--]);
			}
			
		}else {
			while(row2 >= row1) {
				System.out.println(matrix[row2--][col2++]);
			}
		}
	}
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrixZig(matrix);
		
	}
}
