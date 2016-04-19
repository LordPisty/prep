package codility.caterpillar.absDistinct;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int start = 0;
        int end = N - 1;
        int count = 0;
        while (start <= end) {
            int left = A[start];
            // if the element of array equals A[start], do not count
            while (start <= end && A[start] == left)
                start++;
            // count the element of A[start]
            count++;

            // avoid wrap because of abs
            if (left == Integer.MIN_VALUE)
                continue;

            int previous = -1;
            // count the number of element right end that bigger than A[start]
            while (start <= end && Math.abs(A[end]) > Math.abs(left)) {
                if (Math.abs(A[end]) != previous) {
                    count++;
                    previous = Math.abs(A[end]);
                }
                // if the element of array equals A[end], do not count
                end--;
            }
            // if the element of array equals A[start], do not count
            while (start <= end && Math.abs(A[end]) == Math.abs(left))
                end--;
        }
        return count;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{-5, -3, -1, 0, 3, 6}));
    }
}
