package cn.f_ms.study.think_in_java_4;

class c5t12 {

    static class Tank {

        boolean isEmpty;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();

            if (!isEmpty) {
                System.out.println("Tank's isEmpty field must be true when you don't need");
            }
        }
    }

    public static void main(String[] args) {
        new Tank().isEmpty = true;
        new Tank();

        System.gc();

    }

}
