package cn.f_ms.study.think_in_java_4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

class c15t22 {

    static class TestClass {

        public TestClass() {

        }

        public TestClass(String a) {

        }
    }

    public static void main(String[] args) {

        TestClass testClass = newInstance(TestClass.class);
        System.out.println(testClass);

        TestClass testClass2 = newInstance(TestClass.class, "a");
        System.out.println(testClass2);

    }

    public static <T> T newInstance(Class<T> tClass, Object... args) {

        T instance = null;

        for (Constructor<?> constructor : tClass.getConstructors()) {
            try {
                instance = (T) constructor.newInstance(args);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | IllegalArgumentException e) {
                continue;
            }
        }

        if (instance == null) {
            throw new IllegalArgumentException("can't find accept constructor");
        }

        return instance;
    }

}
