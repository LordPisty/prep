package codility.sieveErathostenes.countSemiprimes;

/**
 * Created by crespis on 4/11/2016.
 */
class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] primes = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        for (int i = 2; i * i < N+1; i++) {
            if (primes[i] == 0) {
                int k = i + i;
                for (; k < N+1; k+=i) {
                    if (primes[k] == 0) {
                        primes[k] = i;
                    }
                }
            }
        }
        for (int i = 4; i < N+1; i++) {
            if (primes[i] != 0 && i % primes[i] == 0 && primes[i/primes[i]] == 0) {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }


        int[] retVal = new int[P.length];
        for (int j = 0; j < P.length; j++) {
            retVal[j] = prefixSum[Q[j]] - prefixSum[P[j] - 1];
        }
        return retVal;
    }
}