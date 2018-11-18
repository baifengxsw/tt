package cn.itcast_04multi_input;

import java.lang.management.ManagementFactory;
import java.net.Inet4Address;

/**
 * 得到主机名 ,进程id ,线程 ,执行对象,hash码
 */
public class Utils {
    public static  String getInfo(Object o ,String info){
        return getHostName()+"-"+getPID()+"-"+getTID()+"-"+getObjInfo(o)+"-"+info;

    }
        //得到主机名
    public static  String getHostName(){
        try{
            return Inet4Address.getLocalHost().getHostName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //得到进程id
    public static int getPID(){
        try {
            String info = ManagementFactory.getRuntimeMXBean().getName();
            //info 形式pid@hostname 形式
            return Integer.parseInt(info.substring(0,info.indexOf("@")));

        }catch (Exception e){
            e.printStackTrace();
        }
        return  0;
    }
    //得到当前线程id
    public  static String getTID(){
        return Thread.currentThread().getName();


    }
    //得到对象信息
    public  static  String getObjInfo(Object o){
        try{
            //这样会将包名也打印出来return o.toString();
            String name = o.getClass().getSimpleName();
            return name+"@"+o.hashCode();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

}
