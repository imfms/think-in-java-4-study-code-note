package cn.f_ms.study.think_in_java_4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock Object
 *
 * @author f_ms
 * @date 18-11-23
 */
class c21self9 {

    static class LockAccepter implements Runnable {

        private final Lock lock;
        private final String name;

        LockAccepter(Lock lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(String.format(
                        "%s %s start",
                        System.currentTimeMillis() / 1000 % 1000,
                        name
                ));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(String.format(
                        "%s %s end",
                        System.currentTimeMillis() / 1000 % 1000,
                        name
                ));

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new LockAccepter(lock, String.valueOf(i)));
        }

        executorService.shutdown();
    }

}
