package codility.primeComposite.flags;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int retVal = 0;

        if (A.length > 2) {
            int[] nextPeak = new int[A.length];
            nextPeak[A.length - 1] = -1;
            int count = 0;
            for (int i = A.length - 2; i >0; i--) {
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    nextPeak[i] = i;
                    count++;
                } else {
                    nextPeak[i] = nextPeak[i+1];
                }
            }
            nextPeak[0] = nextPeak[1];

            for (int j = 1; (j-1)*j + 2 < A.length && j <= count; j++) {
                int pos = 0;
                int num = 0;
                while (pos < A.length && num < j) {
                    pos = nextPeak[pos];
                    if (pos == -1) {
                        break;
                    }
                    num++;
                    pos += j;
                }
                if (num > retVal) {
                    retVal = num;
                }
            }
        }

        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
    }
}
