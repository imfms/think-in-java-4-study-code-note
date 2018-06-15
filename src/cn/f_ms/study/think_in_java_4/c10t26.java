package cn.f_ms.study.think_in_java_4;

class c10t26 {


    class Test {

        class Inner {
            Inner(String arg) {
                System.out.println("success:" + arg);
            }
        }

    }

    class ExtendInner extends Test.Inner {

        public ExtendInner(Test testInstance, String innerArg) {
            testInstance.super(innerArg);
        }
    }

    public static void main(String[] args) {

        new c10t26().doIt();

    }

    private void doIt() {
        new ExtendInner(new Test(), "good");
    }

}
