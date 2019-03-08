package com.example.tutorial;

import org.junit.Test;

import java.io.*;


public class TestProtobuf {
    @Test
    public void write(){
        AddressBookProtos.Person john = AddressBookProtos.Person.newBuilder()
                .setId(1233)
                .setName("toma")
                .setEmail("123@qq.com")
                .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
                .setNumber("1231322131")
                .setType(AddressBookProtos.Person.PhoneType.HOME).build())
                .build();

        try {
            john.writeTo(new FileOutputStream("e:/protobuf.data"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void parse(){
        try {
            AddressBookProtos.Person  person = AddressBookProtos.Person.parseFrom(new FileInputStream("e:/protobuf.data"));
            System.out.println(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * java类的串行化
     */
    @Test
    public void writeInJava() throws Exception {
        long start = System.currentTimeMillis();
        Person person = new Person();
        person.setId(1);
        person.setName("tom");
        person.setEmail("123@qq.com");
        person.setPhoneNo("12313131");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/writeinjava.data"));
        oos.writeObject(person);
        //写完后关闭
        oos.close();
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));

    }
}
