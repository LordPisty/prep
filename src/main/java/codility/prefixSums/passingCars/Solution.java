package codility.prefixSums.passingCars;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int east = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (total > 1000000000) {
                return -1;
            }
            if (A[i] == 1) {
                total += east;
            } else {
                east++;
            }
        }
        if (total > 1000000000) {
            return -1;
        } else {
            return total;
        }
    }
}
