package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPoolExample {

    ExecutorService executorService ;
    private static Logger logger = Logger.getLogger(Object.class.getName());

    public ThreadPoolExample(int numberOfThreads) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    List<Future<String>> futures = new ArrayList<>();

    // create task
    public void executeTask(int numberOfTask) {
        for(int i = 1; i <= numberOfTask; i++) {
            final int taskId = i;
            Callable<String> task = () -> {
                Thread.sleep(3000);
                return "This Task is executing " + taskId;
            };
            futures.add(executorService.submit(task));
        }
    }

    // Print task
    public void printTask() {
        futures.forEach(future -> {
                try {
                    System.out.println(future.get());
                } catch (Exception e) {
                    logger.log(Level.INFO,"Exception happened due to error {0} ", new Object[]{e.getMessage()});
                }
            });
    }

    public void shutdownTask() {
        executorService.shutdown();
    }
}
