package cn.itcast09_arr;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�

����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��

ʾ�� 1:

����: [1,2,3,1]
���: true
 * @author baifeng
 *
 */
public class ContainsDuplicate {
	 public boolean containsDuplicate1(int[] nums) {
		 HashMap<Integer,Integer> map = new HashMap<>();
	        for(int i = 0;i<nums.length;i++) {
	        	if(!map.containsKey(nums[i])) {
	        		map.put(nums[i], 1);
	        	}else {
	        		map.put(nums[i],map.get(nums[i])+1);
	        	}
	        }
	        for(Integer key:map.keySet()) {
	        	Integer value = map.get(key);
	        	if(value >= 2)
	        		return true;
	        }
	        return false;
	    }
	 
	 //�ȹ�ϣ�����4��
	 public boolean containsDuplicate(int[] nums) {
		//�Ƚ������� ����������λ���Ƿ����
		 Arrays.sort(nums);
		 for(int i = 1 ;i<nums.length;i++) {
			 if(nums[i]==nums[i-1])
				 return true;
			 
		 }
		 return false;
	 }
}
