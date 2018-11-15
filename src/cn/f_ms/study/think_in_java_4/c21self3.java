package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class c21self3 {

    static class TaskWithResult implements Callable<String> {
        private final String id;

        public TaskWithResult(String id) {
            this.id = id;
        }
        @Override
        public String call() throws Exception {
            Thread.sleep(200);
            Thread.yield();
            return "task-" + id;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> results = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            results.add(
                    executorService.submit(new TaskWithResult(String.valueOf(i)))
            );
        }

        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        executorService.shutdown();
    }
}
