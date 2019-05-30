package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * hive 的测试
 */
public class SqlHiveDemo {
    public static void main(String[] args) {
        //必须要conf
        SparkConf conf = new SparkConf();
        conf.setMaster("local");
        conf.setAppName("hivedemo");
        SparkSession session = SparkSession.builder().appName("javaSql").
                config("spark.master","local").getOrCreate();


        //Dataset<Row> dt = session.sql("show databases");
        session.sql("use ceshi ");
        Dataset<Row> dt1 = session.sql("select * from ceshi.tts");
        dt1.show();
        //session.sql("create database sss");
        //dt.show();


        //Dataset<Row> df = session.sql("select * from ceshi.tt1");
        //df.show();
        session.close();
    }
}
