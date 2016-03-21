package codility.sorting.numberOfDiscIntersections;

import java.util.Arrays;

/**
 * Created by crespis on 3/21/2016.
 */
public class Solution {

    /**
     * intersect iff j >= i ==> j - i <= A[J] + A[i]
     * A[i] + i >= j - A[j]
     *
     * 2 arrays, sort them
     * binary search for comparisons
     *
     * all cases where j <= i are trivial
     * remove n*(n+1)/2
     * [x1, x2, x3, x4, x5, x6]: remove {(x1, x1), (x1, x2), (x1, x3), (x1, x4), (x1, x5), (x1, x6), (x2, x2), (x2, x3), ...}
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        int l = A.length;

        long[] A1 = new long[l];
        long[] A2 = new long[l];

        for(int i = 0; i < l; i++){
            A1[i] = (long)A[i] + i;
            A2[i] = -((long)A[i]-i);
        }

        Arrays.sort(A1);
        Arrays.sort(A2);

        long count = 0;

        for(int i = l - 1; i >= 0; i--){
            int pos = Arrays.binarySearch(A2, A1[i]);
            if(pos >= 0){
                while(pos < l && A2[pos] == A1[i]){
                    pos++;
                }
                count += pos;
            } else{ // element not there
                int insertionPoint = -(pos+1);
                count += insertionPoint;
            }

        }

        count -=(long)l*((long)l+1)/2;

        if(count > 1e7) return -1;

        return (int)count;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(new int[]{1,5,2,1,4,0});
    }
}
