package codility.challenges.kappa2011;

import java.util.*;
import java.math.BigInteger;

class Solution {
    private static final Map<Integer, BigInteger> cache = new HashMap<>();
    private static final BigInteger MAX = new BigInteger("1410000016");
    private static final BigInteger MOD = new BigInteger("1410000017");

    private BigInteger fac(int i) {
        if (!cache.containsKey(i)) {
            BigInteger rec = fac(i-1);
            if (MAX.compareTo(rec) < 0) {
                rec = rec.mod(MOD);
            }
            BigInteger value = rec.multiply(BigInteger.valueOf(i));
            if (MAX.compareTo(value) < 0) {
                value = value.mod(MOD);
            }
            cache.put(i, value);
        }
        return cache.get(i);
    }

    public int solution(int[] T, int[] D) {
        // write your code in Java SE 8
        BigInteger tot = BigInteger.ONE;
        cache.put(0, BigInteger.ONE);
        cache.put(1, BigInteger.ONE);

        for (int i = 0; i < T.length; i++) {
            if (T[i]!= 0 && D[i]!= 0) {

                BigInteger denom = fac(D[i]).multiply(fac(T[i]-D[i]));
                if (MAX.compareTo(denom) < 0) {
                    denom = denom.mod(MOD);
                }
                BigInteger binom = fac(T[i]).multiply(denom.modInverse(MOD));
                if (MAX.compareTo(binom) < 0) {
                    binom = binom.mod(MOD);
                }
                tot = tot.multiply(binom);
                if (MAX.compareTo(tot) < 0) {
                    tot = tot.mod(MAX.add(BigInteger.ONE));
                }
            }
        }

        return tot.intValue();
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{6,4,7}, new int[]{1,3,4}));
    }
}