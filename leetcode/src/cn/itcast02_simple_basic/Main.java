package cn.itcast02_simple_basic;





import java.util.*;

/**
 * 鍥剧殑绠楁硶
 */
public class Main{


    public static class Data{
        public  int id ;
        public int  [] arr = null;
        public Data (int id ,int [] arr ){
            this.id = id;
            this .arr = arr;
        }

        public boolean equal(Data obj) {
          boolean flag = true;
          if(obj.id != this.id) {

              for (int i = 0; i < obj.arr.length; i++) {
                  if (obj.arr[i] == 1 && arr[i] == 1) {
                      flag = false;
                  }
              }
          }
          return flag;
        }
    }




        public static class UnionFindAll{
            //fatherMap<data1,data2> data2 鏄痙ata1鐨勭埗鑺傜偣 锛屽悜涓婃洿鏂扮殑鏃跺�欒繘琛屾敼鍙�
            HashMap<Data,Data> fatherMap ;
            HashMap<Data,Integer> sizeMap ;

            public UnionFindAll(List<Data>list) {
                fatherMap = new HashMap<Data,Data>();
                sizeMap = new HashMap<Data,Integer>();
                //鍒濆鍖�
                initUnion(list);
            }

            private void initUnion(List<Data> list) {
                // TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
                fatherMap.clear();
                sizeMap.clear();
                for(Data data:list) {
                    fatherMap.put(data, data);
                    sizeMap.put(data, 1);
                }
            }
            /************************/
            public Data getDaibiao(Data data) {
//			Data father = fatherMap.get(data);
//			if(data!=father) {
//				father = getDaibiao(father);
//			}
//			fatherMap.put(data, father);
//			return father;
                Stack<Data> stack = new Stack<Data>();
                Data cur = data;
                Data parent = fatherMap.get(data);
                while(cur.id!=parent.id) {
                    stack.push(cur);
                    cur = parent;
                    parent = fatherMap.get(cur);
                }
                while(!stack.isEmpty()) {
                    fatherMap.put(stack.pop(), parent);
                }
                return parent;
            }

            public boolean isSameSet(Data a, Data b) {
                return getDaibiao(a).id==getDaibiao(b).id;
            }

            public void union(Data a ,Data b) {
                if(a == null || b == null) {
                    return ;
                }
                Data ad = getDaibiao(a);
                Data bd = getDaibiao(b);
                int adSize = sizeMap.get(ad);
                int bdSize = sizeMap.get(bd);
                if(!ad.equal(bd)) {
                    if(adSize <= bdSize) {
                        fatherMap.put(ad, bd);
                        for(int i = 0; i<bd.arr.length;i++){
                            if(ad.arr[i]==1){
                                bd.arr[i] = 1;
                            }
                        }
                        sizeMap.put(bd, adSize + bdSize);
                    }else {
                        for(int i = 0; i<bd.arr.length;i++){
                            if(bd.arr[i]==1){
                                ad.arr[i] = 1;
                            }
                        }
                        fatherMap.put(bd, ad);
                        sizeMap.put(ad,adSize + bdSize);
                    }
                }
            }}



    public static void main (String [] arrs){
        Scanner sc = new Scanner(System.in);
        int personNum = sc.nextInt();
        int languageNum = sc.nextInt();
        int [][] all = new int [personNum][languageNum];
        int index = 0;
        for(int i = 0 ;i<personNum;i++){
            int num = sc.nextInt();
            if (num ==0)
                index ++;
            for(int j  = 0 ;j< num ;j++){
                int value  = sc.nextInt();
                all[i][value-1] = 1 ;
            }
        }
        List<Data> list = new ArrayList<Data>();
        for(int i = 0 ; i<all.length;i++){
            Data data = new Data(i,all[i]) ;
            list.add(data);
        }

        UnionFindAll union = new UnionFindAll(list);
        for(int i = 0 ; i< list.size();i++){
            for(int j = 0 ;j <list.size();j++){
                union.union(list.get(i),list.get(j));
            }
        }

        Map<Data,Data> fathermap = union.fatherMap;
        Set<Integer> set = new HashSet<Integer>();
        int size = 0;
        for(Data key :fathermap.keySet()){
            int id = fathermap.get(key).id;
            if(!set.contains(id)){
                set.add(id);
            }
        }
        if(index == list.size()){
           System.out.println( list.size());
        }else{
            System.out.println(set.size()-1);
        }


    }
}
