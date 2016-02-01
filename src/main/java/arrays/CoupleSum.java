package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by crespis on 2/1/2016.
 */
public class CoupleSum {

    // brute force - prints duplicates pairs
    // Memory: O(1)
    // Time: O(n^2)
    public static void coupleSum(int[] input, int sum) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i+1; j < input.length; j++) {
                if (input[i] + input[j] == sum) {
                    System.out.printf("(%d, %d) %n", input[i], input[j]);
                }
            }
        }
    }

    // reduced no of duplicates pairs
    // Memory: O(n)
    // Time: O(n)
    public static void coupleSum2(int[] input, int sum) {
        Set<Integer> numbers = new HashSet<>(input.length);
        for (int i : input) {
            if (!numbers.contains(sum - i)) {
                numbers.add(i);
            } else {
                System.out.printf("(%d, %d) %n", i, sum - i);
            }
        }
    }

    // duplicates pairs
    // Memory: O(1)
    // Time: O(nlogn)
    public static void coupleSum3(int[] input, int sum) {
        Arrays.sort(input);
        int i = 0;
        int j = input.length - 1;
        while (i < j) {
            if (input[i] + input[j] == sum) {
                System.out.printf("(%d, %d) %n", input[i], input[j]);
                i++;
                j--;
            } else if (input[i] + input[j] > sum) {
                j--;
            } else if (input[i] + input[j] < sum) {
                i++;
            }
        }
    }
}
