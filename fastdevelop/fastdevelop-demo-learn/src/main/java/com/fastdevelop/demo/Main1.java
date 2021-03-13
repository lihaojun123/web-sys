package com.fastdevelop.demo;

public class Main1 {

    private static final long count = 100001;

    public static void main(String[] args) {

    }

    public static void concurrency() {
        long start = System.currentTimeMillis();
        Runnable runnable = ()->{};
        new Thread(runnable).start();
    }
}
