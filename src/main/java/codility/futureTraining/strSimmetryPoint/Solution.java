package codility.futureTraining.strSimmetryPoint;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(String S) {
        // write your code in Java SE 8
        if (S.length() % 2 == 0) {
            return -1;
        } else if (S.length() == 1) {
            return 0;
        } else {
            for (int i = 0; i <= S.length()/2; i++) {
                if (S.charAt(i) != S.charAt(S.length() - 1 - i)) {
                    return -1;
                }
            }
            return S.length()/2;
        }
    }
}
