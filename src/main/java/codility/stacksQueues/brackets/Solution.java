package codility.stacksQueues.brackets;

import java.util.Arrays;

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        char[] stack = new char[S.length()];
        int head = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case '(':
                    stack[head++] = '(';
                    break;
                case '[':
                    stack[head++] = '[';
                    break;
                case '{':
                    stack[head++] = '{';
                    break;
                case ')':
                    if (head == 0 || stack[head - 1]!='(') {
                        return 0;
                    } else {
                        head--;
                    }
                    break;
                case ']':
                    if (head == 0 || stack[head - 1]!='[') {
                        return 0;
                    } else {
                        head--;
                    }
                    break;
                case '}':
                    if (head == 0 || stack[head - 1]!='{') {
                        return 0;
                    } else {
                        head--;
                    }
                    break;
            }
        }

        return head == 0 ? 1 : 0;
    }
}
