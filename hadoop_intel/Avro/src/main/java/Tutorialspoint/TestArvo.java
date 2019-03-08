package Tutorialspoint;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需要遍历
 */
public class TestArvo {
    @Test
    public  void write() throws Exception {
        //创建写入器
        SpecificDatumWriter emp = new SpecificDatumWriter<Employee>(Employee.class);
        //装饰器
        DataFileWriter<Employee> empWriter = new DataFileWriter<Employee>(emp);
        Employee ee = new Employee();
        ee.setName("sdfd");
        ee.setAge(16);
        empWriter.create(ee.getSchema(),new  FileOutputStream("e:/avro.data"));
        empWriter.append(ee);
        empWriter.close();

    }
    @Test
    public void read() throws IOException {
        SpecificDatumReader<Employee> emp = new SpecificDatumReader<Employee>(Employee.class);
        DataFileReader<Employee> empReader = new DataFileReader<Employee>(new File("e:/avro.data"),emp);
        Employee em = null;
        while(empReader.hasNext()){
            em = empReader.next();
            System.out.println(em);
        }
    }

}
