package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactory  implements java.util.concurrent.ThreadFactory {
    private final AtomicInteger threadNumber = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        String threadName = "@" + threadNumber.incrementAndGet();
        return new Thread(r, threadName);
    }
}
