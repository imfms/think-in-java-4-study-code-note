package cn.f_ms.study.think_in_java_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class c21t15_16 {
    static class Obj {

        private final Object a = new Object();
        private final Object b = new Object();
        private final Object c = new Object();
        private final Lock lock = new ReentrantLock();

        void a() {
            synchronized (a) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("a");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        }

        void b() {
            synchronized (b) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("b");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        }

        void c() {
            synchronized (c) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("c");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        }

        void lock() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("lock");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            } finally {
                lock.unlock();
            }
        }

    }

    static class CheckerA implements Runnable {
        private final Obj obj;
        CheckerA(Obj obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            obj.a();
        }
    }
    static class CheckerB implements Runnable {
        private final Obj obj;
        CheckerB(Obj obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            obj.b();
        }
    }
    static class CheckerC implements Runnable {
        private final Obj obj;
        CheckerC(Obj obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            obj.c();
        }
    }
    static class CheckerLock implements Runnable {
        private final Obj obj;
        CheckerLock(Obj obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            obj.lock();
        }
    }

    public static void main(String[] args) {
        Obj obj = new Obj();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new CheckerA(obj));
        executorService.execute(new CheckerB(obj));
        executorService.execute(new CheckerC(obj));
        executorService.execute(new CheckerLock(obj));

        executorService.shutdown();
    }

}
