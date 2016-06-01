package codility.prime2016.treeProduct;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public String solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }


        return "NO SOLUTION";
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{4,5,3,7,2}));
    }
}
