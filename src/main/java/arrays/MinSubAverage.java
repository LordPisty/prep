package arrays;

/**
 * Created by crespis on 2/17/2016.
 */
public class MinSubAverage {

    // Given an array A of n integers, design a
    // linear time algorithm to find a subarray
    // that has length at least 2 with minimum average.

    // check only lengths 2 or 3
    // https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/

    public static void minSubAverage(int[] input) {
        int start = 0;
        int length = 0;
        double currMin = Double.MAX_VALUE;
        int i = 0;
        for(; i < input.length - 2; i++) {
            if ((double)(input[i]+input[i+1])/2 < currMin) {
                start = i;
                length = 2;
                currMin = (double)(input[i]+input[i+1])/2;
            }

            if ((double)(input[i]+input[i+1]+input[i+2])/3 < currMin) {
                start = i;
                length = 3;
                currMin = (double)(input[i]+input[i+1]+input[i+2])/3;
            }
        }
        if ((double)(input[i]+input[i+1])/2 < currMin) {
            start = i;
            length = 2;
        }

        System.out.println("start " + start + " length " + length);
    }

    public static void main(String[] args) {
        minSubAverage(new int[]{1, 1, 1, 1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8, 8});
        minSubAverage(new int[]{8, 2, 4, 9, 5, 8, 0, 3, 8, 2});
    }
}
