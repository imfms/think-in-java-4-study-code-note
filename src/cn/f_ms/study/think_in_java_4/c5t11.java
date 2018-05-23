package cn.f_ms.study.think_in_java_4;

class c5t11 {

    static class Test {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();

            System.out.println("Test's finalize()");
        }
    }

    public static void main(String[] args) {

        new Test();

        System.gc();

    }

}
