package cn.itcast00_ceshi;
/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。

车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。

返回车能够在一次移动中捕获到的卒的数量。
 
 * @author baifeng
 *
 */
public class NumRookCapture {
	public static int numRookCapture(char[][]board) {
		if(board==null||board.length==0||board[0].length==0)
			return -1;
		int row = board.length;
		int col = board.length;
		int arr [] = getRook(board,row,col,'R');
		int row1 = arr[0];
		int col1 = arr[1];
		int res = 0;
		for(int i =arr[0]-1;i>=0;i--) {
			if(board[i][col1]<='z'&&board[i][col1]>='a') {
				res ++;
				break;
			}else if(board[i][col1]<='Z'&&board[i][col1]>='A'){
				break;
			}else {
				continue;
			}
		}
		for(int i =arr[0]+1;i<row;i++) {
			if(board[i][col1]<='z'&&board[i][col1]>='a') {
				res ++;
				break;
			}else if(board[i][col1]<='Z'&&board[i][col1]>='A'){
				break;
			}else {
				continue;
			}
		}
		for(int i =arr[1]-1;i>=0;i--) {
			if(board[row1][i]<='z'&&board[row1][i]>='a') {
				res ++;
				break;
			}else if(board[row1][i]<='Z'&&board[row1][i]>='A'){
				break;
			}else {
				continue;
			}
		}
		for(int i =arr[1]+1;i<col;i++) {
			if(board[row1][i]<='z'&&board[row1][i]>='a') {
				res ++;
				break;
			}else if(board[row1][i]<='Z'&&board[row1][i]>='A'){
				break;
			}else {
				continue;
			}
		}
		return res;
	}

	private static int[] getRook(char[][] board, int row, int col, char c) {
		for(int i =0;i<row;i++) {
			for(int j =0;j<col;j++) {
				if(board[i][j]==c) 
					return new int [] {i,j};
			}
		}
		return null;
	}
	public static void main(String[] args) {
		
	}
}
