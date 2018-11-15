package cn.f_ms.study.think_in_java_4;

/**
 * $
 *
 * @author f_ms
 * @date 18-11-13
 */
class c21self1 {

    public static class LightOff implements Runnable{
        private int countDown = 10;
        private static int taskCount = 0;
        private final int id = taskCount++;

        public void status() {
            System.out.println(String.format(
                    "#%s:%s:(%s)",
                    id,
                    Thread.currentThread().getName(),
                    countDown > 0 ? countDown : "LightOff"
            ));
        }

        @Override
        public void run() {
            while (countDown-- > 0) {
                status();
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            new Thread(new LightOff()).start();
        }
    }

}
