package cn.itcast07.reverse_index.Utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadHdfsFile {
    public static BufferedReader fileReader(String fileName) throws Exception {
		/*Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		FSDataInputStream in = fs.open(new Path(fileName));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));*/
        BufferedReader br = new BufferedReader((new FileReader(fileName)));
        return br;
    }
}
