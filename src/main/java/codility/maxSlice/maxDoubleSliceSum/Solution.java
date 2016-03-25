package codility.maxSlice.maxDoubleSliceSum;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int retVal = 0;

        if (A.length > 3) {
            int[] lMax = new int[A.length];
            lMax[0] = 0;
            int lCurr = 0;

            int[] rMax = new int[A.length];
            rMax[A.length - 1] = 0;
            int rCurr = 0;

            for (int i = 1; i < A.length; i++) {
                lCurr = Math.max(0, lCurr + A[i]);
                lMax[i] = lCurr;

                rCurr = Math.max(0, rCurr + A[A.length-1 - i]);
                rMax[A.length-1 - i] = rCurr;
            }

            for (int i = 1; i < A.length -1; i++) {
                if (lMax[i-1] + rMax[i+1] > retVal) {
                    retVal = lMax[i-1] + rMax[i+1];
                }
            }
        }

        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(new int[]{5, 17, 0, 3});
    }
}
