package codility.arrays.cyclicRotation;

import java.util.Arrays;

/**
 * Created by crespis on 3/14/2016.
 */
public class InPlaceSolution {

    private int getIdx(int idx, int L) {
        int rem = idx % L;
        if (rem < 0) {
            return rem + L;
        } else {
            return rem;
        }
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int L = A.length;
        int counter = 0;
        int idx = 0;

        while (counter < L) {
            int j = idx;
            // first swap
            int temp = A[getIdx(j + K, L)];
            A[getIdx(j + K, L)] = A[j];
            counter++;
            j = getIdx(j + K, L);
            int runTemp = A[getIdx(j + K, L)];

            while (j != idx) {
                A[getIdx(j + K, L)] = temp;
                counter++;
                j = getIdx(j + K, L);
                temp = runTemp;
                runTemp = A[getIdx(j + K, L)];
            }

            idx++;
        }
        return A;
    }

    public static void main(String... args) {
        InPlaceSolution s = new InPlaceSolution();

        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, 2)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 5, 7, 9}, 3)));
    }

}
