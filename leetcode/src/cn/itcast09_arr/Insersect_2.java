package cn.itcast09_arr;

import java.util.Arrays;

/**
 * ������������Ľ���
 * �����������飬��дһ���������������ǵĽ�����

ʾ�� 1:

����: nums1 = [1,2,2,1], nums2 = [2,2]
���: [2,2]
 * @author baifeng
 *
 */
public class Insersect_2 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		
        if(nums1==null ||nums2 == null)
        	return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1<len2? len1:len2;
        int i=0,j=0,index=0;
        int pos = 0;
        int [] arr = new int [len];
        while(i<len1&&j<len2) {
        	if(nums1[i]<nums2[j]) {
        		i++;
        	}else if(nums1[i]>nums2[j]) {
        		j++;
        	}else {
        		arr[index++] = nums1[i];
        		i++;
        		j++;
        		pos++;
        	}
        }
        return Arrays.copyOfRange(arr, 0, pos);
    }
	public static void main(String[] args) {
		int arr1[] = {4,9,5};
		int arr2[] = {9,4,9,8,4};
		int [] ret = intersect(arr1, arr2);
		System.out.println(Arrays.toString(ret));
		
	}
}
