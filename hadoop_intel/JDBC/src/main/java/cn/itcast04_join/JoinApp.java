package cn.itcast04_join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JoinApp {
    public static void main(String[] args) throws Exception {


        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "file:///"); //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("SSMaxTempApp");//作业名称
        job.setJarByClass(JoinApp.class);//搜索类
        //job.setInputFormatClass(TextInputFormat.class);  //设置输入格式
        //因为默认是map输入 是每一行和对应的偏移量 ,所以并不是想要的kv对 所以在这里进行修改
        //并且只有序列化文是直接读取kv格式的
        job.setInputFormatClass(TextInputFormat.class);
        //多个输入
        //MultipleInputs.addInputPath(job,new Path("e:/cn.itcast05_mysql_1/seq" ),SequenceFileInputFormat.class,WCSeqMapper.class);
        // MultipleInputs.addInputPath(job,new Path("e:/cn.itcast05_mysql_1/text"),TextInputFormat.class,MaxTempMapper.class);
        //设置输入
        FileInputFormat.setInputPaths(job, new Path("file:///e:/mr/join"));

        //设置输出
        FileOutputFormat.setOutputPath(job, new Path("file:///e:/mr/out/join_full"));


        job.setMapperClass(JoinDemoMapper.class);
        job.setReducerClass(JoinDemoReducer.class);
        job.setNumReduceTasks(3);  //设置reduce的个数//这个必须放在前面 不放在前面的话默认只有一个分区 就不需要采样了
        //这里是reduce端的输出
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);//如果map端和reduce端是一致的,可以不进行设置
        //这里就不用设置
        job.setMapOutputKeyClass(ComboKey.class);
        job.setMapOutputValueClass(NullWritable.class);

        //设置分区类
        job.setPartitionerClass(JoinPartation.class);
        //设置分组对比器
        job.setGroupingComparatorClass(JoinGroupComparator.class);
        //设置排序对比器
        job.setSortComparatorClass(JoinSortComparator.class);
        //等待它
        job.waitForCompletion(true);

    }
}
