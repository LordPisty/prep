package codility.prefixSums.genomicRangeQuery;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] retVal = new int[P.length];

        int[] As = new int[S.length() + 1];
        int[] Cs = new int[S.length() + 1];
        int[] Gs = new int[S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            int a = 0;
            int c = 0;
            int g = 0;
            switch (S.charAt(i)) {
                case 'A':
                    a = 1;
                    break;
                case 'C':
                    c = 1;
                    break;
                case 'G':
                    g = 1;
                    break;
            }
            As[i+1] = As[i] + a;
            Cs[i+1] = Cs[i] + c;
            Gs[i+1] = Gs[i] + g;
        }

        for (int j = 0; j < P.length; j++) {
            if (As[Q[j] + 1] - As[P[j]] > 0) {
                retVal[j] = 1;
            } else if (Cs[Q[j] + 1] - Cs[P[j]] > 0) {
                retVal[j] = 2;
            } else if (Gs[Q[j] + 1] - Gs[P[j]] > 0) {
                retVal[j] = 3;
            } else {
                retVal[j] = 4;
            }
        }

        return retVal;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution("GT", new int[]{0,0,1}, new int[]{0, 1, 1});
    }
}
