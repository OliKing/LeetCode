package com.oliking.codejava.tran;

public class ThreadTrans implements Runnable{

    protected int threadCount = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public ThreadTrans(){};
    public ThreadTrans(int taskCount){
        this.taskCount = taskCount;
    }

    public String status(){
        return "#" + id + "(" + (threadCount > 0 ? threadCount: "off")+")";
    }


    public void run(){
        while(threadCount-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
