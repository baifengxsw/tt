package cn.itcast_UDF;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToCharUDF extends UDF{
    //转换当前时间
    public String evaluate (){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }
    public String evaluate ( Date date){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }
    public String evaluate (Date date ,String rex){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(rex);
        return sdf.format(date);
    }
}
