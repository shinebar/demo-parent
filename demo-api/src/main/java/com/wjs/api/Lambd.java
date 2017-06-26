package com.wjs.api;

import com.mysql.jdbc.TimeUtil;

import java.util.concurrent.*;

/**
 * Created by 341039 on 2017/3/24.
 */
public class Lambd {

    public static void maina(String[] args) {


        Runnable task=()->{
            try{
                String name=Thread.currentThread().getName();
                System.out.println("foo"+name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("bar"+name);
            }catch(RuntimeException RE){
                RE.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        task.run();
        Thread thread=new Thread(task);
        thread.start();
        System.out.println("down");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable;
        callable = ()->{
            try{
                TimeUnit.SECONDS.sleep(1);
                return "123";
            }catch(InterruptedException ie){
                throw new IllegalStateException("task interrupted", ie);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String>  future=executor.submit(callable);
        System.out.println(future.isDone());
        String na=future.get();
        System.out.println("dddddddddddddddd\t"+na);
        System.out.println(future.isDone());
        try {
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello " + threadName);
            });
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }



}
