package com.wjs.mongodb;

import com.mchange.v2.codegen.bean.SerializableExtension;

import java.io.Serializable;

/**
 * Created by 341039 on 2017/4/26.
 */
public class Person implements Serializable{

    private  String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
