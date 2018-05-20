package cn.f_ms.study.think_in_java_4;

import java.util.Arrays;

class c4t10 {

    public static void main(String[] args) {
        doIt();
    }

    public static void doIt() {

        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 0; d < 10; d++) {

                        int[] sourceNums = {
                                a, b, c, d
                        };

                        int[] nullFlagNums = Arrays.copyOf(sourceNums, sourceNums.length);

                        int product = (a * 10 + b) * (c * 10 + d);
                        int[] targetNums = {
                                product / 1000,
                                product % 1000 / 100,
                                product % 1000 % 100 / 10,
                                product % 1000 % 100 % 10
                        };

                        if (targetNums[2] == 0 && targetNums[3] == 0) {
                            continue;
                        }

                        final int INT_NULL_VALUE = -1;

                        for (int targetNum : targetNums) {
                            for (int sourceNumIndex = 0; sourceNumIndex < sourceNums.length; sourceNumIndex++) {

                                int sourceNum = sourceNums[sourceNumIndex];
                                if (sourceNum == targetNum) {
                                    nullFlagNums[sourceNumIndex] = INT_NULL_VALUE;
                                    break;
                                }
                            }
                        }

                        boolean isAllNull = true;
                        for (int nullFlagNum : nullFlagNums) {
                            if (nullFlagNum != INT_NULL_VALUE) {
                                isAllNull = false;
                                break;
                            }
                        }

                        if (isAllNull) {
                            System.out.println(String.format(
                                    "%d = %d%d * %d%d",
                                    product, a, b, c, d
                            ));
                        }

                    }
                }
            }
        }
    }

}
