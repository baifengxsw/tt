package cn.itcast07.reverse_index;

import cn.itcast.UserPortraitMod.util.LoadHdfsTable;
import cn.itcast07.reverse_index.Utils.LoadHdfsText;
import cn.itcast_04multi_input.Utils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.*;

/**
 * 这时候 key=单词 value=url+单词个数 ,在这里因为相同的key 所以都进入相同的reduce中这时候 就改写成 key=单词 value=url1+url2+url3+单词个数
 */
public class IndexReducer extends Reducer<Text,Text,Text,Text> {
    private Text valueInfo = new Text();
    private HashSet<String> set = LoadHdfsText.getSet();
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //生成相应的文档列表
      String [] arr = key.toString().split("\\s+");
        if(set.contains(arr[1])||set.contains(arr[0]))
            return ;
        /** 对拿到的数据进行排序**/
        List<String> list = new ArrayList<>();
        for(Text text :values){
            list.add(text.toString());

        }
        String [] strs = new String[list.size()];
        list.toArray(strs);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a1 = Integer.parseInt(o1.trim().split(";")[1]);
                int a2 = Integer.parseInt(o2.trim().split(";")[1]);
                return a2 -a1;
            }
        });
        StringBuffer sb = new StringBuffer();
        for(String str:strs){
            sb.append(str+",");
        }
        valueInfo.set(sb.toString());
        context.write(key,valueInfo);


    }
}
