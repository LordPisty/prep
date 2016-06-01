package codility.prime2016.rectangleBuilderGreaterArea;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A, int X) {
        // write your code in Java SE 8
        BigInteger x = BigInteger.valueOf(X);
        int retVal = 0;
        Arrays.sort(A);
        int[] uniques = new int[A.length];
        int[] counts = new int[A.length];
        int size = 0;
        int current = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                current++;
            } else {
                if (current > 1) {
                    uniques[size] = A[i-1];
                    counts[size] = current;
                    size++;
                }
                current = 1;
            }
        }

        if (current > 1) {
            uniques[size] = A[A.length-1];
            counts[size] = current;
            size++;
        }

        for (int j = 0; j < size; j++) {
            if (counts[j]>3 && BigInteger.valueOf(uniques[j]).multiply(BigInteger.valueOf(uniques[j])).compareTo(x) >= 0) {
                retVal++;
            }
        }

        int i = 0;
        int j = size-1;
        while (i < j) {
            if (BigInteger.valueOf(uniques[i]).multiply(BigInteger.valueOf(uniques[j])).compareTo(x) >= 0) {
                retVal += j-i;
                j--;
            } else {
                i++;
            }
            if (retVal > 1000000000) {
                return -1;
            }
        }

        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,2,5,1,1,2,3,5,1,2,2,3,3,3,5,5}, 3));
    }
}
