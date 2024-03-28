package com.pandy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureAndCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("enable callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("do something else while callable is getting executed");
        System.out.println("Received: " + futureTask.get());
    }
}
