package codility.frogRiverOne;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int retVal = -1;

        int[] B = new int[X];
        for (int j = 0; j < B.length; j++) {
            B[j] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (B[A[i]-1] == -1 || i < B[A[i]-1]) {
                B[A[i]-1] = i;
            }
        }

        int minSec = 0;
        for (int j = 0; j < B.length; j++) {
            if (B[j] == -1) {
                return retVal;
            } else {
                if (B[j] > minSec) {
                    minSec = B[j];
                }
            }
        }

        return minSec;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        solution.solution(1,new int[]{1});
    }
}
