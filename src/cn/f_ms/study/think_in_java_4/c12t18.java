package cn.f_ms.study.think_in_java_4;

class c12t18 {

    static class VeryImportantException extends Exception {
        public String toString() {
            return "A very important exception!";
        }
    }

    static class HoHumException extends Exception {
        public String toString() {
            return "A trivial exception";
        }
    }

    static class ThirdException extends Exception {
        public String toString() {
            return "A third exception";
        }
    }


    static class LostMessage {
        void f() throws VeryImportantException {
            throw new VeryImportantException();
        }
        void dispose() throws HoHumException {
            throw new HoHumException();
        }

        void third() throws ThirdException {
            throw new ThirdException();
        }
    }

    public static void main(String[] args) {
        try {

            LostMessage lm = new LostMessage();
            try {
                try {
                    lm.f();
                } finally {
                    lm.dispose();
                }
            } finally {
                lm.third();
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
