package codility.permMissingElem;

import java.math.BigInteger;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        BigInteger sum = BigInteger.valueOf(0);
        int N = A.length;

        for (int i = 0; i < A.length; i++) {
            sum = sum.add(BigInteger.valueOf(A[i]));
        }
        return (((BigInteger.valueOf(N+1).multiply(BigInteger.valueOf(N+2))).divide(BigInteger.valueOf(2))).subtract(sum)).intValue();
    }
}
