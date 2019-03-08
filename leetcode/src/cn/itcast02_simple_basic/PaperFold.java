package cn.itcast02_simple_basic;
/**
 * 折纸  ，使用二叉树的方式   因为是从上向 下进行打印  ,那么结果应该是上班部分在左子树 
 * @author baifeng
 *
 */
public class PaperFold {
	public class Node {
		public int value ;
		public Node left;
		public Node right;
	}
	public static void paperPrint(int num) {
		if(num <= 0)
			return ;
		printProcess(1,num,true);
	}
	public static void printProcess(int i, int num, boolean b) {
		if(i>num)
			return ;
		printProcess(i+1,num,true);
		System.out.println(b? "下":"上");
		
		printProcess(i+1,num,false);
	}
	public static void main(String[] args) {
		paperPrint(3);
	}
}
