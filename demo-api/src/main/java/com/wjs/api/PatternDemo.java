package com.wjs.api;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * Created by 341039 on 2016/11/9.
 */
public class PatternDemo{
    private static AtomicInteger snumber=new AtomicInteger(0);

    public static void main(String args[]){
        System.out.println("dddd"+snumber.getAndIncrement());
        Long a=1L;
        Long b=new Long(1);
        System.out.println(a.equals(b));

        StringTokenizer str1=new StringTokenizer("a,b,c,d");
        String s="a";
        List<String> a1= Arrays.asList(s);
        System.out.println(a1.toString());
        System.out.println(a1.getClass() );

        try{
           int i=1/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        CountDownLatch cd=new CountDownLatch(7);
        cd.countDown();
        System.out.println("aa"+cd.getCount());
        String str="http://www.baidu.com";
        boolean is= Pattern.matches("http://",str);
        Pattern pattern= Pattern.compile("http://");
        String[] strings=pattern.split(".");
        for (String strs:strings){
            System.out.println(strs);
        }
        System.out.println(is);
    }
}
