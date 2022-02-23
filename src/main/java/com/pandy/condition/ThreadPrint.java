package com.pandy.condition;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Pandy
 * @create: 2022/2/23
 * 阿里巴巴面试题： 交替打印奇偶数
 **/
public class ThreadPrint extends Thread {

    private static final int MAX_PRINT_NUM = 100;

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 方法1： 使用atomicInteger实现
     */
    private static void printAB() {
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                if (atomicInteger.get() % 2 == 0) {
                    System.out.println("num1: " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();

        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                if (atomicInteger.get() % 2 != 0) {
                    System.out.println("num2: " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
    }

    /**
     * 方法2： 使用volatile关键字实现
     */

    private static volatile int count = 0;

    private static void printCD() {
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    System.out.println("num1: " + count);
                    count++;
                }
            }
        }).start();

        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    System.out.println("num2: " + count);
                    count++;
                }
            }
        }).start();
    }



    public static void main(String[] args) {
//        printAB();
        printCD();
    }
}
