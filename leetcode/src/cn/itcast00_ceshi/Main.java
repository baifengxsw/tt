package cn.itcast00_ceshi;


import java.util.*;


public class Main {
   public static void  main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = Integer.parseInt(sc.nextLine());
    String [] arr = new String [n];
    for(int i = 0 ;i< arr.length;i++) {
    	arr[i] = String.valueOf(sc.nextLine());
    }
    
    
    process(arr) ;
    Arrays.
}

private static void process(String[] arr) {
	 HashMap<String,Integer> map = new HashMap<>();
	 for(int i = 0 ;i<arr.length;i++) {
		 String value = arr[i];
		 String left = value.split("=")[0].trim();
		 String right = value.split("=")[1];
		 String [] nexts = null;
		 if(right.contains("+")) {
		 nexts = right.split("\\+");
		 }else {
			 nexts = new String [] {right};
		 }
		 
		 int ret = 0;
		 for(int j = 0 ;j <nexts.length;j++) {
			 String cur = nexts[j].trim();
			  if(isNum(cur)) {
				  ret += Integer.parseInt(cur);
			  }else {
				  if(!map.containsKey(cur)) {
					  System.out.println("NA");
					  return ;
				  }else {
					  ret += map.get(cur);
				  }
			  }
		 }
		 map.put(left, ret);
		 
		 if( i == arr.length -1 ) {
			 System.out.println(ret);
		 }
		 
		 
	 }
	 
	
}

public static boolean isNum(String str) {
	for(int i = str.length() -1 ;i>=0 ;i--) {
		int  chr = str.charAt(i);
		if(chr <48 || chr >57) {
			return false;
		}
	}
	return true;
}
}