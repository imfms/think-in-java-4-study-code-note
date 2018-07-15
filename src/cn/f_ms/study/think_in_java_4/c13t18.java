package cn.f_ms.study.think_in_java_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class c13t18 {

    public static final String JAVA_STRING = c13t17.JAVA_STRING;

    public static void main(String[] args) {
        doIt(JAVA_STRING);
    }

    public static void doIt(String javaString) {

        Matcher matcher = Pattern.compile("\".+\"").matcher(javaString);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
