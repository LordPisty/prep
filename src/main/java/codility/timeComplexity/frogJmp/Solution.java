package codility.timeComplexity.frogJmp;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int retVal = (Y - X) / D;
        if ((Y - X) % D > 0) {
            retVal += 1;
        }
        return retVal;
    }
}
