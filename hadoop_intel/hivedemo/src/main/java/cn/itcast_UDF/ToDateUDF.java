package cn.itcast_UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDateUDF {
    //形参为空
    public Date evaluate(){
        return new Date();
    }
    public  Date evaluate(String timestr){
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy/MM/dd  HH:mm:ss");
             date = sdf.parse(timestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }
    public  Date evaluate(String timestr ,String regx){
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern(regx);
             date = sdf.parse(timestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }
}
