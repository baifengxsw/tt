package cn.itcast03_tanxin;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：

你可以假设胃口值为正。
一个小朋友最多只能拥有一块饼干。

示例 1:

输入: [1,2,3], [1,1]

输出: 1
 * @author baifeng
 *
 */

public class FindContentChildren {
	public static int findContentChildren(int[]g,int[]s) {
		PriorityQueue<Integer> gg = new PriorityQueue<>();
		PriorityQueue<Integer> ss = new PriorityQueue<>();
		for(int i=0;i<g.length;i++) {
			gg.add(g[i]);
		}
		for(int j =0;j<s.length;j++) {
			ss.add(s[j]);
		}
		//当饼干没有的情况下
		int res = 0;
		while(!ss.isEmpty()&&!gg.isEmpty()) {
			int canke = ss.poll();
			if(canke>=gg.peek()) {
				gg.poll();
				res++;
			}
		}
		return res;
		
	}
	public int findContentChildren1(int[] g, int[] s) {
        //用最小的饼干满足孩子 每次分发出去最小的饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, sum = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                 sum ++;
                i++;
            }
            j ++;
        }
        return sum;
    }
}
