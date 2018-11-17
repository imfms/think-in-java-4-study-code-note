package cn.f_ms.study.think_in_java_4;

class c21self6 {

    static class Sleeper implements Runnable {

        @Override
        public void run() {
            System.out.println("sleeper sleep start 1000");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleeper sleep end");
        }
    }

    static class Joiner implements Runnable {

        private Thread sleeper;

        Joiner(Thread sleeper) {
            this.sleeper = sleeper;
            sleeper.start();
        }

        @Override
        public void run() {
            try {
                sleeper.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("join complete");
        }
    }

    public static void main(String[] args) {
        Thread sleeper = new Thread(new Sleeper());
        new Thread(new Joiner(sleeper)).start();
    }

}
