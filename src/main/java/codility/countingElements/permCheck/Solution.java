package codility.countingElements.permCheck;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // can't use sum cause it could be tricked

        int[] occ = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 >= A.length) {
                return 0;
            }
            occ[A[i] - 1] += 1;
        }
        for (int i = 0; i < A.length; i++) {
            if (occ[i] == 0) {
                return 0;
            }
        }
        return 1;
    }
}
