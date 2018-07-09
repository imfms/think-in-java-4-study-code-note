package cn.f_ms.study.think_in_java_4;

import java.util.regex.Pattern;

class c13t7 {

    private static final Pattern BEGIN_UPPER_END_DOT_REGEX = Pattern.compile("[A-Z].+\\.");

    public static void main(String[] args) {

        String[] strings = {
                "hello world",
                "Hello world",
                "Hello world.",
                "Are You OK?",
                "Are you OK."
        };

        for (String string : strings) {
            System.out.println(String.format(
                    "%s: %b",
                    string,
                    BEGIN_UPPER_END_DOT_REGEX.matcher(string).matches()
            ));
        }
    }
}
