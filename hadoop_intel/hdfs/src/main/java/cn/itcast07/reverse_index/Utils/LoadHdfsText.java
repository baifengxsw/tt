package cn.itcast07.reverse_index.Utils;

import java.io.BufferedReader;
import java.util.HashSet;

public class LoadHdfsText {
    private static HashSet<String > set = new HashSet<>();
    private static  String  filePath = "e:\\stopwords.txt";
    static{
        try {
            BufferedReader br = ReadHdfsFile.fileReader(filePath);
            String line = null;
            while((line = br.readLine())!=null){
                //if(line.trim().length()<=2)
                set.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashSet<String> getSet() {
        return set;
    }

    public static void setSet(HashSet<String> set) {
        LoadHdfsText.set = set;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        LoadHdfsText.filePath = filePath;
    }
}
