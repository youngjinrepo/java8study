package execute;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        future2callback();
    }

    // 이전 까지 callback을 get을 호출하기 전에 선언하는게 불가능했다
    public static void future2callback() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " !!")
                        .thenApply( (s) -> {
                            System.out.println("s = " + s + " " + Thread.currentThread().getName());
                            return s.toUpperCase(Locale.ROOT);
                        });
        System.out.println(completableFuture.get());

        System.out.println(" ================================================= ");

        //consumer 형태
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " !!")
                .thenAccept((s) -> {
                    System.out.println("s = " + s + " " + Thread.currentThread().getName());
                });
        voidCompletableFuture.get();

        System.out.println(" ================================================= ");
        //
        CompletableFuture<Void> no_given_and_no_return = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " !!")
                .thenRun(() -> {
                    System.out.println("no given and no return");
                });

        no_given_and_no_return.get();
    }

    public static void future1() throws ExecutionException, InterruptedException {
        //리턴값이 없을 경우
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("hello world"));
        voidCompletableFuture.get();

        //리턴값이 있을 경우
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " !!");
        System.out.println(completableFuture.get());
    }

}
