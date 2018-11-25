package cn.itcast06_rackaware;

import org.apache.hadoop.net.DNSToSwitchMapping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 机架感知类
 */ 
public class MyRackAware implements DNSToSwitchMapping{

    public List<String> resolve(List<String> names) {
        List<String> list = new ArrayList<String>();
        FileWriter fw = null;
        try {
           fw = new FileWriter("/home/hadoop/sss.txt", true);

            for (String str : names) {
                fw.write(str+"\r\n");
                if (str.startsWith("192")) {
                    //以ip开头
                    String mark = str.substring(str.lastIndexOf(".") + 1);
                    fw.write(mark);
                    if (Integer.parseInt(mark) <= 133 && Integer.parseInt(mark) > 131) {

                        list.add("/rack1/" + mark);
                    } else {
                        list.add("/rack2/" + mark);
                    }
                } else if (str.startsWith("S")) {
                    //以s开头  Slave
                    String mark = str.substring(str.lastIndexOf("e") + 1);
                        fw.write(mark);
                    if (Integer.parseInt(mark) <= 2 && Integer.parseInt(mark) >= 1) {

                        list.add("/rack1/" + mark);
                    } else {
                        list.add("/rack2/" + mark);
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;


    }


    public void reloadCachedMappings() {

    }

    public void reloadCachedMappings(List<String> names) {

    }
}
