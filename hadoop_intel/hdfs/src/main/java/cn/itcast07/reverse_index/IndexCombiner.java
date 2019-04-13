package cn.itcast07.reverse_index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 组合类 combiner 这里要进行词频的统计 将原先的数据 key=单词名+url value=1 进行单词数量的统计
 * 并且最后进行分割  转变为 key = 单词名  value=url+value(单词个数)
 */
public class IndexCombiner extends Reducer<Text,Text,Text,Text> {
    private Text keyInfo = new Text();
    private Text valueInfor = new Text();
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //统计词频
        int count = 0;
        for(Text value :values){
            count++;
        }
        String[] keyArr = key.toString().split(";");
        keyInfo.set(keyArr[0]);
        valueInfor.set(keyArr[1]+";"+count);
        context.write(keyInfo,valueInfor);

    }
}
