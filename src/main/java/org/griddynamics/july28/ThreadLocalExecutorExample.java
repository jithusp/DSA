package org.griddynamics.july28;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExecutorExample {

    // ThreadLocal to store user info per thread
    private static final ThreadLocal<String> userContext = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        userContext.set("1");
        String context=userContext.get();
        Runnable task = () -> {
            try {
//                String user = userContext.get();
                userContext.set(context);
                System.out.println(Thread.currentThread().getName() + " processing for: " + userContext.get());
            } finally {
                userContext.remove(); }
        };

//        userContext.set("1");
//        String context=userContext.get();
        executor.submit(task);

        userContext.set("2");
        executor.submit(task);

        executor.shutdown();
    }
}
