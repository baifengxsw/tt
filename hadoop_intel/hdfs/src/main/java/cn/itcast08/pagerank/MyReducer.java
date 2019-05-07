package cn.itcast08.pagerank;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyReducer extends Reducer<IntWritable, Text, IntWritable, Text>{
    public void reduce(IntWritable key, Iterable<Text> values, Context context) {

        // 定义一个存储网页链接ID的队列
        ArrayList<String> ids = new ArrayList<>();
        // 将所有的链接ID以String格式保存
        String lianjie = " ";
        // 定义一个保存网页PR值的变量
        float pr = 0;
        //遍历
        for(Text id : values) {
            String idd = id.toString();
            //判断value是贡献值还是向外部的链接
            if (idd.substring(0, 1).equals("@")) {
                // 贡献值
                pr += Float.parseFloat(idd.substring(1));
            } else if (idd.substring(0, 1).equals("&")) {
                // 链接id
                String iddd = idd.substring(1);
                System.out.println("idddd= " + iddd);
                ids.add(iddd);
            }
        }
        // 计算最终pr
        pr = pr * 0.85f + 0.15f;
        // 得到所有链接ID的String形式
        for (int i = 0; i < ids.size(); i++) {
            lianjie += ids.get(i)+ "  ";
        }

        // 组合pr+lianjie成原文件的格式类型
        String result = pr + lianjie;
        System.out.println("Reduce    result=" + result);
        try {
            context.write(key, new Text(result));
            System.out.println("reduce 执行完毕。。。。。");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
