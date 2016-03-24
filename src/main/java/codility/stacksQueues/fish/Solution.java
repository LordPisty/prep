package codility.stacksQueues.fish;

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int retVal = 0;
        int[] stack = new int[A.length];
        int head = 0;

        // leading zeros
        int i = 0;
        for (; i < A.length; i++) {
            if (B[i] != 0) {
                break;
            } else {
                retVal++;
            }
        }

        for (; i < A.length;) {
            if (B[i] == 1) {
                stack[head++] = A[i++];
            } else {
                if (head > 0) {
                    if (stack[head-1] > A[i]) {
                        i++;
                    } else {
                        head--;
                    }
                } else {
                    retVal++;
                    i++;
                }
            }
        }

        retVal += head;
        return retVal;
    }

    public static void main(String... args ) {
        Solution s = new Solution();
        s.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0});
    }
}
