package codility.countingElements.maxCounters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];

        int max = 0;
        int lastMax = 0;

        for (int i = 0; i < A.length; i ++) {
            if (A[i] == N+1) {
                lastMax = max;
            } else {
                if (counters[A[i] - 1] < lastMax) {
                    counters[A[i] - 1] = lastMax;
                }
                counters[A[i] - 1]++;
                if (counters[A[i] - 1] > max) {
                    max = counters[A[i] - 1];
                }
            }
        }

        for (int j = 0; j < counters.length; j++) {
            if (counters[j] < lastMax) {
                counters[j] = lastMax;
            }
        }

        return counters;
    }
}
