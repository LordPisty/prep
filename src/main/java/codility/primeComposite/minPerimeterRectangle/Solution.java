package codility.primeComposite.minPerimeterRectangle;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int sN = (int) Math.sqrt(N);
        while (N%sN != 0) {
            sN--;
        }
        return (sN + (N/sN))*2;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        s.solution(10);
    }
}
