package cn.itcast07_matrix;
/**
 * 将一个矩阵顺时针选装90°
 * @author baifeng
 *
 */
public class RotateMatrix {
	public static void rotateMatrix(int [][] matrix) {
		if(matrix == null) {
			return;
		}
		int hr = 0;
		int	hc = 0;
		int lr = matrix.length-1;
		int lc = matrix[0].length -1;
		while(hr<=lr&&hc<=lc) {
			process(matrix,hr++,hc++,lr--,lc--);
		}
	}

	private static void process(int[][] matrix, int hr, int hc,int lr, int lc) {
		for(int i = 0 ;i<lr-hr;i++) {
			int temp = matrix[hr][hc+i];
			matrix[hr][hc+i] = matrix[lr-i][hc];
			matrix[lr-i][hc] = matrix[lr][lc-i];
			matrix[lr][lc-i] = matrix[hr+i][lc];
			matrix[hr+i][lc] = temp;
		}
		
		
	}

	public static void printMatrix(int [][]matrix) {
		for(int i = 0 ;i<matrix.length ;i++) {
			for(int j = 0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrix);
		System.out.println("------------------------");
		rotateMatrix(matrix);
		printMatrix(matrix);
		
	}
}
