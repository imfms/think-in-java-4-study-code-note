package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class c21self5 {

    public static class SimpleRunnable implements Runnable {

        private static boolean isFirst = true;

        private int countDown;

        public String toString() {
            return Thread.currentThread() + ": " + countDown;
        }

        public void run() {
            if (isFirst) {
                isFirst = false;
                for (int i = 0; i < 10; i++) {
                    Thread thread = new Thread(new SimpleRunnable());
                    thread.start();
                }
            }
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(this + "-end");
                }
                System.out.println(this);
                ++countDown;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread undaemon = new Thread(new SimpleRunnable());
        undaemon.setDaemon(true);
        undaemon.start();

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
        executorService.execute(new SimpleRunnable());
        executorService.shutdown();

        Thread.sleep(2000);
    }
}
