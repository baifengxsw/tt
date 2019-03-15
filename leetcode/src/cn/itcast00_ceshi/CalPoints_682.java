package cn.itcast00_ceshi;

import java.util.Stack;

/**
 * �������ǰ��������¼Ա��
����һ���ַ����б�ÿ���ַ���������������������֮һ��
1.������һ�ֵĵ÷֣���ֱ�ӱ�ʾ���ڱ����л�õĻ�������
2. "+"��һ�ֵĵ÷֣�����ʾ���ֻ�õĵ÷���ǰ������Ч �غϵ÷ֵ��ܺ͡�
3. "D"��һ�ֵĵ÷֣�����ʾ���ֻ�õĵ÷���ǰһ����Ч �غϵ÷ֵ�������
4. "C"��һ���������ⲻ��һ���غϵķ���������ʾ����õ����һ����Ч �غϵķ�������Ч�ģ�Ӧ�ñ��Ƴ���

ÿһ�ֵĲ������������Եģ����ܻ��ǰһ�ֺͺ�һ�ֲ���Ӱ�졣
����Ҫ�����������лغ��е÷ֵ��ܺ͡�

ʾ�� 1:

����: ["5","2","C","D","+"]
���: 30
����: 
��1�֣�����Եõ�5�֡��ܺ��ǣ�5��
��2�֣�����Եõ�2�֡��ܺ��ǣ�7��
����1����2�ֵ�������Ч���ܺ��ǣ�5��
��3�֣�����Եõ�10�֣���2�ֵ������ѱ�ɾ�����������ǣ�15��
��4�֣�����Եõ�5 + 10 = 15�֡������ǣ�30��
 * @author baifeng
 *
 */
public class CalPoints_682 {
	public static int calPoints1(String[] ops) {
	        if(ops==null)
	        	return -1;
	        int sum = 0;
	        int help [] = new int [ops.length];
	        int index = 0;
	        for(int i = 0;i<ops.length;i++ ) {
	        	
	        	if(ops[i].equals("D")) {
	        		help[index] = help[index-1]*2;
	        		index++;
	        	}else if(ops[i].equals("C")) {
	        		help[--index]=0;
	        	}else if(ops[i].equals("+")) {
	        		if(index>=2) {
	        		help[index] = help[index-1]+help[index-2];
	        		}else if(index==1){
	        			help[index] = help[index-1];
	        			
	        		}
	        		index++;
	        	}else {
	        		int num = Integer.parseInt(ops[i]);
	        		help [index++] = num;
	        	}
	        }
	        for(int i = 0;i<help.length;i++) {
	        	sum +=help[i];
	        }
	        return sum;
	    }
	public static void main(String[] args) {
		String [] arr = {"36","28","70","65","C","+","33","-46","84","C"};
		int res = calPoints1(arr);
		System.out.println(res);
		
	}

}
