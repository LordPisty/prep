package codility.caterpillar.countTriangles;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int count = 0;

        Arrays.sort(A);

        for (int j = A.length - 1; j > 1; j--) {
            int tail = 0;
            int head = j - 1;

            while (tail < head) {
                if (A[tail] + A[head] > A[j]) {
                    count+= (head - tail);
                    head--;
                } else {
                    tail++;
                }
            }
        }

        return count;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{-5, -3, -1, 0, 3, 6}));
    }
}
