package execute;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Foo {

    public static void main(String[] args) throws ExecutionException, InterruptedException  {
        multiThread();
    }

    private static void executor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
        });

        // 마무리하고 죽임
        executorService.shutdown();
        // 바로 죽임
        executorService.shutdownNow();
    }

    public static void caller() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String > callable = () ->{
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> future = executorService.submit(callable);
        System.out.println("future.isDone() = " + future.isDone());

        future.cancel(false);

        System.out.println("future.isDone() = " + future.isDone());
        System.out.println("end");
        executorService.shutdown();
    }

    public static void multiThread() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<String> hi = () -> "hi";
        Callable<String> hello = () -> "hello";
        Callable<String> hey = () -> "hey";

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hi, hello, hey));
        futures.stream().forEach( (l) -> {
            try {
                System.out.println(l.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
