package codility.binarySearch.nailingPlanks;

/**
 * Created by crespis on 3/14/2016.
 */
import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8

        int N = A.length;
        int M = C.length;

        int[][] sortedNails = new int[M][2];
        for (int i = 0; i < M; i++) {
            sortedNails[i][0] = C[i];
            sortedNails[i][1] = i;
        }
        Arrays.sort(sortedNails, (x, y) -> x[0] - y[0]);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = getMinIndex(A[i], B[i], sortedNails, result);
            if (result == -1)
                return -1;
        }
        return result + 1;

    }

    public int getMinIndex(int startPlank, int endPlank, int[][] nail, int preIndex) {
        int min = 0;
        int max = nail.length - 1;
        int minIndex = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nail[mid][0] < startPlank)
                min = mid + 1;
            else if (nail[mid][0] > endPlank)
                max = mid - 1;
            else {
                max = mid - 1;
                minIndex = mid;
            }
        }
        if (minIndex == -1)
            return -1;
        // original inverted index
        int minIndexOrigin = nail[minIndex][1];

        // check all nails contained in plank for minimum original index
        for (int i = minIndex; i < nail.length; i++) {
            if (nail[i][0] > endPlank)
                break;
            minIndexOrigin = Math.min(minIndexOrigin, nail[i][1]);
            // forget smaller if other planks require more nails
            if (minIndexOrigin <= preIndex)
                return preIndex;
        }
        return minIndexOrigin;
    }
}
