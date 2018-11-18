package cn.itcast03.Max_temp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxTempReducer extends Reducer<IntWritable,IntWritable,IntWritable,IntWritable>{
    @Override
    protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int maxTemp = 0 ;
        for(IntWritable value:values){
            if(maxTemp<value.get()){
                maxTemp=value.get();
            }
        }
        context.write(key,new IntWritable(maxTemp));
    }
}
