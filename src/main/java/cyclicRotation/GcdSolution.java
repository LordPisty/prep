package cyclicRotation;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class GcdSolution {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int N = A.length;
        if (N > 0) {
            K %= N;
            if (K < 0) {
                K += N;
            }
            int d = gcd(N, K);
            for (int i = 0; i < d; i++) {
                int temp = A[i];
                for (int j = getIdx(i - K, N); j != i; j = getIdx(j - K, N) % N)
                    A[getIdx(j + K, N)] = A[j];
                A[getIdx(i + K, N)] = temp;
            }
        }
        return A;
    }

    private int getIdx(int idx, int L) {
        int rem = idx % L;
        if (rem < 0) {
            return rem + L;
        } else {
            return rem;
        }
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int c = a;
            a = b;
            b = c % a;
        }
        return a;
    }

    public static void main(String... args) {
        GcdSolution s = new GcdSolution();

        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, 2)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, 3)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, -2)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, -3)));
    }

}
