package codility.greedy.maxnonoverlappingsegments;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if (A.length < 2) return A.length;

        int count = 0;

        int current = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > B[current]) {
                count++;
                current = i;
            }
        }

        return count + 1;
    }
}
