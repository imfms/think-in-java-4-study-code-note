package cn.f_ms.study.think_in_java_4;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;

class c13_7_2 {

    static String threatData =
            "58.27.82.161@02/10/2005\n" +
                    "204.45.234.40@02/11/2005\n" +
                    "58.27.82.161@02/11/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(threatData);
        String pattern = "((\\d+[.]){3}\\d+)@((\\d+/){2}\\d+)";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            System.out.println(
                    String.format("ip: %s, date: %s", match.group(1), match.group(3))
            );
        }
    }


}
