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

    // prefix sum
    // input = [ 1,2,3,4,5,6,7,8,9,10 ]
    // prefix = [ 0,1,3,6,10,15,21,28,36,45,55 ]
    // average of the slice from index i to j: (prefix[j+1]-prefix[i]) / (j-i)+1
    public static void minSubAverage2(int[] input) {
        int start = 0;
        int length = 0;
        double currMin = Double.MAX_VALUE;
        int i = 0;

        int[] prefixSum = new int[input.length + 1];
        prefixSum[0] = 0;
        for(int j = 1; j <= input.length; j++) {
            prefixSum[j] = prefixSum[j - 1] + input[j - 1];
        }

        for(; i < input.length - 2; i++) {
            if (((double)(prefixSum[i+2]-prefixSum[i]))/2 < currMin) {
                start = i;
                length = 2;
                currMin = ((double)(prefixSum[i+2]-prefixSum[i]))/2;
            }

            if (((double)(prefixSum[i+3]-prefixSum[i]))/3 < currMin) {
                start = i;
                length = 3;
                currMin = ((double)(prefixSum[i+3]-prefixSum[i]))/3;
            }
        }
        if (((double)(prefixSum[i+2]-prefixSum[i]))/2 < currMin) {
            start = i;
            length = 2;
        }

        System.out.println("start " + start + " length " + length);
    }

    public static void main(String[] args) {
        minSubAverage(new int[]{1, 1, 1, 1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8, 8});
        minSubAverage(new int[]{8, 2, 4, 9, 5, 8, 0, 3, 8, 2});

        minSubAverage2(new int[]{1, 1, 1, 1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8, 8});
        minSubAverage2(new int[]{8, 2, 4, 9, 5, 8, 0, 3, 8, 2});
    }
}
