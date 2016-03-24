package codility.sorting.numberOfDiscIntersections;

import java.util.Arrays;

/**
 * Created by crespis on 3/21/2016.
 */
public class Solution2 {

    /**
     * intersect iff j >= i ==> j - i <= A[J] + A[i]
     * A[i] + i >= j - A[j]
     *
     * 2 arrays, sort them
     * binary search for comparisons
     *
     * all cases where j <= i are trivial
     * remove n*(n+1)/2
     * [x1, x2, x3, x4, x5, x6]: remove {(x1, x1), (x1, x2), (x1, x3), (x1, x4), (x1, x5), (x1, x6), (x2, x2), (x2, x3), ...}
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] starts = new int[A.length];
        int[] ends = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            long idxS = i - (long)A[i];
            if (idxS < 0) {
                starts[0]++;
            } else {
                starts[(int)idxS]++;
            }

            long idxE = i + (long)A[i];
            if (idxE > A.length - 1) {
                ends[A.length - 1]++;
            } else {
                ends[(int)idxE]++;
            }
        }

        int overlap = 0;
        int active = 0;

        for (int j = 0; j < A.length; j++) {
            overlap += active * starts[j];
            overlap += starts[j] * (starts[j] - 1) / 2;
            if (overlap > 10000000) {
                return -1;
            }
            active += starts[j];
            active -= ends[j];
        }

        return overlap;
    }

    public static void main(String... args) {
        Solution2 s = new Solution2();
        s.solution(new int[]{1,5,2,1,4,0});
    }
}
