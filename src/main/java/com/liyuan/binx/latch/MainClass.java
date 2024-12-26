package com.liyuan.binx.latch;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        new ProgrammerTravel(latch, "Name1", "T1").start();
        new ProgrammerTravel(latch, "Name2", "T2").start();
        new ProgrammerTravel(latch, "Name3", "T3").start();
        new ProgrammerTravel(latch, "Name4", "T4").start();
        try {
            latch.await(TimeUnit.SECONDS, 5);
            System.out.println("== all of programmer arrived ==");
        } catch (WaitTimeoutException e) {
            e.printStackTrace();
        }

    }
}
