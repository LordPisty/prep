package codility.fibonacci.fibFrog;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private int solution(int[] A, int start, int[] fibs, int i) {
        if (start >= A.length) return 0;
        int minJumps = Integer.MAX_VALUE;
        for (int j = A.length; j >= 0; j--) {
            if ((j == A.length || A[j] == 1) && Arrays.binarySearch(fibs, 0, i, j - start) > 0) {
                int candidate = solution(A, j, fibs, i);
                if (candidate != -1 && candidate + 1 < minJumps) {
                    minJumps = candidate + 1;
                }
            }
        }
        return minJumps == Integer.MAX_VALUE ? -1 : minJumps;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) return 1;
        if (A.length == 1) return 1;

        int[] fibs = new int[A.length];
        fibs[0] = 0;
        fibs[1] = 1;

        int i = 2;
        for (; i < A.length && fibs[i-1] < A.length +1; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }

        return solution(A, -1, fibs, i);
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{}));
    }
}
