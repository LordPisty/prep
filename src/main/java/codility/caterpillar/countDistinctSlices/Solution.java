package codility.caterpillar.countDistinctSlices;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int M, int[] A) {
        // write your code in Java SE 8
        int[] counts = new int[M+1];
        int count = 0;

        int front = 0;
        int end = 0;

        while (front < A.length) {
            while (end < A.length && counts[A[end]] != 1) {
                counts[A[end]]++;
                end++;
            }

            count += end - front;
            if (count > 1000000000) return 1000000000;
            counts[A[front]]--;
            front++;
        }
        return count;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(7, new int[]{3, 4, 5, 5, 2}));
    }
}
