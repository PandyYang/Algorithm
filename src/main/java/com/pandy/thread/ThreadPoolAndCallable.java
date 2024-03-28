package com.pandy.thread;

import java.util.concurrent.*;

public class ThreadPoolAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            System.out.println("enable callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        System.out.println("submitting Callable");
        Future<String> future = executor.submit(callable);

        System.out.println("do something when callable is executing");
        System.out.println("received: " + future.get());

        executor.shutdown();
    }
}
