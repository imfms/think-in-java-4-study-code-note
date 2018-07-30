package cn.f_ms.study.think_in_java_4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * $
 *
 * @author f_ms
 * @date 18-7-30
 */
class c14t21 {
}

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(
                getInterfaceProxy(new RealObject())
        );
        consumer(
                getInterfaceProxy(new SimpleProxy(new RealObject()))
        );
    }

    private static Interface getInterfaceProxy(Interface realObject) {
        return (Interface) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class<?>[]{Interface.class},
                new InvocationHandler() {

                    private Map<Method, Integer> counts = new HashMap<>();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        method.invoke(realObject, args);

                        Integer count = counts.get(method);
                        count = count == null
                                ? 1 :
                                ++count;

                        counts.put(method, count);

                        System.out.println("method: " + method.getName() + ", call num: " + count);

                        return null;
                    }
                }
        );
    }

}