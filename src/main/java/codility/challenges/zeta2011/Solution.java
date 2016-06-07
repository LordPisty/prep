package codility.challenges.zeta2011;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    private int[][] A;
    private int K;
    private int[] b;
    private int[] r;

    private void calculate(int x, int y) {
        if (x == 0) {
            if (y == 0) {
                switch (A[x][y]) {
                    case -1:
                        b[y] = (K+1)/2;
                        r[y] = K/2;
                        break;
                    case 0:
                        b[y] = K;
                        r[y] = 0;
                        break;
                    case 1:
                        b[y] = K/2;
                        r[y] = (K+1)/2;
                        break;
                }
            } else {
                int tot = r[y-1];
                switch (A[x][y]) {
                    case -1:
                        b[y] = (tot+1)/2;
                        r[y] = tot/2;
                        break;
                    case 0:
                        b[y] = 0;
                        r[y] = tot;
                        break;
                    case 1:
                        b[y] = tot/2;
                        r[y] = (tot+1)/2;
                        break;
                }
            }
        } else {
            int tot = b[y]+(y>0 ? r[y-1] : 0);
            switch (A[x][y]) {
                case -1:
                    b[y] = (tot+1)/2;
                    r[y] = tot/2;
                    break;
                case 0:
                    b[y] = b[y];
                    r[y] = (y>0 ? r[y-1] : 0);
                    break;
                case 1:
                    b[y] = tot/2;
                    r[y] = (tot+1)/2;
                    break;
            }
        }
    }

    public int solution(int[][] A, int K) {
        // write your code in Java SE 8
        int retVal = 0;

        this.A = A;
        this.K = K;
        int N = A.length;
        if (N != 0) {
            int M = A[0].length;

            b = new int[M];
            r = new int[M];

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    calculate(x, y);
                }
            }

            retVal += b[M-1];
        }

        return retVal;
    }
}