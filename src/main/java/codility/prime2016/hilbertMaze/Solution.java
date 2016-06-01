package codility.prime2016.hilbertMaze;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private boolean internal(int x, int y) {
        return x > 0 && x < 4 && y < 3;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public int solution(int N, int A, int B, int C, int D) {
        // write your code in Java SE 8
        if (N == 1) {
            if (internal(A, B) && !internal(C, D)) {
                if (C >= 2) {
                    return distance(A, B, 4, 0) + distance(4, 0, C, D);
                } else {
                    return distance(A, B, 0, 0) + distance(0, 0, C, D);
                }
            }

            if (internal(C, D) && !internal(A, B)) {
                if (A >= 2) {
                    return distance(C, D, 4, 0) + distance(4, 0, A, B);
                } else {
                    return distance(C, D, 0, 0) + distance(0, 0, A, B);
                }
            }

            return distance(A,B,C,D);
        } else {

        }
        return 0;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(1, 0,4,4,0));
    }

}
