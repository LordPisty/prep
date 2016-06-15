package codility.challenges.pi2012;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int[] retVal = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            retVal[i] = Integer.MAX_VALUE;
        }

        int[] stack = new int[A.length];
        int stackSize = 0;

        for (int j = 0; j< A.length; j++) {
            while (stackSize > 0 && A[stack[stackSize-1]] < A[j]) {
                if (j - stack[stackSize-1] < retVal[stack[stackSize-1]]) {
                    retVal[stack[stackSize-1]] = j - stack[stackSize-1];
                }
                stackSize--;
            }
            if (stackSize > 0 && A[stack[stackSize - 1]] != A[j]) {
                if (j - stack[stackSize-1] < retVal[j]) {
                    retVal[j] = j - stack[stackSize-1];
                }
            }
            stack[stackSize++] = j;
        }

        if (stackSize > 0) {
            int currMaxIdx = 0;
            for(int i = 1; i < stackSize; i++) {
                if (A[stack[i]] < A[stack[currMaxIdx]]) {
                    if (stack[i] - stack[currMaxIdx] < retVal[stack[i]]) {
                        retVal[stack[i]] = stack[i] - stack[currMaxIdx];
                    }
                } else {
                    currMaxIdx = i;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (retVal[i] == Integer.MAX_VALUE) {
                retVal[i] = 0;
            }
        }

        return retVal;
    }

    public int[] solution2(int[] A) {
        // write your code in Java SE 8
        int[] retVal = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            retVal[i] = Integer.MAX_VALUE;
        }

        int[] stack = new int[A.length];
        int stackSize = 0;

        for (int j = 0; j< A.length; j++) {
            while (stackSize > 0 && A[stack[stackSize-1]] <= A[j]) {
                stackSize--;
            }
            if (stackSize > 0) {
                if (j - stack[stackSize-1] < retVal[j]) {
                    retVal[j] = j - stack[stackSize-1];
                }
            }
            stack[stackSize++] = j;
        }

        stack = new int[A.length];
        stackSize = 0;

        for (int j = A.length -1; j>=0; j--) {
            while (stackSize > 0 && A[stack[stackSize-1]] <= A[j]) {
                stackSize--;
            }
            if (stackSize > 0) {
                if (stack[stackSize-1] - j < retVal[j]) {
                    retVal[j] = stack[stackSize-1] - j;
                }
            }
            stack[stackSize++] = j;
        }


        for (int i = 0; i < A.length; i++) {
            if (retVal[i] == Integer.MAX_VALUE) {
                retVal[i] = 0;
            }
        }

        return retVal;
    }

    public static final void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{5,2,5,4,4,4}));

        System.out.println(s.solution(new int[]{4, 3, 1, 4, -1, 2, 1, 5, 7}));
    }
}