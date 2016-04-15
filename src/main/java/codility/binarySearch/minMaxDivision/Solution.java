package codility.binarySearch.minMaxDivision;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        long N = (long)A.length;
        // maxLargeSum
        long max = N * M;
        // minLargeSum
        long min = 0;

        long retVal = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            int blocks = 0;
            long sum = 0;

            for (long ele : A) {
                sum += ele;
                // there is an element which is larger than the large sum,
                // not a valid mid
                if (ele > mid) {
                    // invalidate
                    blocks = K + 1;
                    break;
                }
                if (sum > mid) {
                    // sum spilled over ==> reset
                    blocks++;
                    sum = ele;
                }
            }

            // last block not counted yet
            blocks++;

            if (blocks <= K) {
                max = mid - 1;
                retVal = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int)retVal;
    }
}
