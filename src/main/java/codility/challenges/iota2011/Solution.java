package codility.challenges.iota2011;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int[][] sortedNums = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            sortedNums[i][0] = A[i];
            sortedNums[i][1] = i;
        }
        Arrays.sort(sortedNums, (x, y) -> x[0] - y[0]);

        int[] a = new int[]{0,0};
        Arrays.binarySearch(sortedNums, a, (x, y) -> x[0] - y[0]);


    }
}