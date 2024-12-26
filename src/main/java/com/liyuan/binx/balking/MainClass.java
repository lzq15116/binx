package com.liyuan.binx.balking;

public class MainClass {
    public static void main(String[] args) {
        DocumentEditThread.create("/Users/bbummb/Downloads/", "gen.txt").start();
    }
}
