package codility.caterpillar.minAbsSumOfTwo;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        Arrays.sort(A);
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                index = i;
                break;
            }
            if (i == N - 1)
                index = i;
        }
        int head = index;
        int tail = index;
        int sum = Math.abs(A[tail] + A[head]);
        while (true) {
            // stores the current absolute sum of tail and head
            int currentAbsSum = Math.abs(A[tail] + A[head]);
            if (currentAbsSum < sum)
                sum = currentAbsSum;
            // left is better?
            if (tail - 1 >= 0 && Math.abs(A[tail - 1] + A[head]) <= currentAbsSum) {
                tail--;
            // right is better?
            } else if (head + 1 < N && Math.abs(A[tail] + A[head + 1]) <= currentAbsSum) {
                head++;
            // no better single side, change both
            } else if (tail - 1 >= 0 && head + 1 < N) {
                tail--;
                head++;
            // head is at the right end
            } else if (tail - 1 >= 0) {
                tail--;
            // tail is at the left end
            } else if (head + 1 < N) {
                head++;
            } else
                // no more moves
                return sum;
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{-5, -3, -1, 0, 3, 6}));
    }
}
