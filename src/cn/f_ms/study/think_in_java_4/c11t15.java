package cn.f_ms.study.think_in_java_4;

import java.util.Stack;

class c11t15 {

    public static void main(String[] args) {

        String str = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";

        Stack<Character> charStack = new Stack<>();

        boolean isAdd = false;
        for (char c : str.toCharArray()) {

            if (c == '+') {
                isAdd = true;
                continue;
            }

            if (isAdd) {
                charStack.push(c);
                isAdd = false;
                continue;
            }

            if (c == '-') {
                System.out.print(charStack.pop());
                isAdd = false;
                continue;
            }
        }

    }

}
