package codility.prefixSums.countDiv;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        return B/K - A/K + (A%K == 0 ? 1 : 0);
    }
}
