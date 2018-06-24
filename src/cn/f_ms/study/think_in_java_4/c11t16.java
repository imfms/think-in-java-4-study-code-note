package cn.f_ms.study.think_in_java_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class c11t16 {

    public static void main(String[] args) {

        Set<String> list = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        Collections.addAll(
                list,
                "think",
                "go",
                "hello",
                "world",
                "lai",
                "ba",
                "a",
                "b",
                "test",
                "think"
        );

        List<Character> compareList = Arrays.asList('a', 'e', 'i', 'o', 'u');

        int totalNum = 0;
        for (String word : list) {

            int num = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                if (compareList.contains(c)) {
                    num++;
                }
            }

            totalNum += num;

            System.out.println( word + ": " + num);
        }

        System.out.println("totalNum: " + totalNum);
    }

}
