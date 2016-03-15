package codility.cyclicRotation;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private int getIdx(int idx, int L) {
        int rem = idx % L;
        if (rem < 0) {
            return rem + L;
        } else {
            return rem;
        }
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int L = A.length;
        int[] B = new int[L];

        for (int i = 0; i < L; i++) {
            B[i] = A[getIdx(i - K, L)];
        }

        return B;
    }
}
