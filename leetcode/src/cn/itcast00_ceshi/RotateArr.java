package cn.itcast00_ceshi;
/**
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����

ʾ�� 1:

����: [1,2,3,4,5,6,7] �� k = 3
���: [5,6,7,1,2,3,4]
����:
������ת 1 ��: [7,1,2,3,4,5,6]
������ת 2 ��: [6,7,1,2,3,4,5]
������ת 3 ��: [5,6,7,1,2,3,4]
Ҫ��ռ�ΪO��1��
//�����Է�ת
 * @author baifeng
 *
 */

public class RotateArr {
	
	 public void rotate(int[] nums, int k) {
		if(nums==null ||nums.length<2||k%nums.length == 0)
			return ;
		 
		int start = 0,len = nums.length;//������Ӧ��ѭ�� 
		int pre ,cur = nums[0];
		int x ;//��λ
		for(int i = 0;i<len;i++) {
			pre = cur ;
			x = (i+k)%len;
			cur = nums[x];
			nums[x] = pre;
			if(x ==start) {
				x = ++start;
				cur = nums[x];
			}
			
		}
	}
}
