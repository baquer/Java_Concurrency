package org.example;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPoolExecutorExample {

    private static Logger logger = Logger.getLogger(Object.class.getName());

    public ThreadPoolExecutor createThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit timeUnit, int queueSize) {
        final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(queueSize);
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, queue, new ThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    }

    public void submitTask(ThreadPoolExecutor threadPoolExecutor, int numberOfTasks) {
        for(int i = 0; i < numberOfTasks; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread Name is " + Thread.currentThread().getName());
                } catch (Exception e) {
                    logger.log(Level.INFO, "Exception {0} occurred in Thread {}", new Object[]{e.getMessage(), Thread.currentThread().getName()});
                }
            });
        }
    }

    public void shutdown(ThreadPoolExecutor threadPoolExecutor) {
       threadPoolExecutor.shutdown();
    }

}
