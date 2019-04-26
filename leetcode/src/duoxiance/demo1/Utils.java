package duoxiance.demo1;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static <T> List<List<T>> splitList(List<T>list, int pageSize){
		int size = list.size();
		int pageNum=(size+pageSize-1)/pageSize;
		List<List<T>> retList = new ArrayList<>();
		for(int i = 0;i<pageNum;i++) {
			List<T> list1 = new ArrayList<>();
			for(int j = i*pageSize;j<size;j++) {
				
				if(list1.size()==pageSize) {
					
					break;
				}
				list1.add(list.get(j));
			}
			retList.add(list1);
		}
		return retList;
	}
}
