package codility.sieveErathostenes.countNonDivisible;

/**
 * Created by crespis on 4/11/2016.
 */
class Solution {
    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] counts = new int[N * 2 + 1];
        for (int number : A) {
            counts[number]++;
        }

        int[] divs = new int[counts.length];
        for (int i = 1; i * i < divs.length; i++) {
            // start from i^2: previous minor divisors already counted
            for (int j = i * i; j < divs.length; j += i) {
                divs[j] += counts[i];
                if (j != i * i) {
                    // count other factor so then we can start from i^2
                    divs[j] += counts[j / i];
                }
            }
        }

        int[] retVal = new int[N];
        for (int j = 0; j < N; j++) {
            retVal[j] = N - divs[A[j]];
        }
        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(new int[]{3,1,2,3,6});
    }
}