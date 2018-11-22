package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对于某个特定对象来说，其所有synchronized方法共享同一个锁
 * 对于某个类来说，其所有synchronized static方法共享同一个锁
 */
class c21self8 {

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

        synchronized void methodB() {
            System.out.println(String.format("%x methodB started: %s", this.hashCode(), System.currentTimeMillis() / 1000 % 10));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%x methodB ended: %s", this.hashCode(), System.currentTimeMillis() / 1000 % 10));
        }

        synchronized static void staticMethod() {
            System.out.println(String.format("staticMethod started: %s", System.currentTimeMillis() / 1000 % 10));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("staticMethod ended: %s", System.currentTimeMillis() / 1000 % 10));
        }

    }

    public static void main(String[] args) {

        LockObject lockObject1 = new LockObject();
        LockObject lockObject2 = new LockObject();


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                LockObject.staticMethod();
                lockObject1.methodA();
                lockObject2.methodA();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                LockObject.staticMethod();
                lockObject1.methodB();
                lockObject2.methodB();
            }
        });

        executorService.shutdown();

    }

}
