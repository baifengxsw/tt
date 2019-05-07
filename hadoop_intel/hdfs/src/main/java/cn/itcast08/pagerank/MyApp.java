package cn.itcast08.pagerank;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MyApp {

    public static void main(String[] args) throws IOException,
            InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///");
        String pathIn1 = "e:/pagerank/";//输入路径
        String pathOut= "e:/pagerank/out" ; //输出路径
        //迭代10次
        for (int i = 0; i < 10; i++) {
            System.out.println("xunhuan cishu=" + i);
            Job job = new Job(conf, "MapReduce pagerank");
            pathOut = pathIn1 + i;
            job.setJarByClass(MyApp.class);
            job.setMapperClass(MyMapper.class);
            job.setReducerClass(MyReducer.class);
            job.setOutputKeyClass(IntWritable.class);
            job.setOutputValueClass(Text.class);
            FileInputFormat.addInputPath(job, new Path(pathIn1));
            FileOutputFormat.setOutputPath(job, new Path(pathOut));
            pathIn1 = pathOut;
            job.waitForCompletion(true);

        }

    }
}
