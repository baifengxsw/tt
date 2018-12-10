package cn.itcast_UDF;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToCharGenericUDF  extends GenericUDF{

    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        return null;
    }

    public Object evaluate(DeferredObject[] args) throws HiveException {
        if(args!=null && args.length!=0){
            if(args.length==1){
                //仅有一个参数
                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
                return sdf.format((Date)args[0].get());

            }else{
                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.applyPattern((String)args[1].get());
                return sdf.format((Date)args[0].get());

            }

        }else{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }

    }

    public String getDisplayString(String[] strings) {
        return null;
    }
}
