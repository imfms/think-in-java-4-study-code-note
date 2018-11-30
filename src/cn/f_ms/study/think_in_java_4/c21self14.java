package cn.f_ms.study.think_in_java_4;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 中断阻塞
 *
 * @author f_ms
 * @date 18-11-30
 */
class c21self14 {

    /**
     * 休眠阻塞，可以中断
     */
    private static class SleepBlocked implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("SleepBlocked interrupted");
            }
            System.out.println("SleepBlocked exit");
        }
    }

    /**
     * Io阻塞，无法中断
     */
    private static class IoBlocked implements Runnable {
        @Override
        public void run() {
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("IoBlocked Interrupted");
            }
            System.out.println("IoBlocked exit");
        }
    }

    /**
     * 同步阻塞
     */
    private static class SyncBlocked implements Runnable {
        private synchronized void sync() {
            while (true) {
               Thread.yield();
            }
        }

        public SyncBlocked() {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    sync();
                }
            }.start();
        }

        @Override
        public void run() {
            sync();
            System.out.println("SyncBlocked exit");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new SleepBlocked());
        executorService.execute(new IoBlocked());
        executorService.execute(new SyncBlocked());
        executorService.shutdown();

        TimeUnit.SECONDS.sleep(1);

        executorService.shutdownNow();
    }

}
