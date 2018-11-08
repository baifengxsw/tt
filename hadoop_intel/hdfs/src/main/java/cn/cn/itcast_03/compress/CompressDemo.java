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
            unzip(c);
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
    public static void unzip(Class codecClass) throws Exception{
        long start = System.currentTimeMillis();
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(codecClass,new Configuration());
        //创建文件输入流
        FileInputStream fis = new FileInputStream("e:\\ceshi\\"+codecClass.getSimpleName()+codec.getDefaultExtension());
        CompressionInputStream cis  = codec.createInputStream(fis);
        IOUtils.copyBytes(cis,new FileOutputStream("e:\\ceshi\\"+codecClass.getSimpleName()+".pptx"),1024);
        cis.close();
        long end  = System.currentTimeMillis();
        System.out.println(codecClass.getSimpleName()+"unzip:"+(end-start));
    }

}
