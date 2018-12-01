package cn.itcast04_join;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class JoinPartation extends Partitioner<ComboKey, NullWritable> {
    public int getPartition(ComboKey comboKey, NullWritable nullWritable, int numPartitions) {
        return comboKey.getCid() % numPartitions;
    }
}
