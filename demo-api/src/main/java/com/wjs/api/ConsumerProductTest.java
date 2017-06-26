package com.wjs.api;


import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 341039 on 2016/11/14.
 */
public class ConsumerProductTest {

    class Task{
        private String id;
        public Task(){
            id= UUID.randomUUID().toString();
        }
        public String toString(){
            return "task["+id+"]";
        }
    }
    class Consumer implements Runnable {
        private BlockingQueue<Task> buffer;
        public Consumer(BlockingQueue<Task> buffer){
            this.buffer=buffer;
        }
        public void run() {
            while (true){
                try{
                    Task  task = buffer.take();
                    System.out.println("Consumer["+ Thread.currentThread().getName()+"] got "+task);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }


            }
        }
    }
    class Producter implements Runnable {
        private BlockingQueue<Task> buffer;
        public Producter(BlockingQueue<Task> buffer){
            this.buffer=buffer;
        }
        public void run() {
            while(true){
                try{
                    Task task=new Task();
                    buffer.put(task);
                    System.out.println("producter["+ Thread.currentThread().getName()+"] put "+task);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }

            }
        }
    }
    public static void main(String args[]) {
        final int MAX_BUFFER_SIZE = 10;
        final int NUM_OF_PRODUCTER = 2;
        final int NUM_OF_CONSUMER = 3;
        BlockingQueue<Task> buffer = new LinkedBlockingQueue<Task>(MAX_BUFFER_SIZE);
        ExecutorService executerService= Executors.newFixedThreadPool(NUM_OF_CONSUMER+NUM_OF_PRODUCTER);
        for(int i=0;i<NUM_OF_PRODUCTER;i++){
            executerService.execute(new ConsumerProductTest().new Producter(buffer));
        }
        for (int i=0;i<NUM_OF_CONSUMER;i++){
            executerService.execute(new ConsumerProductTest().new Consumer(buffer));
        }

    }

}
