package cn.itcast02_simple_basic;

import java.util.Scanner;
/**
 * �����������
 * @author baifeng
 *
 */

public class MaxSequenceSum {

		   public static void main(String[] args) {
			   Scanner sc = new Scanner(System.in);
				  
		        int N = sc.nextInt();
		        int[] nums = new int[N];
		        for (int i = 0; i < N; i++) {
		            nums[i] = sc.nextInt();
		        }
		  
		        int max = nums[0],sum = 0;
		        for(int i = 0;i < nums.length;i++){
		            sum += nums[i];
		            //����
		            if(sum > max)
		                max = sum;
		            //sum�����Ǽ�¼��������ͣ�ֻ��¼������ĺͣ�ֻҪ������С��0
		            //�����¿�ʼ����ͣ���Ϊnums[i]����һ�������϶���������С
		            if(sum < 0){
		                sum = 0;
		            }
		        }
		        System.out.println(max);
		    
		}
		     
		    
		    
		    
		    
		}


