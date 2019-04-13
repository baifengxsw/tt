package cn.itcast07.reverse_index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 这时候 key=单词 value=url+单词个数 ,在这里因为相同的key 所以都进入相同的reduce中这时候 就改写成 key=单词 value=url1+url2+url3+单词个数
 */
public class IndexReducer extends Reducer<Text,Text,Text,Text> {
    private Text valueInfo = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            //生成相应的文档列表
        StringBuffer sb = new StringBuffer();
        for(Text value:values){

            sb.append(value.toString()+",");
        }
        valueInfo.set(sb.toString());
        context.write(key,valueInfo);


    }
}
