package com.wjs.api;

import com.google.gson.Gson;

/**
 * Created by 341039 on 2017/3/20.
 */
public class GSONUtil {

    public static void main(String[] args) {
        Gson gson=new Gson();
        String json="{\"name\":\"kidou\",\"age\":20}";
        String jsonObj=gson.fromJson(json,String.class);
        System.out.println(jsonObj);
        String str= gson.toJson("sgdfdss",String.class);
        System.out.println(str);
    }
}
