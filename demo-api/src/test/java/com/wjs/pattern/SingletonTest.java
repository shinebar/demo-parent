package com.wjs.pattern;

import org.junit.Test;
import org.springframework.test.annotation.SystemProfileValueSource;

/**
 * Created by 341039 on 2017/3/20.
 */
public class SingletonTest {

    @Test
    public void testSingleTon(){
        Long startTime=System.currentTimeMillis();
        System.out.println("start time"+ System.currentTimeMillis());
             Singleton singleton= Singleton.getInstance();
        Long endTime =System.currentTimeMillis();
        System.out.println("end time"+ System.currentTimeMillis());
        System.out.println("end time - start time "+(endTime - startTime));
    }
}
