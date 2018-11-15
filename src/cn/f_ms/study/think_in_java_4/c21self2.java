package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class c21self2 {
    public static void main(String[] args) throws InterruptedException {
        // exec(Executors.newCachedThreadPool());
        // exec(Executors.newFixedThreadPool(3));
        exec(Executors.newSingleThreadExecutor());
    }

    private static void exec(ExecutorService executorService) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            executorService.execute(new c21self1.LightOff());
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new c21self1.LightOff());
        }
        executorService.shutdown();
    }
}
