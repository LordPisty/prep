package codility.oddOccurrences;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int retVal = A[0];

        for (int i = 1; i < A.length; i++) {
            retVal ^= A[i];
        }

        return retVal;
    }
}
