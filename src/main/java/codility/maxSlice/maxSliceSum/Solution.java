package codility.maxSlice.maxSliceSum;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int maxSum = Integer.MIN_VALUE;

        if (A.length > 0) {
            int currSum = A[0];
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            for (int i = 1; i < A.length; i++) {
                currSum = Math.max(currSum + A[i], A[i]);
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(new int[]{-2, 1});
    }
}
