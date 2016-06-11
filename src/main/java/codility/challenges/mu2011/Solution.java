package codility.challenges.mu2011;

import java.math.BigInteger;

class Solution {
    public int solution(String S) {

        BigInteger mod = new BigInteger("1410000017");
        int numberOf0inDecRep = 0;
        BigInteger N = BigInteger.ZERO;
        BigInteger tot = BigInteger.ZERO;
        for (int j = 0; j < S.length(); j++) {
            tot = tot.multiply(BigInteger.valueOf(10)).add(mod).add(N).subtract(BigInteger.valueOf(numberOf0inDecRep * (9 - Character.getNumericValue(S.charAt(j))))).mod(mod);
            if (S.charAt(j) == '0') {
                numberOf0inDecRep += 1;
            }
            N = N.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(Character.getNumericValue(S.charAt(j)))).mod(mod);
        }
        return tot.add(BigInteger.ONE).mod(mod).intValue();
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(""));
    }
}