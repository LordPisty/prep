package codility.leader.dominator;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int top = -1;
        int stack = 0;

        for (int i = 0; i < n; i++) {
            if (stack == 0) {
                stack += 1;
                top = A[i];
            } else {
                if (A[i] != top) {
                    stack -= 1;
                } else {
                    stack += 1;
                }
            }
        }

        int candidate = stack > 0 ? top : -1;
        int retVal = -1;
        int count = 0;
        for (int i= 0; i<n;i++) {
            if (A[i] == candidate) {
                retVal = i;
                count++;
            }
        }
        return count > n/2 ? retVal : -1;
    }
}
