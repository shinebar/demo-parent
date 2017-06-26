package com.wjs.api;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by 341039 on 2016/12/10.
 */
public class InvokerMehod {
    //参数类型Map
    public Map<String,Object> getMapArgs(Map<String,Object> map){
        Iterator<String> iterator=map.keySet().iterator();
        while (iterator.hasNext()){
            String key=iterator.next();
            System.out.println(key);
            Object value=map.get(key);
            System.out.println(value);
        }
        return map;
    }

    //参数类型list
    public List<Object> getListObject(List<Object> ob) {
        return ob;
    }

    public List<Work> getListGeneric(List<Work> lg){
        return lg;
    }
    public List<Work> cubc(List<Work> lg){
        System.out.println("list CUBC");
        return lg;
    }

    public List<Work> foss(List<Work> lg){
        System.out.println("list FOSS");
        return lg;
    }

    public String foss(String str){
        System.out.println("FOSS STR");
        return str;
    }

    public String cubc(String str){
        System.out.println("cubc STR");
        return str;
    }


    //参数类型String

    public String getStringValue(String value) {
        return value;
    }
    //参数类型String[]
    public String[] getStringArray(String[] str){
        return str;
    }

    //无参参数类型
    public String getVoid(){
        return "void方法返回值";
    }

    //有参数无返回值
    public void getSynValue(String str){
        System.out.println("getSynValue\t"+str);
    }
}
