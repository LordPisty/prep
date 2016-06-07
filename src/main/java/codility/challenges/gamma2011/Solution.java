package codility.challenges.gamma2011;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(String S) {
        // write your code in Java SE 8
        int retVal = 0;
        char[] A = S.toCharArray();

        for (int i = 1; i< A.length -1; i++) {
            if (A[i - 1] == A[i + 1]) {
                retVal++;
                int j = 2;
                while (i - j >= 0 && i + j < A.length && A[i - j] == A[i + j]) {
                    retVal++;
                    if (retVal > 100000000) {
                        return -1;
                    }
                    j++;
                }
            }
        }
        for (int i = 1; i< A.length; i++) {
            if (A[i-1] == A[i]) {
                retVal++;
                int j = 2;
                while (i - j >= 0 && i + j - 1 < A.length && A[i - j] == A[i + j -1]) {
                    retVal++;
                    if (retVal > 100000000) {
                        return -1;
                    }
                    j++;
                }
            }
        }

        return retVal;
    }
}
