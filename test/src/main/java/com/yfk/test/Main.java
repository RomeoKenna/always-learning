package com.yfk.test;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("wake up*********");
                throw new RuntimeException(e);
            }
            System.out.println("wake up---------------");
        });
        System.out.println("main");
        Thread.sleep(500);
        thread.interrupt();
        thread.join();
    }
}
