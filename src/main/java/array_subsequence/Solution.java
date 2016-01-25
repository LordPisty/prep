package array_subsequence;

import java.util.Arrays;

/**
 * Given an array, find the longest quasiconstant subsequence.
 * quasiconstant = difference between elements is at most 1
 * requirements:
 * - time O(n logn)
 */
class Solution {
    public static  int solution(int[] input)
    {
        int maxLen = 0;
        Arrays.sort(input);

        int previous = input[0];
        int previousCount = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == previous) {
                previousCount++;
            } else {
                int current = input[i];
                int currentCount = 1;
                for (int j = i+1; j < input.length && input[j] == input[i]; j++) {
                    currentCount++;
                }
                if ((current - previous) <= 1 && (previousCount + currentCount) > maxLen) {
                    maxLen = previousCount + currentCount;
                }
                i+= (currentCount - 1);
                previous = current;
                previousCount = currentCount;
            }
        }

        return maxLen;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[]{6,10,6,9,7,8}));
        System.out.println(solution(new int[]{6,10,9,7,8}));
        System.out.println(solution(new int[]{2,1,1,6,2,9,2,7,2,8,1,1,2}));
        System.out.println(solution(new int[]{2,1,1,2,3,4,3,4,3,4}));
    }
}

