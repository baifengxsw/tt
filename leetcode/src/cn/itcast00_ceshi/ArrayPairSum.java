package cn.itcast00_ceshi;

import java.util.Arrays;
/**
 * ��������Ϊ 2n ������, ��������ǽ���Щ���ֳ� n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 �� n �� min(ai, bi) �ܺ����

ʾ�� 1:

����: [1,4,3,2]

���: 4
����: n ���� 2, ����ܺ�Ϊ 4 = min(1, 2) + min(3, 4
 * @author baifeng
 *
 */
public class ArrayPairSum {
	public static int arrayPairSum(int [] nums) {
		Arrays.sort(nums);
		int res = 0;
		for(int i = 0;i<nums.length;i=i+2) {
			res+=nums[i];
		}
		return res;
	}
}
