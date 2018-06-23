package cn.f_ms.study.think_in_java_4;

import java.util.Arrays;
import java.util.LinkedList;

class c11t13 {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        System.out.println(list);

        list.add(list.size() / 2, 0);
        System.out.println(list);

        list.add(list.size() / 2, 1);
        System.out.println(list);

        list.add(list.size() / 2, 2);
        System.out.println(list);

    }
}
