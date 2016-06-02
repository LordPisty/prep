package codility.challenges.alpha2010;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] values = new int[10000001];
        int distinct = 0;

        for (int i = 0; i < A.length; i++) {
            if (values[A[i]] == 0) {
                values[A[i]] = 1;
                distinct++;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (values[A[i]] == 1) {
                values[A[i]] = 0;
                distinct--;
                if (distinct == 0) {
                    return i;
                }
            }
        }
        return A.length - 1;
    }
}
