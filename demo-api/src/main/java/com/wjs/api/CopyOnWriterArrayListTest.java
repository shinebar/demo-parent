package com.wjs.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 341039 on 2016/11/14.
 */
public class CopyOnWriterArrayListTest {
    private static final int THREAD_POOL_SIZE=2;

     class  AddThread implements Runnable {
        private List<Double> list;
        public AddThread(List<Double> list){
            this.list=list;
        }
        public void run() {
            for (int i=0;i<100000;i++){
                list.add(Math.random());
            }
        }
    }

    public static void main(String args[]){
        CopyOnWriterArrayListTest tes=new CopyOnWriterArrayListTest();
        List<Double> list=new ArrayList<Double>();
        ExecutorService es= Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        es.execute(new CopyOnWriterArrayListTest().new AddThread(list));
        es.execute(new CopyOnWriterArrayListTest().new AddThread(list));
        for (Double d:list) {
            System.out.println("list\t"+d);
        }
        es.shutdown();

    }
}
