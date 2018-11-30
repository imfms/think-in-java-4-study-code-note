package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 修改OrnamentalGarden.java 使其使用interrupt()
 *
 * @author f_ms
 * @date 18-11-30
 */
class c21t19 {

    static class Count {
        private int count = 0;
        private Random rand = new Random(47);

        // Remove the synchronized keyword to see counting fail:
        public synchronized int increment() {
            int temp = count;
            if (rand.nextBoolean()) // Yield half the time
                Thread.yield();
            return (count = ++temp);
        }

        public synchronized int value() {
            return count;
        }
    }

    static class Entrance implements Runnable {
        private static Count count = new Count();
        private static List<Entrance> entrances =
                new ArrayList<Entrance>();
        private int number = 0;
        // Doesn't need synchronization to read:
        private final int id;

        public Entrance(int id) {
            this.id = id;
            // Keep this task in a list. Also prevents
            // garbage collection of dead tasks:
            entrances.add(this);
        }

        public void run() {
            while (true) {
                synchronized (this) {
                    ++number;
                }
                System.out.println(this + " Total: " + count.increment());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("Stopping " + this);
        }

        public synchronized int getValue() {
            return number;
        }

        public String toString() {
            return "Entrance " + id + ": " + getValue();
        }

        public static int getTotalCount() {
            return count.value();
        }

        public static int sumEntrances() {
            int sum = 0;
            for (Entrance entrance : entrances)
                sum += entrance.getValue();
            return sum;
        }
    }

    public static class OrnamentalGarden {
        public static void main(String[] args) throws Exception {
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < 5; i++)
                exec.execute(new Entrance(i));
            // Run for a while, then stop and collect the data:
            TimeUnit.SECONDS.sleep(3);
            exec.shutdownNow();
            exec.shutdown();
            if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
                System.out.println("Some tasks were not terminated!");
            System.out.println("Total: " + Entrance.getTotalCount());
            System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
        }
    }
}
