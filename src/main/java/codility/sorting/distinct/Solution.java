package codility.sorting.distinct;

import java.util.Arrays;

/**
 * Created by crespis on 3/21/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i-1]) {
                count++;
            }
        }
        if (A.length > 0) {
            count++;
        }

        return count;
    }
}