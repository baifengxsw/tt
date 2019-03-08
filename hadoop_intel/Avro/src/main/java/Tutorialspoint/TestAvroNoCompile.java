package Tutorialspoint;

import org.apache.avro.Schema;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 不需要编译
 */
public class TestAvroNoCompile {
    @Test
    public  void  write() throws IOException {
        Schema scheam = new Schema.Parser().parse(new File("F:/文档/Hadoop/软件包/avro-protobuf/emp.avsc"));
        //通过schema创建一个常规记录类型对象 相当于生成employee
        GenericRecord e1 = new GenericData.Record(scheam);
        e1.put("Name","xia");
        e1.put("age",23);
        DatumWriter<GenericRecord> emp = new GenericDatumWriter<GenericRecord>(scheam);
        DataFileWriter<GenericRecord> empWriter = new DataFileWriter<GenericRecord>(emp);
        empWriter.create(scheam,new FileOutputStream("e:/xia.txt"));
        empWriter.append(e1);
        empWriter.close();
    }

    @Test
    public  void Read() throws IOException{
        Schema scheam = new Schema.Parser().parse(new File("F:/文档/Hadoop/软件包/avro-protobuf/emp.avsc"));
        //通过schema创建一个常规记录类型对象 相当于生成employee
        GenericRecord e1 = new GenericData.Record(scheam);
        DatumReader dr = new GenericDatumReader(scheam);
        DataFileReader df = new DataFileReader(new File("e:/xia.txt"),dr);
        while(df.hasNext()){
            System.out.println(df.next());
        }


    }
}
