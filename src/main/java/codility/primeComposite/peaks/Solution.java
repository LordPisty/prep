package codility.primeComposite.peaks;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int retVal = 0;

        if (A.length > 2) {
            int[] peaks = new int[A.length];
            int count = 0;
            for (int i = 1; i < A.length -1; i++) {
                if (A[i] > A[i-1] && A[i] > A[i+1]) {
                    peaks[count++] = i;
                }
            }

            for (int j = count; j > 0; j--) {
                if (A.length % j == 0) {
                    int length = A.length / j;
                    boolean feasible = true;
                    int prev = 0;
                    for (int i = length; i <= A.length; i+= length) {
                        int point = Arrays.binarySearch(peaks,0, count,i);
                        if (point < 0) {
                            point = - (point + 1);
                        }
                        if (point > prev) {
                            prev = point;
                        } else {
                            feasible = false;
                        }
                    }
                    if (feasible) {
                        retVal = j;
                        break;
                    }
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
