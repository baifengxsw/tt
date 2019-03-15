package cn.itcast00_ceshi;
/**
 * ��һ�� 8 x 8 �������ϣ���һ����ɫ����rook����Ҳ�����пշ��飬��ɫ����bishop���ͺ�ɫ���䣨pawn�������Ƿֱ����ַ� ��R������.������B�� �� ��p�� ��������д�ַ���ʾ���壬Сд�ַ���ʾ���塣

�������������еĹ����ƶ�����ѡ���ĸ����������е�һ�����������������ϣ���Ȼ���Ǹ������ƶ���ֱ����ѡ��ֹͣ���������̵ı�Ե���ƶ���ͬһ����������÷�������ɫ�෴���䡣���⣬�������������ѷ�����ɫ�������ͬһ������

���س��ܹ���һ���ƶ��в��񵽵����������
 
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
