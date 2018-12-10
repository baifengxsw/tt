package cn.itcast_UDF;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDateGenericUDF  extends GenericUDF{

    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        return null;
    }

    public Object evaluate(DeferredObject[] args) throws HiveException {

        if(args!=null && args.length!=0){
            if(args.length == 1){
                try {
                    //针对仅传递过来一个timestap字符串
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
                    return sdf.parse((String) args[0].get());
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }else {
                try {
                    //传入timestap  和 regx 正则化参数
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    sdf.applyPattern((String) args[1].get());
                    return sdf.parse((String) args[0].get());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            return  null;

        }else{
            //没有相应的参数
            return new Date();

        }
    }


    public String getDisplayString(String[] strings) {
        return null;
    }
}
