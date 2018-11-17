package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class c21t10 {

    public static Future<Integer> fib(int n, ExecutorService executorService) {
        return executorService.submit(new Callable<Integer>() {
            private int fib(int n) {
                if (n < 2) return 1;
                return fib(n - 2) + fib(n - 1);
            }

            @Override
            public Integer call() throws Exception {
                return fib(n);
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futureResults = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureResults.add(fib(i, executorService));
        }

        for (Future<Integer> result : futureResults) {
            System.out.println(result.get());
        }

        executorService.shutdown();
    }
}
