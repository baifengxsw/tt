package cn.SS_Max_temp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapred.lib.InputSampler;
import org.apache.hadoop.mapred.lib.TotalOrderPartitioner;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
//D:\tt\hadoop_intel\hdfs\src\main\java\cn\SS_Max_temp
public class MaxTempApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        conf.set("fs.defaultFS","file:///");
        Job job = Job.getInstance(conf);

        //设置job的各种属性
        job.setJobName("SecondarySortApp");                        //作业名称
        job.setJarByClass(MaxTempApp.class);                 //搜索类
        job.setInputFormatClass(TextInputFormat.class); //设置输入格式

        //添加输入路径
        FileInputFormat.addInputPath(job,new Path("e:/temp.txt"));
        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path("e:/out"));

        job.setMapperClass(MaxTempMapper.class);             //mapper类
        job.setReducerClass(MaxTempReducer.class);           //reducer类

        //设置Map输出类型
        job.setMapOutputKeyClass(ComboKey.class);            //
        job.setMapOutputValueClass(NullWritable.class);      //

        //设置ReduceOutput类型
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);         //

        //设置分区类
        job.setPartitionerClass(YearPartitioner.class);
        //设置分组对比器
        job.setGroupingComparatorClass(SplitGroup.class);
        //设置排序对比器
        job.setSortComparatorClass(ComkeyComparator.class);

        job.setNumReduceTasks(3);                           //reduce个数

        //
        job.waitForCompletion(true);


    }
}
