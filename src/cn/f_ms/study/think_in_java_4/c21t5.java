package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class c21t5 {

    public static class Fibonacci implements Callable<Integer> {

        private int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        private int fib(int n) {
            if (n < 2) return 1;
            return fib(n - 2) + fib(n - 1);
        }

        @Override
        public Integer call() throws Exception {
            return fib(n);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Future<Integer>> results = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new Fibonacci(i)));
        }

        for (Future<Integer> result : results) {
            System.out.println(result.get());
        }
    }

}
