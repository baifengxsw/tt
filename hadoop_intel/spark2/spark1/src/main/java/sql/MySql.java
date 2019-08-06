package sql;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class MySql {
    public static void main(String[] args) {
        SparkSession session = SparkSession.builder().appName("mySql").
                config("spark.master","local[1]").getOrCreate();
        String url = "jdbc:hive2://master:10000/";
        String table = "words";
        //查询
        Dataset dt = session.read().format("jdbc")
                .option("url",url)
                .option("dbtable","test")
                .load();
        dt.show();

        //这里也可以使用property的方式
        //保存数据
        //新先进行投影查询
        //Dataset<Row> dt2 = dt.select("id","name");

    }
}
