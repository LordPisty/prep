package binaryGap;

/**
 * Created by crespis on 3/14/2016.
 */
class Solution {
    public int solution(int N) {
        // write your code in Java SE 8

        int maxS = 0;
        int currS = 0;

        // skip trailing zeros
        while (N > 0 && N % 2 == 0) {
            N = N / 2;
        }

        N = N / 2;

        while (N > 0) {
            if (N % 2 == 1) {
                if (currS > maxS) {
                    maxS = currS;
                }
                currS = 0;
            } else {
                currS += 1;
            }
            N = N / 2;
        }

        return maxS;
    }
}
