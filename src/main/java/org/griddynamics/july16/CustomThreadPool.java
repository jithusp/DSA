package org.griddynamics.july16;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

    private final BlockingQueue<Runnable> tasks;
    private final Worker[] workers;
    private volatile boolean stopFlag = false;

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!stopFlag || !tasks.isEmpty()) {
                try {
                    Runnable task = tasks.take();
                    task.run();
                } catch (InterruptedException e) {
                    if (stopFlag) break;
                }
            }
        }
    }

    public CustomThreadPool(int threadCount) {
        tasks = new LinkedBlockingQueue<>();
        workers = new Worker[threadCount];
        for (int i = 0; i < threadCount; i++) {
            workers[i] = new Worker("CustomThread-" + i);
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        if (stopFlag) throw new IllegalStateException("Thread pool is stopped");
        tasks.offer(task);
    }

    public void shutdown() {
        stopFlag = true;
        for (Worker worker : workers) {
            worker.interrupt();
        }
    }

    public static void main(String[] args) {
        CustomThreadPool pool = new CustomThreadPool(3);

        for (int i = 1; i <= 3000; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Running task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            });
        }

        pool.shutdown();
    }
}
