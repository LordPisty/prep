package codility.fibonacci.ladder;

import java.math.BigInteger;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int[] retVal = new int[A.length];

        // 0 1 2 3 4 5
        // 0 1 1 2 3 5
        // x x x x
        // 1 2 3 5
        BigInteger[] fibs = new BigInteger[A.length + 2];
        fibs[0] = BigInteger.ZERO;
        fibs[1] = BigInteger.ONE;
        fibs[2] = BigInteger.ONE;
        for (int i = 3; i < A.length + 2; i++) {
            fibs[i] = fibs[i-2].add(fibs[i-1]);
        }

        for (int i=0; i<A.length; i++) {
            retVal[i] = fibs[A[i]+1].mod(BigInteger.valueOf(2).pow(B[i])).intValue();
        }

        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{4,4,5,5,1}, new int[]{3,2,4,3,1}));
    }
}
