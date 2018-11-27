package cn.f_ms.study.think_in_java_4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal
 */
class c21self13 {

    static class ThreadLocalHolder {
        private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return new Random().nextInt(10000);
            }
        };

        public static void increment() {
            value.set(value.get() + 1);
        }

        public static int get() {
            return value.get();
        }
    }

    static class Checker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getId() + ": " + ThreadLocalHolder.get());
                ThreadLocalHolder.increment();
                Thread.yield();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Checker());
        }

        executorService.shutdown();
    }

}
