package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class c21self4 {

    public static class SimplePriorities implements Runnable {
        private int countDown = 5;
        private volatile double d; // No optimization
        private int priority;

        public SimplePriorities(int priority) {
            this.priority = priority;
        }

        public String toString() {
            return Thread.currentThread() + ": " + countDown;
        }

        public void run() {
            Thread.currentThread().setPriority(priority);
            while (true) {
                for (int i = 1; i < 100000; i++) {
                    d += (Math.PI + Math.E) / (double) i;
                    if (i % 1000 == 0)
                        Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0) return;
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(
                    new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(
                new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();

    }
}
