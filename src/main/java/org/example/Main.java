package org.example;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ThreadPoolExample threadPoolExample = new ThreadPoolExample(10);
        threadPoolExample.executeTask(20);
        threadPoolExample.printTask();
        threadPoolExample.shutdownTask();

        ThreadPoolExecutorExample threadPoolExecutorExample = new ThreadPoolExecutorExample();
        ThreadPoolExecutor threadPool = threadPoolExecutorExample.createThreadPool(3, 5, 1, TimeUnit.HOURS, 7);
        threadPoolExecutorExample.submitTask(threadPool, 25);
        threadPoolExecutorExample.shutdown(threadPool);

    }
}