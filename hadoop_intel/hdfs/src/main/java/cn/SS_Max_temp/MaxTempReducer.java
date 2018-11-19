package cn.SS_Max_temp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxTempReducer extends Reducer<ComboKey,NullWritable,IntWritable,IntWritable>{
    @Override
    protected void reduce(ComboKey key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
            context.write(new IntWritable(key.getYear()),new IntWritable(key.getTemp()));
    }
}
