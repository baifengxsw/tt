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
        StringTokenizer itr  = new StringTokenizer(value.toString());
        while(itr.hasMoreTokens()){
            //我这边直接加的是完整的路径 考虑到实际需要
            keyInfo.set(itr.nextToken()+";"+split.getPath().toString());
            System.out.println(split.getPath());
            System.out.println(split.getPath().getName());
            valueInfo.set("1");
            context.write(keyInfo,valueInfo);
        }
    }
}
