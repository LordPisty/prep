package codility.prefixSums.minAvgTwoSlice;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private static final float epsilon = 0.0000001f;

    private boolean equalFloat(float a, float b) {
        return Math.abs(a - b) < epsilon;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int retVal = 0;
        float currMin = Float.MAX_VALUE;

        int[] pS = new int[A.length + 1];
        for (int i = 0; i < A.length; i ++) {
            pS[i+1] = pS[i] + A[i];
        }

        if (((float)(pS[A.length]-pS[A.length - 2]))/2 < currMin) {
            retVal = A.length - 2;
            currMin = ((float)(pS[A.length]-pS[A.length - 2]))/2;
        }
        for (int j = A.length - 3; j >= 0; j--) {
            if (((float)(pS[j+2]-pS[j]))/2 < currMin || equalFloat(((float)(pS[j+2]-pS[j]))/2, currMin)) {
                retVal = j;
                currMin = ((float)(pS[j+2]-pS[j]))/2;
            }

            if (((float)(pS[j+3]-pS[j]))/3 < currMin || equalFloat(((float)(pS[j+3]-pS[j]))/3, currMin)) {
                retVal = j;
                currMin = ((float)(pS[j+3]-pS[j]))/3;
            }
        }

        return retVal;
    }
}
