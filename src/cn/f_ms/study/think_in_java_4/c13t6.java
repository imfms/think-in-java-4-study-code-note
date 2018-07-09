package cn.f_ms.study.think_in_java_4;

class c13t6 {

    public static String knights = "Then, when you have found the shrubbery," +
            " you must cut down the mightiest tree in the forest... with... a herring!";

    public static void main(String[] args) {

        System.out.println(knights);
        System.out.println();

        for (String string : knights.split("(the)|(you)")) {
            System.out.println(string);
        }
    }

}
