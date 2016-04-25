package codility.greedy.tieRopes;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        int count = 0;
        int current = 0;
        for (int i = 0; i < A.length; i++) {
            current += A[i];
            if (current >= K) {
                count++;
                current = 0;
            }
        }

        return count;
    }
}
