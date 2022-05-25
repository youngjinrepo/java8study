package completefutureStudy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        eachRun();
    }

    public static void eachRun() throws ExecutionException, InterruptedException {

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            System.out.println("hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->{
            System.out.println("world " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> f = hello.thenCombine(world, (h, w) -> {
            return h + w;
        });

        System.out.println(f.get());


    }

    public static void relatedRun() throws ExecutionException, InterruptedException{
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            System.out.println("hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> compose = hello.thenCompose(App2::getWorld);
        System.out.println("compose.get() = " + compose.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(()->{
            System.out.println("world " + Thread.currentThread().getName());
            return message + "world";
        });
    }
}
