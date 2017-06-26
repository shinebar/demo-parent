package com.wjs.api;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 341039 on 2016/11/14.
 */
public class Work {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(long workDuration) {
        this.workDuration = workDuration;
    }

    private long workDuration;
    public Work(){};
  public Work(String name, long workDuration){
      this.name=name;
      this.workDuration=workDuration;
  }
  public void doWork(){
      System.out.println(name+".......is do work");
      try {
            Thread.sleep(workDuration);
      }catch(InterruptedException IE){
            IE.printStackTrace();
      }
      System.out.println(name+"has finish work");
  }

}

class WorkerTestThread implements Runnable {
    private Work worker;
    private CountDownLatch countDownLatch;

    public WorkerTestThread(Work worker,CountDownLatch countDownLatch){
        this.worker=worker;
        this.countDownLatch=countDownLatch;
    }

    public void run() {
        worker.doWork();
        countDownLatch.countDown();
    }
}

class CountDownLatchTest {
    private static final int MAX_WORK_DURATION=5000;
    private static final int MIN_WORK_DUARATION=1000;
    private static Long getRandomWorkDuration(int min, int max){
      return (long)(Math.random()*(max-min)+min);
    }
    public static void main(String args[]){
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Work work1=new Work("name1",getRandomWorkDuration(MIN_WORK_DUARATION,MAX_WORK_DURATION));
        Work work2=new Work("name2",getRandomWorkDuration(MIN_WORK_DUARATION,MAX_WORK_DURATION));
        new Thread(new WorkerTestThread(work1,countDownLatch)).start();
        new Thread(new WorkerTestThread(work2,countDownLatch)).start();
        try{
            countDownLatch.wait();
            System.out.println("All jobs have been  finished!");
        }catch(InterruptedException ie){
           ie.printStackTrace();
        }

    }
}