package cn.itcast_UDF;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
//命令行的帮助 后面显示扩展信息
@Description(name = "myadd",
        value = "add(int a , int b) ==> return a + b ",
        extended = "Example:\n"
                + " add(1,1) ==> 2 \n"
                + " add(1,2,3) ==> 6;")
public class AddUDF  extends UDF{
    public int evaluate(int a, int b){
        return a+b;
    }
}
