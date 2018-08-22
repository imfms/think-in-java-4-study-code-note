package cn.f_ms.study.think_in_java_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

class c17t7 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        ));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"
        ));

        ListIterator<String> arrayListIterator = arrayList.listIterator();
        ListIterator<String> linkedListIterator = linkedList.listIterator();

        while (arrayListIterator.hasNext()
                && linkedListIterator.hasNext()) {

            arrayListIterator.next();
            arrayListIterator.add(
                    linkedListIterator.next()
            );
        }

        while (arrayListIterator.hasPrevious()
                && linkedListIterator.hasPrevious()) {

            arrayListIterator.previous();
            arrayListIterator.add(
                    linkedListIterator.previous()
            );
            if (arrayListIterator.hasPrevious()) {
                arrayListIterator.previous();
            }
        }

        System.out.println(arrayList);

    }

}
