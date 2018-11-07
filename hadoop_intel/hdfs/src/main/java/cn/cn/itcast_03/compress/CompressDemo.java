package cn.cn.itcast_03.compress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.*;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CompressDemo {
    public static void main(String[] args) throws  Exception{
        Class [] arr = {DeflateCodec.class, GzipCodec.class,
                BZip2Codec.class};
        for(Class c : arr){
            zip(c);
        }
    }

    public static void zip(Class codeClass) throws Exception{
        long start = System.currentTimeMillis();
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codeClass,new Configuration());
        CompressionOutputStream out = codec.createOutputStream(new FileOutputStream(("e:\\ceshi\\"+codeClass.getSimpleName()+codec.getDefaultExtension())));
        IOUtils.copyBytes(new FileInputStream("e:\\ceshi\\1.pptx"),out,1024);
        out.close();
        long end = System.currentTimeMillis();
        System.out.println(codeClass.getSimpleName()+":"+(end-start));

    }
}
