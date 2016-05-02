package codility.dynamicProgramming.numberSolitaire;

/**
 * Created by crespis on 3/14/2016.
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] sums = new int[N];
        sums[0] = A[0];
        for (int i = 1; i < N; i++) {
            sums[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i + j < N && sums[i] + A[i+j] > sums[i+j]) {
                    sums[i+j] = sums[i] + A[i+j];
                }
            }
        }
        return sums[N-1];
    }
}
