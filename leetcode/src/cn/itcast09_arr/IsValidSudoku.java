package cn.itcast09_arr;

import java.util.HashSet;
/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
 * @author baifeng
 *
 */
public class IsValidSudoku {
	 public static boolean isValidSudoku1(char[][] board) {
	       	HashSet<Character> set1 = new HashSet<>();
	       	HashSet<Character> set2 = new HashSet<>();
	       	HashSet<Character> set3 = new HashSet<>();
	       	for(int i = 0 ;i<board.length;i++) {
	       		for(int j = 0 ;j<board[0].length;j++) {
	       			//校验行
	       			if(board[i][j]!='.'&&!set1.add(board[i][j]))
	       				return false;
	       			//校验列
	       			if(board[j][i]!='.'&&!set2.add(board[j][i]))
	       				return false;
	       			int row = i/3*3 + j/3;
	       			int col = i%3*3 + j%3;
	       			if(board[row][col]!='.'&&!set3.add(board[row][col]))
	       				return false;
	       		}
	       		set1.removeAll(set1);
	       		set2.removeAll(set2);
	       		set3.removeAll(set3);
	       	}
	       	return true;
	       	
	 }
	public static void main(String[] args) {
		char arr[][] = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','.','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','.','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
		boolean flag = isValidSudoku1(arr);
		System.out.println(flag);
	}
	public static boolean isValidSudoku(char[][] arr) {
		boolean [][] col = new boolean[9][10];
		boolean [][] row = new boolean[9][10];
		boolean [][] rent = new boolean[9][10];
		//标记数组
		for(int i = 0 ;i<9;i++) {
			for(int j = 0;j<9;j++) {
				if(arr[i][j]!= '.') {
				int num = arr[i][j]- '0';
				if(row[i][num]||col[j][num]||rent[i/3*3+j/3][num]) {
					return false;
				}else {
					row[i][num] = true;
					col[j][num] = true;
					rent[i/3*3+j/3][num] = true;
					
				}
				}
				
			}
		}
		return true;
		
	}
}
