package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class c21self10 {

    static class IntGenerator {

        private int current = 0;

        int next() {

            current++;

            Thread.yield();

            current++;

            return current;
        }

    }

    static class Checker implements Runnable {

        private static boolean isExistError = false;

        private IntGenerator generator;

        Checker(IntGenerator generator) {
            this.generator = generator;
        }

        @Override
        public void run() {
            while (!isExistError) {
                int next = generator.next();
                if (next % 2 != 0) {
                    isExistError = true;
                    System.out.println("found " + next);
                }
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        IntGenerator generator = new IntGenerator();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Checker(generator));
        }

        executorService.shutdown();

    }
}
