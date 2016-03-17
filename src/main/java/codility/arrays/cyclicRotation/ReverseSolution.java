package codility.arrays.cyclicRotation;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class ReverseSolution {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A.length > 0) {
            K %= A.length;
            if (K < 0) {
                K += A.length;
            }
            reverse(A, 0, A.length - 1);
            reverse(A, 0, K - 1);
            reverse(A, K, A.length - 1);
        }
        return A;
    }

    private void reverse(int[] A, int start, int end) {
        for (int i = start; i < start + ((end - start + 1) / 2); i++) {
            int temp = A[i];
            A[i] = A[end - (i - start)];
            A[end - (i - start)] = temp;
        }
    }

    public static void main(String... args) {
        ReverseSolution s = new ReverseSolution();

        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, 2)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, 3)));
    }

}
