package codility.timeComplexity.tapeEquilibrium;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        int retVal = Integer.MAX_VALUE;

        left[0] = A[0];
        right[A.length - 1] = A[A.length -1];

        for (int i = 1; i < A.length - 1; i++) {
            left[i] = A[i] + left[i - 1];
            right[A.length - 1 - i] = A[A.length - 1 - i] + right[A.length - i];
        }

        for (int i = 0; i < A.length - 1; i++) {
            int diff = Math.abs(left[i] - right[i+1]);
            if (diff < retVal) {
                retVal = diff;
            }
        }

        return retVal;
    }


    public static void main(String... args) {
        Solution solution = new Solution();
        solution.solution(new int[]{3,1,2,4,3});
    }
}
