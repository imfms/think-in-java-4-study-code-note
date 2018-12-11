package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class c21t21 {

    private static class WaitRunnable implements Runnable {
        @Override
        public synchronized void run() {
            try {
                System.out.println("waitrunnable wating");
                wait();
                System.out.println("waitrunable notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class NotifyRunnable implements Runnable {
        private Runnable runnable;

        public NotifyRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (runnable) {
                runnable.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitRunnable waitRunnable = new WaitRunnable();
        executorService.execute(waitRunnable);
        executorService.execute(new NotifyRunnable(waitRunnable));
        executorService.shutdown();
    }
}
