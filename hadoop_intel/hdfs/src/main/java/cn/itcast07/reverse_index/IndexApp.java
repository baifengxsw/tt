package cn.itcast07.reverse_index;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class IndexApp {

    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            /*if(args.length!=2)
            {
                System.out.println("Usage:wordCount<in><out>");
                System.exit(1);
            }*/
            Job job = Job.getInstance();
            job.setJarByClass(IndexApp.class);

            //实现map函数，根据输入的<key,value>对生成中间结果。
            job.setMapperClass(IndexMap.class);

            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);

            job.setCombinerClass(IndexCombiner.class);

            job.setReducerClass(IndexReducer.class);

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            //job.setSortComparatorClass(TextComparator.class);
            job.setNumReduceTasks(1);  //设置reduce的个数
            //我把那两个文件上传到这个index目录下了
            FileInputFormat.addInputPath(job, new Path("e:/WeGame"));
            //把结果输出到out_index+时间戳的目录下
            FileOutputFormat.setOutputPath(job, new Path("e:/WeGame/out"));

            System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


