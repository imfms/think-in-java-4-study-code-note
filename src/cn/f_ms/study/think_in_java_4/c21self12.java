package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对象方法级synchronized锁与同步块synchronized(this)用的是一把锁吗？是。
 */
class c21self12 {

    static class LockObject {

        synchronized void methodA() {
            System.out.println(String.format("%x methodA started: %s", this.hashCode(), System.currentTimeMillis() / 1000 % 10));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%x methodA ended: %s", this.hashCode(), System.currentTimeMillis() / 1000 % 10));
        }

        void methodB() {
            synchronized (this) {
                System.out.println(String.format("%x methodB started: %s", this.hashCode(), System.currentTimeMillis() / 1000 % 10));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%x methodB ended: %s", this.hashCode(), System.currentTimeMillis() / 1000 % 10));
            }
        }
    }

    public static void main(String[] args) {

        LockObject lockObject1 = new LockObject();
        LockObject lockObject2 = new LockObject();


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                lockObject1.methodA();
                lockObject2.methodA();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                lockObject1.methodB();
                lockObject2.methodB();
            }
        });

        executorService.shutdown();

    }

}
