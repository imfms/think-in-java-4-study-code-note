package cn.f_ms.study.think_in_java_4;

class c15t28 {

    class Generic1<T> {
        void set(T t) {}
    }

    class Generic2<T> {
        T get() {
            return null;
        }
    }

    <T> void call1(Generic1<? super T> obj, T t) {
        obj.set(t);
    }

    <T> T call2(Generic2<? extends T> obj) {
        return obj.get();
    }

}
