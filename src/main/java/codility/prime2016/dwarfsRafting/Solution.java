package codility.prime2016.dwarfsRafting;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int N, String S, String T) {
        // write your code in Java SE 8
        int avail = (int) Math.pow(N / 2, 2);
        int[][] spots = new int[2][];
        int[][] current = new int[2][];
        spots[0] = new int[]{avail, avail};
        spots[1] = new int[]{avail, avail};
        current[0] = new int[2];
        current[1] = new int[2];

        if (S.length() > 0) {
            for (String s : S.split(" ")) {
                spots[Character.getNumericValue(s.charAt(0)) - 1 < N / 2 ? 0 : 1][(s.charAt(1) - 'A') < N / 2 ? 0 : 1]--;
            }
        }

        if (T.length() > 0) {
            for (String s : T.split(" ")) {
                current[Character.getNumericValue(s.charAt(0)) - 1 < N / 2 ? 0 : 1][(s.charAt(1) - 'A') < N / 2 ? 0 : 1]++;
                spots[Character.getNumericValue(s.charAt(0)) - 1 < N / 2 ? 0 : 1][(s.charAt(1) - 'A') < N / 2 ? 0 : 1]--;
            }
        }

        if ((current[0][0] > current[1][1]+spots[1][1]) ||
                (current[1][1] > current[0][0]+spots[0][0]) ||
                (current[0][1] > current[1][0]+spots[1][0]) ||
                (current[1][0] > current[0][1]+spots[0][1])) {
            return -1;
        }

        if (current[1][1] > current[0][0]) {
            int diff = (current[1][1] - current[0][0]);
            spots[0][0] -= diff;
            current[0][0] += diff;
        } else {
            int diff = (current[0][0] - current[1][1]);
            spots[1][1] -= diff;
            current[1][1] += diff;
        }

        if (current[1][0] > current[0][1]) {
            int diff = (current[1][0] - current[0][1]);
            spots[0][1] -= diff;
            current[0][1] += diff;
        } else {
            int diff = (current[0][1] - current[1][0]);
            spots[1][0] -= diff;
            current[1][0] += diff;
        }

        int add1 = Math.min(spots[0][0], spots[1][1]);
        current[0][0] += add1;
        current[1][1] += add1;

        int add2 = Math.min(spots[0][1], spots[1][0]);
        current[0][1] += add2;
        current[1][0] += add2;

        return current[0][0] + current[1][1] + current[0][1] + current[1][0] - (T.length() > 0 ? T.split(" ").length : 0);
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, "1B 1C 4B 1D 2A", "3B 2D"));
    }
}
