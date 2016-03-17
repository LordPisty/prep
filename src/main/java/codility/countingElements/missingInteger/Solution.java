package codility.countingElements.missingInteger;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (!count.containsKey(A[i])) {
                count.put(A[i],0);
            }
            count.put(A[i],count.get(A[i])+1);
        }

        int retVal = 1;
        while (true) {
            if (count.get(retVal) == null) {
                return retVal;
            }
            retVal++;
        }
    }
}
