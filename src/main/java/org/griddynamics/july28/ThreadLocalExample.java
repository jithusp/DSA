package org.griddynamics.july28;

public class ThreadLocalExample {

    private static final ThreadLocal<Integer> userThreadLocal1 = new ThreadLocal<>();
    private static final ThreadLocal<Integer> userThreadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            userThreadLocal1.set(1);
            userThreadLocal2.set(1);
            System.out.println(Thread.currentThread().getName() + ": " + userThreadLocal1.get());
        };

        Runnable task2 = () -> {
            userThreadLocal1.set(1);
            userThreadLocal2.set(1);
            System.out.println(Thread.currentThread().getName() + ": " + userThreadLocal1.get());



        };

        new Thread(task1, "First thread").start();
        new Thread(task2, "second thread").start();
    }
}
