package cn.itcast00_ceshi;
/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

 

示例 1：

输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
 * @author baifeng
 *
 */
public class BackspaceCompare_844 {
public static boolean backspaceCompare(String S, String T) {
        char[] sarr = S.toCharArray();
        char[] tarr = T.toCharArray();
        String ss = "";
        String tt = "";
        int count1 = 0;
        for(int i= sarr.length-1 ;i>=0;i--) {
        	if(sarr[i]=='#') {
        		count1++;
        	} else {
        		if(count1==0) {
        		ss = sarr[i] +ss;
        		}else {
        		count1--;
        		}
        	}
        }
        int count2 = 0;
        for(int i= tarr.length-1 ;i>=0;i--) {
        	if(tarr[i]=='#') {
        		count2++;
        	}else {
        		if(count2==0) {
        		tt = tarr[i] +tt;
        		}else {
        		count2--;
        		}
        	}
        }
        
        return tt.compareTo(ss) ==0;

    }
	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
		boolean flag = backspaceCompare(S, T);
		
		System.out.println("flag:"+flag);
	}
}
