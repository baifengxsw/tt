package cn.cn.itcast05_skew;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.Random;

public class RandomPartitioner  extends Partitioner<Text,IntWritable>{

    public int getPartition(Text text, IntWritable intWritable, int numPartitions) {

        return new Random().nextInt(numPartitions);
        //随机分区  相同的hello会进入 不同的分区
    }
}
