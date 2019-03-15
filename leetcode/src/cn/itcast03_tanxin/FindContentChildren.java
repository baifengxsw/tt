package cn.itcast03_tanxin;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * ��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ���ÿ������ i ������һ��θ��ֵ gi ���������ú���������θ�ڵı��ɵ���С�ߴ磻����ÿ����� j ������һ���ߴ� sj ����� sj >= gi �����ǿ��Խ�������� j ��������� i ��������ӻ�õ����㡣���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��

ע�⣺

����Լ���θ��ֵΪ����
һ��С�������ֻ��ӵ��һ����ɡ�

ʾ�� 1:

����: [1,2,3], [1,1]

���: 1
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
		//������û�е������
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
        //����С�ı������㺢�� ÿ�ηַ���ȥ��С�ı���
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
