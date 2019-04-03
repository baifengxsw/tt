package cn.itcast09_arr;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int min = 0;
        int profit = 0;
        for(int i= 0;i<prices.length;i++) {
        	if(prices[i]>prices[min]) {
        		profit += prices[i]-prices[min];
        	}
        	min = i;
        }
        return profit;
    }
    public static void main(String[] args) {
		int [] arr = {7,6,4,3,1};
		int ret = maxProfit(arr);
		System.out.println(ret);
	}
}
