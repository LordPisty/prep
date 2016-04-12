package codility.euclideanAlgorithm.commonPrimeDivisors;

import java.math.BigInteger;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    private boolean samePrimeDivisors(int a, int b) {
        BigInteger bA = BigInteger.valueOf(a);
        BigInteger bB = BigInteger.valueOf(b);

        BigInteger gcd = bA.gcd(bB);

        while (!bA.equals(BigInteger.ONE)) {
            BigInteger gcd1 = bA.gcd(gcd);
            if (gcd1.equals(BigInteger.ONE)) break;
            bA = bA.divide(gcd1);
        }
        if (!bA.equals(BigInteger.ONE)) return false;
        while (!bB.equals(BigInteger.ONE)) {
            BigInteger gcd2 = bB.gcd(gcd);
            if (gcd2.equals(BigInteger.ONE)) break;
            bB = bB.divide(gcd2);
        }
        return bB.equals(BigInteger.ONE);
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int count = 0;
        for (int j = 0; j < A.length; j++) {
            if (samePrimeDivisors(A[j], B[j])) count++;
        }
        return count;
    }
}
