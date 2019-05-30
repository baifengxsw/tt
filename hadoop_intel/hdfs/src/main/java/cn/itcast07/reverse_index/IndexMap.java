package cn.itcast07.reverse_index;

import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * map 端  key为 单词名+url   value 为词频
 */
public class IndexMap extends Mapper<Object,Text,Text,Text> {
    private Text keyInfo = new Text();
    private Text valueInfo = new Text();
    private FileSplit split ;
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
       //获取FileSplit对象
        split =(FileSplit )context.getInputSplit();
        //将文本中值按空格进行分割
        String [] arr = getSplits(value.toString());
        if(arr == null )
            return ;
        for(String str:arr){
            //我这边直接加的是完整的路径 考虑到实际需要
            keyInfo.set(str+"%"+split.getPath().toString());
            System.out.println(str+"%"+split.getPath().toString());
            valueInfo.set("1");
            context.write(keyInfo,valueInfo);
        }
    }
    public static String[] getSplits(String str) {
        if(str==null || str.length()==0)
            return null;
        String [] arr = str.trim().split("\\s+");

        if(arr.length ==2) {
            return new String [] {arr[0] +" "+arr[1]};
        }else if(arr.length >2) {
            String [] ret = new String [2*(arr.length-2)+1];
            int index = 0;
            for(int i = 0;i<arr.length-1;i++) {
                for(int j = 1;j<3;j++) {
                    ret[index++] = arr[i]+" "+arr[i+j];
                    if(i == arr.length-2)
                        break;
                }
            }
            return ret;
        }else {

            return null;
        }
    }
}
