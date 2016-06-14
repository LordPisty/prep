package codility.challenges.xi2012;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private static final int MOD = 1000000007;
    private int[] F;

    private String increase(String input) {
        int lastZ = input.lastIndexOf('0');
        String retVal = lastZ != -1 ? input.substring(0,lastZ) + "1" : input;
        for (int i=0; lastZ >= 0 && i< input.length() - 1 - lastZ; i++) {
            retVal += "0";
        }
        return retVal;
    }

    private int belowSparse(String S, int K) {
        int L = S.length();
        int res = 0;
        for (int i=0; i<L; i++){
            if (S.charAt(i) == '1') {
                res = (res + F[L-i-1]) % MOD;
            }
        }
        return res;
    }


    private int below(String S, int K) {
        S = "0" + S;
        int L = S.length();
        int c = K+1;
        int i = 0;
        int j = 0;
        while (i < L) {
            if (S.charAt(i) == '1') {
                if (c < K) {
                    break;
                } else {
                    if (c > K) {
                        j = i;
                    }
                }
                c = 0;
            } else {
                c+= 1;
            }
            i += 1;
        }
        if (i < L) {
            S = S.substring(0,j-1) + "1";
            for (int z = 0; z < L-j; z++) {
                S+="0";
            }
        }
        return belowSparse(S, K);
    }

    public int solution(String S, String T, int K) {
        // write your code in Java SE 8
        F = new int[T.length()+2];
        for (int i = 0; i < F.length; i++) {
            F[i]=1;
        }
        for (int i = 1; i < F.length; i++) {
            if (i > K) {
                F[i] = (F[i-1] + F[i-K-1]) % MOD;
            } else {
                F[i] = (F[i-1] + 1) % MOD;
            }
        }
        return (below(increase(T), K) - below(S, K) + MOD) % MOD;
    }

    public static final void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution("101","1111",2));
    }
}