package cn.itcast03.Max_temp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.InputSampler;
import org.apache.hadoop.mapred.lib.TotalOrderPartitioner;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.FileInputStream;

public class MaxTempApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///"); //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("MaxTempApp");//作业名称
        job.setJarByClass(MaxTempApp.class);//搜索类
        //job.setInputFormatClass(TextInputFormat.class);  //设置输入格式
        //因为默认是map输入 是每一行和对应的偏移量 ,所以并不是想要的kv对 所以在这里进行修改
        //并且只有序列化文是直接读取kv格式的
        job.setInputFormatClass(SequenceFileInputFormat.class);
        //多个输入
        //MultipleInputs.addInputPath(job,new Path("e:/mr/seq" ),SequenceFileInputFormat.class,WCSeqMapper.class);
       // MultipleInputs.addInputPath(job,new Path("e:/mr/text"),TextInputFormat.class,MaxTempMapper.class);
         //设置输入
        FileInputFormat.setInputPaths(job,new Path("file:///e:/mr/MaxTemp/temp.seq"));

        //设置输出
        FileOutputFormat.setOutputPath(job,new Path("file:///e:/mr/out/MaxTemp"));


        job.setMapperClass(MaxTempMapper.class);
        job.setReducerClass(MaxTempReducer.class);
        job.setNumReduceTasks(3);  //设置reduce的个数
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);//如果map端和reduce端是一致的,可以不进行设置
        //这里就不用设置
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(IntWritable.class);
        //等待它

        job.setPartitionerClass(TotalOrderPartitioner.class);
        //TotalOrderPartitioner.setPartitionFile(conf,new Path("file:///e:mr/out/par.list"));
        //设置map类
        // 这是自己设置的分区类 下面使用系统的分区类
        //job.setPartitionerClass(YearPartitioner.class);
        //设置系统自带的全排序
        //进行系统采样创建随机采样器对象 frep ;每个key被选中的概率,numSample 抽取的样本总数,maxSplitSampled 最大采样切片数
        InputSampler.Sampler<IntWritable,IntWritable> sampler = new InputSampler.RandomSampler<IntWritable, IntWritable>(1,1000,3);
        //jiang sampler 对象,写到分区文件

        InputSampler.writePartitionFile(job,sampler);
        job.waitForCompletion(true);
    }
}
