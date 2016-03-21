package codility.sorting.maxProductOfThree;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        if (A[A.length -1] <= 0) {
            return A[A.length -1] * A[A.length -2] * A[A.length -3];
        } else {
            int a = A[0] * A[1] * A[A.length - 1];
            int b = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }
}
