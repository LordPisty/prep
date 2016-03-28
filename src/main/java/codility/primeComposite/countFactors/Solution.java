package codility.primeComposite.countFactors;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        if (N <= 0) return 0;
        if (N == 1) return 1;

        int retVal = 0;
        int i = 1;
        int sN = (int) Math.sqrt(N);
        while (i <= sN) {
            if (N%i == 0) {
                retVal += 2;
            }
            i++;
        }
        if (sN * sN == N) {
            retVal++;
        }
        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(2);
    }
}
