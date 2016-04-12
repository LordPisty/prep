package codility.euclideanAlgorithm.chocolateByNumbers;

import java.math.BigInteger;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int N, int M) {
        // write your code in Java SE 8
        BigInteger r = BigInteger.valueOf(N).mod(BigInteger.valueOf(M));
        if (r.equals(BigInteger.ZERO)) {
            return N/M;
        } else {
            // mcm r & M
            BigInteger i = r.multiply(BigInteger.valueOf(M)).divide(BigInteger.valueOf(M).gcd(r)).divide(r);
            return i.multiply(BigInteger.valueOf(N)).divide(BigInteger.valueOf(M)).intValue();
        }
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(947853, 4453));
    }
}
