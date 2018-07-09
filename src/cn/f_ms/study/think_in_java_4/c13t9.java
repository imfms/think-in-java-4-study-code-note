package cn.f_ms.study.think_in_java_4;

import java.util.regex.Pattern;

class c13t9 {

    public static String knights = "Then, when you have found the shrubbery," +
            " you must cut down the mightiest tree in the forest... with... a herring!";

    public static void main(String[] args) {

        System.out.println(knights);
        System.out.println();

        Pattern regex = Pattern.compile("[aeiouAEIOU]");

        String result = regex.matcher(knights).replaceAll("_");
        System.out.println(result);

    }

}
