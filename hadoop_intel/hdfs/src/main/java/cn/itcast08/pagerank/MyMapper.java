package cn.itcast08.pagerank;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public  class MyMapper extends
        Mapper<Object, Text, IntWritable, Text> {

    //存储网页ID
    private IntWritable id;
    //存储网页PR值
    private String pr;
    //存储网页向外链接总数目
    private int count;
    //网页向每个外部链接的平均贡献值
    private float average_pr;

    public void map(Object key, Text value, Context context) {
        StringTokenizer str = new StringTokenizer(value.toString());
        if (str.hasMoreTokens()) {
            // 得到网页ID
            id = new IntWritable(Integer.parseInt(str.nextToken()));
        } else {
            return;
        }
        // 得到网页pr
        pr = str.nextToken();
        // 得到向外链接数目
        count = str.countTokens();
        // 对每个外部链接平均贡献值
        average_pr = Float.parseFloat(pr) / count;
        // 得到网页的向外链接ID并输出
        while (str.hasMoreTokens()) {
            try {
                String nextId = str.nextToken();
                //将网页向外链接的ID以“@+得到贡献值”格式输出
                Text t = new Text("@" + average_pr);
                context.write(id, t);
                // 将网页ID和PR值输出
                Text tt = new Text("&" + nextId);
                context.write(id, tt);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}