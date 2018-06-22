package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

class c11t12 {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4, 5);

        System.out.println("list1: " + list1);

        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 10, 9, 8, 7, 6);

        System.out.println("list2: " + list2);

        ListIterator<Integer> listIterator = list1.listIterator(list1.size());
        while (listIterator.hasPrevious()) {
            list2.add(listIterator.previous());
        }

        System.out.println("list2: " + list2);
    }

}
