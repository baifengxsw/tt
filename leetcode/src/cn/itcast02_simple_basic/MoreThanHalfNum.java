package cn.itcast02_simple_basic;
/**
 * 以O(n)的方式解决寻找出现频率最高的值
 * @author baifeng
 *
 */
public class MoreThanHalfNum {
    public static int  getValue(int [] arr) {
    	if(arr==null)
    		return -1;
    	int result = arr[0];
    	int times = 1;
    	for(int i = 0 ;i<arr.length ; i++) {
    		if(times == 0) {
    			result = arr[i];
    		}else if (result == arr[i]) {
    			times++;
    		}else {
    			times--;
    		}
    	}
    	times = 0;
    	for(int i = 0 ;i<arr.length;i++) {
    		if(result == arr[i]) {
    			times++;
    		}
    	}
    	return times >arr.length /2 ? result : -1;
    }
}
