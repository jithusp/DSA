package org.griddynamics.july22;// Demonstrates all key features of CompletableFuture

import java.util.concurrent.*;
import java.util.function.*;

public class CompletableFutureExamples {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);


        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Running async task"));
        CompletableFuture<String> future3 = CompletableFuture.completedFuture("Instant result");

        // 2. Transforming Results
        CompletableFuture<String> upper = future1.thenApply(String::toUpperCase);
        CompletableFuture<Void> consume = future1.thenAccept(s -> System.out.println("Received: " + s));
        CompletableFuture<Void> postRun = future1.thenRun(() -> System.out.println("Then run done"));

        // 3. thenCompose (flatMap)
        CompletableFuture<String> composed = future1.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        // 4. Combining Futures
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "A", executor);
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "B", executor);
        CompletableFuture<String> combined = f1.thenCombine(f2, (a, b) -> a + b);
        CompletableFuture<Void> both = f1.thenAcceptBoth(f2, (a, b) -> System.out.println("Both: " + a + b));

        // 5. anyOf / allOf
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "X");
        CompletableFuture<String> f4 = CompletableFuture.supplyAsync(() -> "Y");
        CompletableFuture<Object> any = CompletableFuture.anyOf(f3, f4);
        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);

        // 6. Exception Handling
        CompletableFuture<String> errorFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Failure");
        });

        CompletableFuture<String> handled = errorFuture.exceptionally(ex -> "Recovered from: " + ex.getMessage());
        CompletableFuture<String> handled2 = errorFuture.handle((res, ex) -> ex != null ? "Handled: " + ex.getMessage() : res);
        errorFuture.whenComplete((res, ex) -> System.out.println("Completed with ex: " + (ex != null)));

        // 7. Manual Completion
        CompletableFuture<String> manual = new CompletableFuture<>();
        manual.complete("Manual value");
        CompletableFuture<String> failed = new CompletableFuture<>();
        failed.completeExceptionally(new RuntimeException("Oops"));

        // 8. Blocking
        System.out.println("Upper: " + upper.get());
        System.out.println("Composed: " + composed.get());
        System.out.println("Combined: " + combined.get());
        System.out.println("AnyOf: " + any.get());
        System.out.println("Handled: " + handled.get());
        System.out.println("Handled2: " + handled2.get());
        System.out.println("Manual: " + manual.join());
        try {
            System.out.println("Failed: " + failed.join());
        } catch (CompletionException e) {
            System.out.println("Caught error: " + e.getCause().getMessage());
        }

        executor.shutdown();
    }
}
