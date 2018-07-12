package cn.f_ms.study.think_in_java_4;

import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class c13t12 {

    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {

         Matcher matcher = Pattern.compile("[A-Z]\\w*").matcher(POEM);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        while (matcher.find()) {
            linkedHashSet.add(matcher.group());
        }

        System.out.println(linkedHashSet);

    }

}
