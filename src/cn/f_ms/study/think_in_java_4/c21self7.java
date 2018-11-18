package cn.f_ms.study.think_in_java_4;

class c21self7 {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("default uncaught exception handler cached exception: " + e);
            }
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                throw new RuntimeException();
            }
        };

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("cached exception " + e);
            }
        });

        new Thread() {
            @Override
            public void run() {
                super.run();
                throw new RuntimeException();
            }
        }.start();

        thread.start();
    }

}
