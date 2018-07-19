package cn.f_ms.study.think_in_java_4;

import java.text.SimpleDateFormat;

class c14t8 {


    public static void main(String[] args) {

        Object[] objects = {
                1,
                new Integer(1),
                new String(),
                new SimpleDateFormat(),
                new char[0]
        };

        for (Object object : objects) {
            printInheritanceStructure(object);
        }
    }

    public static void printInheritanceStructure(Object obj) {

        System.out.println("--------");

        Class clazz = obj.getClass();

        do {

            System.out.println(clazz.getCanonicalName());

        } while ((clazz = clazz.getSuperclass()) != null);


    }

}
