package codility.challenges.rho2012;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private static final double L2 = Math.log(2);

    public int[] solution(int A) {
        // write your code in Java SE 8
        int[] retVal = new int[A];
        retVal[0] = 1;
        if (A==1) {
            return Arrays.copyOfRange(retVal, 0, A);
        }
        retVal[1] = 2;
        if (A<=2) {
            return Arrays.copyOfRange(retVal, 0, A);
        }
        int i = 1;
        for (; Math.pow(2,i+1) <= A; i++) {
            retVal[i+1] = (int)Math.pow(2,i+1);
        }
        while(retVal[i] != A) {
            retVal[i+1] = retVal[i] + (int)Math.pow(2,(int) (Math.log(A-retVal[i])/L2));
            i++;
        }
        return Arrays.copyOfRange(retVal, 0, i + 1);
    }

    public static final void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(42));
    }
}