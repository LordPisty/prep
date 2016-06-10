package codility.challenges.kappa2011;

import java.util.*;
import java.math.BigInteger;

class Solution {
    private static final Map<Integer, BigInteger> cache = new HashMap<>();
    private static final BigInteger MAX = new BigInteger("1410000016");

    private BigInteger fac(int i) {
        if (!cache.containsKey(i)) {
            BigInteger value = fac(i-1).multiply(BigInteger.valueOf(i));
            cache.put(i, value);
        }
        return cache.get(i);
    }

    public int solution(int[] T, int[] D) {
        // write your code in Java SE 8
        BigInteger tot = BigInteger.ONE;
        cache.put(1, BigInteger.ONE);

        for (int i = 0; i < T.length; i++) {
            if (T[i]!= 0 && D[i]!= 0) {

                tot = tot.multiply((fac(T[i]).divide(fac(D[i]))).divide(fac(T[i]-D[i])));
                if (MAX.compareTo(tot) < 0) {
                    tot = tot.mod(MAX.add(BigInteger.ONE));
                }
            }
        }

        return tot.intValue();
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(new int[]{6,4,7}, new int[]{1,3,4});
    }
}