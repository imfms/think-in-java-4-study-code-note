package cn.f_ms.study.think_in_java_4;

import java.util.Scanner;

class c13t20 {

    static class Bean {

        public int intValue;
        public long longValue;
        public float floatValue;
        public double doubleValue;
        public String stringValue;

        public Bean(String text) {
            Scanner scanner = new Scanner(text);
            if (scanner.hasNextInt()) {
                intValue = scanner.nextInt();
            }
            if (scanner.hasNextLong()) {
                longValue = scanner.nextLong();
            }
            if (scanner.hasNextFloat()) {
                floatValue = scanner.nextFloat();
            }
            if (scanner.hasNextDouble()) {
                doubleValue = scanner.nextDouble();
            }
            if (scanner.hasNext()) {
                stringValue = scanner.next();
            }
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "intValue=" + intValue +
                    ", longValue=" + longValue +
                    ", floatValue=" + floatValue +
                    ", doubleValue=" + doubleValue +
                    ", stringValue='" + stringValue + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Bean bean = new Bean("1\n2\n1.2\n1.23\n1.234");
        System.out.println(bean.toString());

    }
}
