package codility.sorting.triangle;

import java.util.Arrays;

/**
 * Created by crespis on 3/21/2016.
 */
public class Solution {

    /**
     * 0 ? P < Q < R < N
     * sorted ==> A[P] <= A[Q] <= A[R]
     *
     * A[P] + A[Q] > A[R] ==> !!! need to find this !!!
     * A[Q] + A[R] > A[P] ==> follows from A[Q] >= A[P]
     * A[R] + A[P] > A[Q] ==> follows from A[R] >= A[Q]
     *
     * now if A[i] + A[i+m] > A[i+n] where 1 < m < n
     * because sorted
     * A[i] <= A[i+m-1]
     * A[i+m+1] <= A[i+n]
     *
     * so A[i] + A[i+m] > A[i+n] ==> A[i+m-1] + A[i+m] > A[i+m+1]
     * ==> check only subsequent triplets
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            if (A[i-2] >= 0 && (long)A[i-2] + (long)A[i-1] > (long)A[i]) {
                return 1;
            }
        }
        return 0;
    }
}