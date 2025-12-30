package test;

import java.util.List;
import java.util.concurrent.*;

/**
 * Different ways to get concurrent data from legacy to latest.
 */
public class ConcurrentExample {

    public static void main(String[] args) {
        /* Thread and runnable option */
        long start = System.currentTimeMillis();
        ThreadCode();   // method whose execution time you want
        long end = System.currentTimeMillis();
        System.out.println("Time taken Thread: " + (end - start) + " ms");

        /* Executor Code */
        start = System.currentTimeMillis();
        try {
            ExecutorCode();   // method whose execution time you want
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        end = System.currentTimeMillis();
        System.out.println("Time taken Executor: " + (end - start) + " ms");

        /* Completable Future */
        start = System.currentTimeMillis();
        CompletableFutureCode();   // method whose execution time you want
        end = System.currentTimeMillis();
        System.out.println("Time taken CompletableFuture : " + (end - start) + " ms");

    }

    private static void CompletableFutureCode() {
        CompletableFuture<List<Order>> orderAsync = CompletableFuture.supplyAsync(() -> {
            Order o = new Order();
            return o.createOrderList();
        });

        CompletableFuture<List<Product>> productAsync = CompletableFuture.supplyAsync(() -> {
            Product p = new Product();
            return p.createProducts();
        });

        CompletableFuture<Void> objectCompletableFuture = orderAsync.thenCombine(productAsync, (orderList, productList) -> {
            System.out.println(orderList.size());
            System.out.println(productList.size());
            return null;
        });
    }

    private static void ExecutorCode() throws ExecutionException, InterruptedException {
        ExecutorService execService = Executors.newFixedThreadPool(2);
        try {
            Future<List<Order>> orderFuture = execService.submit(() -> {
                Order o = new Order();
                return o.createOrderList();
            });

            Future<List<Product>> productFuture = execService.submit(() -> {
                Product p = new Product();
                return p.createProducts();
            });
            System.out.println(orderFuture.get().size());
            System.out.println(productFuture.get().size());

        } finally {
            execService.shutdown();
        }
    }

    private static void ThreadCode() {
        Thread t1 = new Thread(() -> {
            Order o = new Order();
            List<Order> orderList = o.createOrderList();
            System.out.println(orderList.size());
        });
        Thread t2 = new Thread(() -> {
            Product p = new Product();
            List<Product> products = p.createProducts();
            System.out.println(products.size());
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
