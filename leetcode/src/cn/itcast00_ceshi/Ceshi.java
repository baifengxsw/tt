package cn.itcast00_ceshi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 顺时针旋转90°
 * @author baifeng
 *
 */
public class Ceshi {
		public static void print(int[][]m) {
			if(m==null||m.length==0||m[0].length==0)
				return ;
			int row1 =0;
			int col1 =0;
			int row2 = m.length-1;
			int col2 = m[0].length-1;
			while(row1<=row2&&col1<=col2) {
				printProcess(m,row1++,col1++,row2--,col2--);
			}
		}
		

		//因为这个假设在方阵的情况下
		private static void printProcess(int[][] m, int row1, int col1, int row2, int col2) {
			for(int i=0;i<col2-col1;i++) {
				int temp = m[row1][col1+i];
				m[row1][col1+i] = m[row2-i][col1];
				m[row2-i][col1]= m[row2][col2-i];
				m[row2][col2-i] = m[row1+i][col2];
				m[row1+i][col2] = temp;
			}
			
		}



		public static void main(String[] args) {
			int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
			print(matrix);
			for(int i=0 ;i<matrix.length;i++) {
				System.out.println(Arrays.toString(matrix[i]));
			}
			
		}
}
