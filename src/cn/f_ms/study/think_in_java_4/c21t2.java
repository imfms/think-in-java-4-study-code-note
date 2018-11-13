package cn.f_ms.study.think_in_java_4;

import java.util.Arrays;

class c21t2 {

    public static class Fibonacci implements Runnable {

        private static int taskCount = 0;
        private final int id = taskCount++;

        private int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        private int fib(int n) {
            if (n < 2) return 1;
            return fib(n - 2) + fib(n - 1);
        }

        @Override
        public void run() {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = fib(i);
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            new Thread(new Fibonacci(i)).start();
        }
    }

}
