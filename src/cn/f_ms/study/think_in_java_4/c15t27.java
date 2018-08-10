package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class c15t27 {

    public static void main(String[] args) {

        // compile error
        // List<Number> list = new ArrayList<Integer>();

        List<? extends Number> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        // compile error
        // list.add(1);

        Number number = list.get(0);
        System.out.println(number);
    }

}
