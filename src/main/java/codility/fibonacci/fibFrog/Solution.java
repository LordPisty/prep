package codility.fibonacci.fibFrog;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) return 1;
        if (A.length == 1) return 1;

        int[] fibs = new int[26];
        fibs[0] = 1;
        fibs[1] = 2;

        for (int i = 2; i < fibs.length; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }

        int[] jumps = new int[A.length + 1];
        for (int j = 0; j < A.length + 1; j++) {
            // landing ok
            if (j == A.length || A[j] == 1) {
                for (int z = 0; z < fibs.length; z++) {
                    if (fibs[z] > j + 1) break;
                    if (fibs[z] == j + 1) {
                        jumps[j] = 1;
                    } else {
                        // j > fibs[z]
                        if (A[j-fibs[z]] == 1 && jumps[j - fibs[z]]!=0) {
                            if (jumps[j] == 0 || jumps[j-fibs[z]] + 1 < jumps[j]) {
                                jumps[j] = jumps[j-fibs[z]] + 1;
                            }
                        }
                    }
                }
            }
        }

        return jumps[A.length] == 0 ? -1 : jumps[A.length];
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }
}
