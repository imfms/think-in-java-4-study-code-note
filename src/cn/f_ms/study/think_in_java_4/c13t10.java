package cn.f_ms.study.think_in_java_4;

import java.util.Formatter;
import java.util.regex.Pattern;

class c13t10 {

    public static void main(String[] args) {

        String string = "Java now has regular expressions";
        System.out.println(string);
        System.out.println();

        String[] regexArr = {
                "^Java",
                "\\Breg.*",
                "n.w\\s+h(a|i)s",
                "s?",
                "s*",
                "s+",
                "s{4}",
                "s{1}",
                "s{0,3}"
        };

        for (String regex : regexArr) {
            System.out.format("%15s: %b\n", regex, string.matches(regex));
        }
    }

}
