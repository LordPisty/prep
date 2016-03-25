package codility.maxSlice.maxProfit;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int profit = 0;

        if (A.length > 0) {
            int currProfit = -A[0];

            for (int i = 1; i < A.length; i++) {
                if (currProfit + A[i] > profit) {
                    profit = currProfit + A[i];
                }
                if (currProfit < (-A[i])) {
                    currProfit = -A[i];
                }
            }
        }

        return profit;
    }
}
