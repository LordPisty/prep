package arrays;

/**
 * Created by crespis on 2/16/2016.
 */
public class MaxSumDistance {

    // Given an array A of n integers, design a
    // linear time algorithm to find i and j such
    // that A[i] + A[j] + (i – j) is maximized
    // subject to i > j.

    // this might miss some solutions in case of weird
    // relative positions
    public static void maxSumDistance(int[] input) {
        int partialJ = -1;
        int maxPartialJ = Integer.MIN_VALUE;
        for (int j = 0; j < input.length; j++) {
            if (input[j] - j > maxPartialJ) {
                maxPartialJ = input[j] - j;
                partialJ = j;
            }
        }
        int partialI = -1;
        int maxPartialI = Integer.MIN_VALUE;
        for (int i = input.length -1; i >= 0 && i > partialJ; i--) {
            if (input[i] + i > maxPartialI) {
                maxPartialI = input[i] + i;
                partialI = i;
            }
        }
        System.out.println(partialJ + " " + partialI);
    }

    public static void maxSumDistance2(int[] input) {
        int j = 0;
        int maxI = 1;
        int result = 0;

        for(int i = 1; i < input.length; i++){
            int total = input[i] + i + input[j] - j;
            if (total > result) {
                result = total;
                maxI = i;
            }
            if(input[i] - i > input[j] - j){
                j = i;
            }
        }
        System.out.println(j + " " + maxI);
    }

    public static void main(String[] args) {
        maxSumDistance(new int[]{1, 1, 1, 1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8, 8});
        maxSumDistance(new int[]{8, 2, 4, 9, 5, 8, 0, 3, 8, 2});

        maxSumDistance2(new int[]{1, 1, 1, 1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8, 8});
        maxSumDistance2(new int[]{8, 2, 4, 9, 5, 8, 0, 3, 8, 2});
    }
}
