package com.liyuan.binx.latch;

import java.util.concurrent.TimeUnit;

public abstract class Latch {

    // 门阀的控制数量
    protected int limit;

    // 通过构造函数设置limit
    public Latch(int limit) {
        this.limit = limit;
    }

    // 该方法会使当前线程等待，知道所有线程完成任务，被阻塞线程是允许被中断的
    public abstract void await() throws InterruptedException;

    public abstract void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeoutException;

    // 任务线程完成工作后，调用该方法使计数减一
    public abstract void countDown();

    // 获取当前还没有完成的任务
    public abstract int getUnarrived();


}
