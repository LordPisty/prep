package codility.gamma2011;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution2 {

    public int solution(String S) {
        // write your code in Java SE 8
        char[] array = S.toCharArray();
        String[] sArray = new String[array.length];
        for (int i =0; i<array.length; i++) {
            sArray[i]= String.valueOf(array[i]);
        }
        String s = "#" + String.join("#", sArray) + "#";
        int L = s.length();
        int[] P = new int[L];
        int C = 0;
        int R = 0;

        int retVal = 0;

        for (int i = 1; i < L-1; i++) {
            int iM = 2*C - i; // C - (i - C)
            P[i] = (R > i) ? Math.min(R-i, P[iM]) : 0;

            // expand palindrome centered i
            while (i + 1 + P[i] < L && i - 1 - P[i] >= 0 && s.charAt(i + 1 + P[i]) == s.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            retVal += P[i] / 2;
            if (retVal > 100000000) {
                return -1;
            }
        }
        return retVal;
    }

    public static void main(String... args) {
        System.out.println(new Solution2().solution("baababa"));
    }
}
