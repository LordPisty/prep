package codility.challenges.pi2012;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int[] retVal = new int[A.length];

        int[] stack = new int[A.length];
        int stackSize = 0;
        int[] uStack = new int[A.length];
        int uStackSize = 0;
        for (int j = 0; j< A.length; j++) {
            while (stackSize > 0 && A[stack[stackSize-1]] < A[j]) {
                if (retVal[stack[stackSize-1]] == 0 || j - stack[stackSize-1] < retVal[stack[stackSize-1]]) {
                    retVal[stack[stackSize-1]] = j - stack[stackSize-1];
                }
                stackSize--;
            }
            if (stackSize == 0) {
                uStackSize = 0;
            }
            while(uStackSize > 0 && A[uStack[uStackSize-1]] != A[stack[stackSize-1]]) {
                uStackSize--;
            }
            if (stackSize > 0) {
                if (A[stack[stackSize - 1]] != A[j]) {
                    if (retVal[j] == 0 || j - stack[stackSize - 1] < retVal[j]) {
                        retVal[j] = j - stack[stackSize - 1];
                    }
                } else {
                    if (uStackSize > 1 && (retVal[j] == 0 || j - uStack[uStackSize-2] < retVal[j])) {
                        retVal[j] = j - uStack[uStackSize-2];
                    }
                }
            }
            stack[stackSize++] = j;
            if (uStackSize == 0 || A[stack[stackSize - 1]] != A[uStack[uStackSize-1]]) {
                uStack[uStackSize++] = j;
            } else {
                uStack[uStackSize-1] = j;
            }
        }

        if (stackSize > 0) {
            int currMaxIdx = 0;
            for(int i = 1; i < stackSize; i++) {
                if (A[stack[i]] < A[stack[currMaxIdx]]) {
                    if (retVal[stack[i]] == 0 || stack[i] - stack[currMaxIdx] < retVal[stack[i]]) {
                        retVal[stack[i]] = stack[i] - stack[currMaxIdx];
                    }
                } else {
                    currMaxIdx = i;
                }
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
        System.out.println(s.solution(new int[]{2,1,1,1,1,1,10}));
        System.out.println(s.solution(new int[]{4, 3, 1, 4, -1, 2, 1, 5, 7}));
    }
}